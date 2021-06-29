package by.epam.kisel.bean.basket;

import by.epam.kisel.bean.ball.Ball;

public class RectangleBasket extends Basket implements BasketParams {

	private double length;
	private double width;
	
	private static final double MIN_LENGTH = 20;
	private static final double MIN_WIDTH = 20;

	public RectangleBasket() {
		super();
		length = MIN_LENGTH;
		width = MIN_WIDTH;
	}

	public RectangleBasket(double length, double width, double height, double weightCapacity) {
		this.length = length;
		this.width = width;
		setHeight(height);
		setVolume(countVolume());
		setWeightCapacity(weightCapacity);
		
	}
	
	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
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
	public boolean add(Ball ball)  {
		boolean add = !isSmallerThan(ball);
		return add && super.add(ball);
	}

	@Override
	public int hashCode() {
		return (int) (super.hashCode() + length * 31 - width * 31);
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

		return length == other.length 
				&& width == other.width 
				&& getHeight() == other.getHeight()
				&& getVolume() == other.getVolume()
				&& getWeightCapacity() == other.getWeightCapacity();
	}

}
