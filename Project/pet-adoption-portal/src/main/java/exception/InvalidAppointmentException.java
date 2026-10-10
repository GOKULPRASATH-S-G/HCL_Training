package exception;

public class InvalidAppointmentException extends Exception {

    public InvalidAppointmentException() {
        super();
    }

    public InvalidAppointmentException(String message) {
        super(message);
    }

    public InvalidAppointmentException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidAppointmentException(Throwable cause) {
        super(cause);
    }
}
