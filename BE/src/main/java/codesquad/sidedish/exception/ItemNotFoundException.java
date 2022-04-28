package codesquad.sidedish.exception;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException() {
    }

    public ItemNotFoundException(String message) {
        super(message);
    }
}
