
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

interface CrudRepository<T, ID> {
    T save(T item);

    Optional<T> findById(ID id);

    List<T> findAll();

    boolean deleteById(ID id);
}

public class StudentRepository implements CrudRepository<Student, Integer> {
    private final Map<Integer, Student> students = new HashMap<>();

    @Override
    public Student save(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (students.containsKey(student.getId())) {
            throw new IllegalArgumentException("Duplicate student ID");
        }
        students.put(student.getId(), student);
        return student;
    }

    @Override
    public Optional<Student> findById(Integer id) {
        return Optional.ofNullable(students.get(id));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public boolean deleteById(Integer id) {
        return students.remove(id) != null;
    }
}
