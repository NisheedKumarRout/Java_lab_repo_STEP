public class Student {
    // Private instance variables (Encapsulation principle)
    private String studentId;
    private String name;
    private double grade;
    private String course;

    // Default constructor (no parameters)
    public Student() {
        // values remain uninitialized until set using setters
    }

    // Parameterized constructor (initializes all attributes)
    public Student(String studentId, String name, double grade, String course) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.course = course;
    }

    // Getter and Setter methods for all attributes
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    // Method to calculate letter grade based on numeric grade
    public String calculateLetterGrade() {
        if (grade >= 90) return "A";
        else if (grade >= 80) return "B";
        else if (grade >= 70) return "C";
        else if (grade >= 60) return "D";
        else return "F";
    }

    // Method to display student information
    public void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Grade: " + grade);
        System.out.println("Letter Grade: " + calculateLetterGrade());
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        // Student created using default constructor + setters
        Student s1 = new Student();
        s1.setStudentId("S001");
        s1.setName("Alice");
        s1.setGrade(92.5);
        s1.setCourse("Computer Science");

        // Student created using parameterized constructor
        Student s2 = new Student("S002", "Bob", 76.3, "Mathematics");

        // Demonstrate getter usage
        System.out.println("Getter Example: " + s1.getName() + " is enrolled in " + s1.getCourse());

        // Display both students' information
        s1.displayStudent();
        s2.displayStudent();
    }
}
