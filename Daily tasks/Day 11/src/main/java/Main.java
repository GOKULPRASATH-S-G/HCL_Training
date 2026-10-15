
public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();

        service.addStudent(new Student(101, "Arun", 20, 85.5));
        service.addStudent(new Student(102, "Priya", 21, 92.0));
        service.addStudent(new Student(103, "Kumar", 19, 76.0));

        System.out.println("=== Student Directory ===");

        for (Student student : service.getAllStudents()) {
            System.out.println(student);
        }

        System.out.println("\n=== Search Student ===");
        service.findById(102).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Student not found"));

        System.out.printf(
                "%nAverage Marks: %.2f%n",
                service.calculateAverageMarks());

        System.out.println("\n=== Validation Test ===");
        try {
            service.addStudent(new Student(104, "", 20, 80));
        } catch (IllegalArgumentException e) {
            System.out.println("Validation caught: " + e.getMessage());
        }

        try {
            service.addStudent(new Student(101, "Duplicate", 20, 80));
        } catch (IllegalArgumentException e) {
            System.out.println("Duplicate caught: " + e.getMessage());
        }
    }
}
