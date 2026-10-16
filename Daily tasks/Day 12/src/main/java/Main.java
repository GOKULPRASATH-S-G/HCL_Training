
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        StudentRepository repository = new StudentRepository();

        System.out.println("=== Core Java Checkpoint ===");

        // Collections and object creation
        repository.save(new Student(103, "Kumar", 76.0));
        repository.save(new Student(101, "Arun", 85.5));
        repository.save(new Student(102, "Priya", 92.0));

        // Exception handling
        try {
            repository.save(new Student(104, "", 70));
        } catch (IllegalArgumentException e) {
            System.out.println("Validation: " + e.getMessage());
        }

        // Map-based lookup and Optional
        Optional<Student> result = repository.findById(102);
        System.out.println("\nSearch ID 102:");
        System.out.println(result.orElse(null));

        // Comparable: sort by student ID
        List<Student> students = repository.findAll();
        students.sort(null);

        System.out.println("\nSorted by ID:");
        students.forEach(System.out::println);

        // Comparator: sort by marks, highest first
        students.sort(
                Comparator.comparingDouble(Student::getMarks)
                        .reversed()
                        .thenComparing(Student::getName));

        System.out.println("\nSorted by marks:");
        students.forEach(System.out::println);

        // Stream API
        double average = students.stream()
                .mapToDouble(Student::getMarks)
                .average()
                .orElse(0.0);

        System.out.printf("%nAverage marks: %.2f%n", average);

        long passed = students.stream()
                .filter(s -> s.getMarks() >= 50)
                .count();

        System.out.println("Students passed: " + passed);

        // Generic max method
        System.out.println("Highest marks: " +
                max(85.5, 92.0, 76.0));

        // Delete operation
        System.out.println("Deleted ID 103: " +
                repository.deleteById(103));

        System.out.println("Final student count: " +
                repository.findAll().size());
    }

    public static <T extends Comparable<T>> T max(
            T first, T second, T third) {
        T largest = first;

        if (second.compareTo(largest) > 0) {
            largest = second;
        }
        if (third.compareTo(largest) > 0) {
            largest = third;
        }
        return largest;
    }
}
