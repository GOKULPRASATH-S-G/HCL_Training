package order.exception;

public class InvalidOrderException extends OrderProcessingException {

    public InvalidOrderException() {
        super();
    }

    public InvalidOrderException(String message) {
        super(message);
    }

    public InvalidOrderException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidOrderException(Throwable cause) {
        super(cause);
    }
}
