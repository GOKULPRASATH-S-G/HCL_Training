package exception;

public class PetUnavailableException extends Exception {

    public PetUnavailableException() {
        super();
    }

    public PetUnavailableException(String message) {
        super(message);
    }

    public PetUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public PetUnavailableException(Throwable cause) {
        super(cause);
    }
}
