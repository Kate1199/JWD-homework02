package by.epam.kisel.utility;

public class NoSuchBallAtBasketException extends Exception {

	public NoSuchBallAtBasketException() {
		super();
	}

	public NoSuchBallAtBasketException(String message) {
		super(message);
	}

	public NoSuchBallAtBasketException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchBallAtBasketException(Throwable cause) {
		super(cause);
	}
}
