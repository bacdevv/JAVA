package main.java.iuh.edu.iuh.fit;

public class Course {
    private int credit;
    private String department;
    private String id;
    private String title;

    // Constructor
    public Course() {}

    // Constructor using order: id, title, credit, department
    public Course(String id, String title, int credit, String department) {
        setId(id);
        setTitle(title);
        setCredit(credit);
        setDepartment(department);
    }

    // Getter
    public int getCredit() { return credit; }
    public String getDepartment() { return department; }
    public String getId() { return id; }
    public String getTitle() { return title; }

    // Setter 
    // Credit
    public void setCredit(int credit) {
        if (credit <= 0) {
            throw new IllegalArgumentException("Credit must be greater than 0");
        }
        this.credit = credit;
    }

    // Department 
    public void setDepartment(String department) {
         this.department = department;
    }

    // Id
    public void setId(String id) {
        if (id == null || id.length() < 3) {
            throw new IllegalArgumentException("ID must have at least 3 characters");
        }
        else if (!(id.matches("[a-zA-Z0-9]+"))) {
            throw new IllegalArgumentException("ID must contain only letters or digits");
        }

        this.id = id;
    }

    // Title
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }

        this.title = title;
    }

    @Override
    public String toString() {
        return String.format(
            "%-10s %-20s %-5d %-15s",
                id, title, credit, department
        );
    }
}