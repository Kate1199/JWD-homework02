package by.epam.kisel.utility;

public class BasketSmallerThanBallException extends Exception {

	public BasketSmallerThanBallException() {
		super();
	}

	public BasketSmallerThanBallException(String message) {
		super(message);
	}

	public BasketSmallerThanBallException(String message, Throwable cause) {
		super(message, cause);
	}

	public BasketSmallerThanBallException(Throwable cause) {
		super(cause);
	}
}
