
class MyResource implements AutoCloseable {
    private final String name;

    public MyResource(String name) {
        this.name = name;
        System.out.println(name + " opened");
    }

    @Override
    public void close() {
        System.out.println(name + " closed");
    }
}

public class ResourceDemo {
    public static void main(String[] args) {
        System.out.println("Starting resource demo");

        try (MyResource first = new MyResource("Resource A");
                MyResource second = new MyResource("Resource B");
                MyResource third = new MyResource("Resource C")) {

            System.out.println("Inside try block");

        } // Resources close automatically here, in reverse order.

        System.out.println("Resource demo completed");
    }
}
