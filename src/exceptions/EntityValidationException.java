package exceptions;

public class EntityValidationException extends RuntimeException {
	public EntityValidationException(String message) {
		super(message);
	}
}
