package exceptions;

@SuppressWarnings("serial")
public class EtatIncorrectException extends RuntimeException {
	EtatIncorrectException (String message) {
		super(message);
	}
}