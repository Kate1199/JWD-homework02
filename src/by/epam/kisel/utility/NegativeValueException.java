package by.epam.kisel.utility;

public class NegativeValueException extends RuntimeException{
	
	public NegativeValueException() {
		super();
	}
	
	public NegativeValueException(String message) {
		super(message);
	}
	
	public NegativeValueException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public NegativeValueException(Throwable cause) {
		super(cause);
	}
}
