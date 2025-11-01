package main.java.iuh.edu.iuh.fit;

import java.util.*;

public class CourseList {
    private int count = 0;
    private Course[] courses;

    public CourseList(int capacity) {
        courses = new Course[capacity];
    }

    public boolean addCourse(Course c) {
        if (c == null) return false;
        if (exists(c)) {
            System.out.println("This course already exists!");
            return false;
        }

        if (count >= courses.length) {
            System.out.println("Course list is full. Cannot add more courses.");
            return false;
        }

        courses[count++] = c;
        return true;
    }

    private boolean exists(Course c) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(c.getId())) { return true; }
        }
        return false;
    }

    public boolean removeCourse(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(id)) {
                for (int j = i; j < count - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courses[--count] = null;
                return true;
            }
        }
        System.out.println("Not found course with ID: " + id);
        return false;
    }

    public Course searchCourseById(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(id)) {
                return courses[i];
            }
        }
        return null;
    }


    public Course[] searchCourseByTitle(String title) {
        List<Course> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(courses[i]);
            }
        }
        return result.isEmpty() ? null : result.toArray(new Course[0]);
    }

    public Course[] searchCourseByDepartment(String department) {
        List<Course> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i].getDepartment().equalsIgnoreCase(department)) {
                result.add(courses[i]);
            }
        }
        return result.isEmpty() ? null : result.toArray(new Course[0]);
    }

    public Course[] getCourses() {
        return Arrays.copyOf(courses, count);
    }

    public Course[] sortCourses() {
        Course[] sorted = getCourses();
        Arrays.sort(sorted, Comparator.comparing(Course::getTitle));
        return sorted;
    }

    public Course[] findMaxCreditCourses() {
        int maxCredit = 0;
        for (int i = 0; i < count; i++) {
            maxCredit = Math.max(maxCredit, courses[i].getCredit());
        }
        List<Course> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() == maxCredit) {
                result.add(courses[i]);
            }
        }
        return result.toArray(new Course[0]);
    }

    public String findDepartmentWithMostCourses() {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            map.put(courses[i].getDepartment(),
                    map.getOrDefault(courses[i].getDepartment(), 0) + 1);
        }
        String dept = null;
        int max = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                dept = e.getKey();
            }
        }
        return dept;
    }

}