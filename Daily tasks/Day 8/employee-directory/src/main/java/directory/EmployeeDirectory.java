
package directory;

import java.util.*;

public class EmployeeDirectory {

    static class Employee implements Comparable<Employee> {
        private final int id;
        private final String name;
        private final String department;
        private final double salary;

        Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        int getId() {
            return id;
        }

        String getName() {
            return name;
        }

        String getDepartment() {
            return department;
        }

        double getSalary() {
            return salary;
        }

        // Natural ordering: employee ID.
        @Override
        public int compareTo(Employee other) {
            return Integer.compare(this.id, other.id);
        }

        // Employees are equal when their IDs are equal.
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (!(obj instanceof Employee))
                return false;

            Employee other = (Employee) obj;
            return id == other.id;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(id);
        }

        @Override
        public String toString() {
            return id + " | " + name + " | " + department
                    + " | Rs. " + salary;
        }
    }

    // Demonstrates the equals/hashCode contract violation.
    static class BrokenEmployee {
        private final int id;

        BrokenEmployee(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (!(obj instanceof BrokenEmployee))
                return false;

            return id == ((BrokenEmployee) obj).id;
        }

        // Intentionally missing hashCode() for the demonstration.
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(104, "Kumar", "IT", 65000),
                new Employee(101, "Anu", "HR", 45000),
                new Employee(103, "Bala", "IT", 75000),
                new Employee(102, "Priya", "Finance", 80000),
                new Employee(105, "Divya", "Finance", 75000),
                new Employee(106, "Arun", "IT", 55000)));

        // 1. HashMap: direct lookup by employee ID.
        Map<Integer, Employee> employeeById = new HashMap<>();

        for (Employee employee : employees) {
            employeeById.put(employee.getId(), employee);
        }

        System.out.println("=== Employee Lookup ===");
        System.out.println(employeeById.get(103));

        // 2. Frequency count using Map.merge().
        Map<String, Integer> departmentCount = new HashMap<>();

        for (Employee employee : employees) {
            departmentCount.merge(
                    employee.getDepartment(), 1, Integer::sum);
        }

        System.out.println("\n=== Department Frequency ===");
        System.out.println(departmentCount);

        // 3. TreeMap: department names are sorted.
        Map<String, List<Employee>> departmentReport = new TreeMap<>();

        for (Employee employee : employees) {
            departmentReport
                    .computeIfAbsent(
                            employee.getDepartment(), key -> new ArrayList<>())
                    .add(employee);
        }

        System.out.println("\n=== Sorted Department Report ===");
        departmentReport.forEach((department, members) -> {
            System.out.println(department + ": " + members.size());
        });

        // 4. Comparable: sort employees by ID.
        Collections.sort(employees);

        System.out.println("\n=== Employees Sorted by ID ===");
        employees.forEach(System.out::println);

        // 5. Comparator chain: salary descending,
        // then name ascending, then ID ascending.
        Comparator<Employee> salaryComparator = Comparator.comparingDouble(Employee::getSalary)
                .reversed()
                .thenComparing(Employee::getName)
                .thenComparingInt(Employee::getId);

        System.out.println("\n=== Top 5 Salaries ===");
        employees.stream()
                .sorted(salaryComparator)
                .limit(5)
                .forEach(System.out::println);

        // 6. Demonstrate the equals/hashCode contract bug.
        Set<BrokenEmployee> brokenSet = new HashSet<>();
        brokenSet.add(new BrokenEmployee(1));
        brokenSet.add(new BrokenEmployee(1));

        System.out.println("\n=== Missing hashCode Demonstration ===");
        System.out.println("Broken set size: " + brokenSet.size());

        Set<Employee> correctSet = new HashSet<>();
        correctSet.add(new Employee(1, "A", "IT", 30000));
        correctSet.add(new Employee(1, "B", "HR", 40000));

        System.out.println("Correct set size: " + correctSet.size());
    }
}
