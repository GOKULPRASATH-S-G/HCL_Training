
import java.util.Objects;

public class Student implements Comparable<Student> {
    private final int id;
    private final String name;
    private final double marks;

    public Student(int id, String name, double marks) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (!Double.isFinite(marks) || marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be from 0 to 100");
        }

        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Student other))
            return false;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name
                + "', marks=" + marks + "}";
    }
}
