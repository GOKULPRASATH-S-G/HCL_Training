
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StudentService {
    private final Map<Integer, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }

        if (student.getId() <= 0) {
            throw new IllegalArgumentException("Student ID must be positive");
        }

        if (student.getName() == null || student.getName().isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (student.getAge() < 1 || student.getAge() > 120) {
            throw new IllegalArgumentException("Age must be between 1 and 120");
        }

        if (!Double.isFinite(student.getMarks())
                || student.getMarks() < 0
                || student.getMarks() > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }

        if (students.containsKey(student.getId())) {
            throw new IllegalArgumentException("Duplicate student ID");
        }

        students.put(student.getId(), student);
    }

    public Optional<Student> findById(int id) {
        return Optional.ofNullable(students.get(id));
    }

    public Collection<Student> getAllStudents() {
        return java.util.List.copyOf(students.values());
    }

    public double calculateAverageMarks() {
        return students.values().stream()
                .mapToDouble(Student::getMarks)
                .average()
                .orElse(0.0);
    }
}
