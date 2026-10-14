
public class Box<T extends Number> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public double getDoubleValue() {
        return value.doubleValue();
    }

    public void display() {
        System.out.println("Value: " + value);
        System.out.println("As double: " + getDoubleValue());
    }
}
