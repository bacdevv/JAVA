package main.java.iuh.edu.iuh.fit;

import java.util.Scanner;

public class TestCourse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseList cl = new CourseList(100);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add course");
            System.out.println("2. Remove course");
            System.out.println("3. Search by ID");
            System.out.println("4. Search by title");
            System.out.println("5. Search by department");
            System.out.println("6. Sort by title");
            System.out.println("7. Courses with maximum credits");
            System.out.println("8. Department with most courses");
            System.out.println("9. Display all");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Credits: ");
                    int credit = sc.nextInt(); sc.nextLine();
                    System.out.print("Department: ");
                    String dept = sc.nextLine();
                    cl.addCourse(new Course(id, title, credit, dept));
                    break;
                case 2:
                    System.out.print("Enter ID to remove: ");
                    cl.removeCourse(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    System.out.println(cl.searchCourseById(sc.nextLine()));
                    break;
                case 4:
                    System.out.print("Enter title (partial allowed): ");
                    Course[] byTitle = cl.searchCourseByTitle(sc.nextLine());
                    if (byTitle != null) for (Course c : byTitle) System.out.println(c);
                    else System.out.println("Not found");
                    break;
                case 5:
                    System.out.print("Enter department: ");
                    Course[] byDept = cl.searchCourseByDepartment(sc.nextLine());
                    if (byDept != null) for (Course c : byDept) System.out.println(c);
                    else System.out.println("Not found");
                    break;
                case 6:
                    for (Course c : cl.sortCourses()) System.out.println(c);
                    break;
                case 7:
                    for (Course c : cl.findMaxCreditCourses()) System.out.println(c);
                    break;
                case 8:
                    System.out.println("Department with most courses: " + cl.findDepartmentWithMostCourses());
                    break;
                case 9:
                    for (Course c : cl.getCourses()) System.out.println(c);
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
