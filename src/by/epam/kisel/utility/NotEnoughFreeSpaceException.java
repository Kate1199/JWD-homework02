package by.epam.kisel.utility;

public class NotEnoughFreeSpaceException extends Exception {
	
	public NotEnoughFreeSpaceException() {
		super();
	}
	
	public NotEnoughFreeSpaceException(String message) {
		super(message);
	}
	
	public NotEnoughFreeSpaceException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public NotEnoughFreeSpaceException(Throwable cause) {
		super(cause);
	}
}
