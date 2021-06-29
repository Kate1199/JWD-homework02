package by.epam.kisel.bean.basket;

import by.epam.kisel.bean.ball.Ball;

public class RoundBasket extends Basket implements BasketParams {

	private double diameter;
	private static final double MIN_DIAMETER = 1;
	
	public RoundBasket() {
		super();
		diameter = MIN_DIAMETER;
	}

	public RoundBasket(double diameter, double height, double weightCapacity) {
		this.diameter = diameter;
		setHeight(height);
		setWeightCapacity(weightCapacity);
		setVolume(countVolume());
	}
	
	public double getDiameter() {
		return diameter;
	}

	@Override
	public double countVolume() {
		double volume = Math.PI * getHeight() * Math.pow(diameter, 2) / 4;
		return volume;
	}

	@Override
	public boolean isSmallerThan(Ball ball) {
		boolean smallerThanBall;
		boolean moreThanBasketHeigh = super.isHeightSmallerThan(ball);
		boolean moreThanBasketDiameter = ball.getDiameter() > diameter;

		smallerThanBall = moreThanBasketDiameter || moreThanBasketHeigh;
		return smallerThanBall;
	}

	@Override
	public boolean add(Ball ball) {
		boolean add = !isSmallerThan(ball);
		return add && super.add(ball);
	}
	
	@Override
	public int hashCode() {
		int hash = (int) (super.hashCode() + diameter) * 31;
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

		RoundBasket other = (RoundBasket) obj;

		return diameter == other.diameter 
				&& getHeight() == other.getHeight()
				&& getVolume() == other.getVolume()
				&& getWeightCapacity() == other.getWeightCapacity();
	}

}
