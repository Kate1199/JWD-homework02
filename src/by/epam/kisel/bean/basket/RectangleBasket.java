package by.epam.kisel.bean.basket;

import by.epam.kisel.bean.ball.Ball;
import by.epam.kisel.utility.BasketSmallerThanBallException;
import by.epam.kisel.utility.ExcessWeightException;
import by.epam.kisel.utility.NegativeValueException;
import by.epam.kisel.utility.NotEnoughFreeSpaceException;

public class RectangleBasket extends Basket implements BasketParams {

	private double length;
	private double width;

	public RectangleBasket() {
		super();
		length = 20;
		width = 20;

		setFreeSpace(countVolume());
	}

	public RectangleBasket(double length, double width, double height, double weightCapacity) {
		this.length = length;
		this.width = width;
		setHeight(height);
		setWeightCapacity(weightCapacity);

		setFreeSpace(countVolume());
	}

	@Override
	public double countVolume() {
		double volume = length * width * getHeight();
		return volume;
	}

	@Override
	public boolean isSmallerThan(Ball ball) {
		boolean smallerThanBall;
		boolean moreThanBasketHeigh = isHeightSmallerThan(ball);
		boolean moreThanBasketLength = ball.getDiameter() > length;
		boolean moreThanBasketWidth = ball.getDiameter() > width;

		smallerThanBall = moreThanBasketHeigh || moreThanBasketLength || moreThanBasketWidth;
		return smallerThanBall;
	}

	@Override
	public void add(Ball ball) throws BasketSmallerThanBallException, NotEnoughFreeSpaceException,
			ExcessWeightException, NegativeValueException {
		if (isSmallerThan(ball)) {
			throw new BasketSmallerThanBallException("Basket is smaller than ball");
		}
		super.add(ball);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public int hashCode() {
		int hash = (int) (super.hashCode() + length - width) * 31;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		RectangleBasket other = (RectangleBasket) obj;

		return length == other.length && width == other.width && getHeight() == other.getHeight()
				&& getWeightCapacity() == other.getWeightCapacity();
	}

	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}

}
