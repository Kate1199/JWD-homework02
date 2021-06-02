package by.epam.kisel.bean.basket;

import by.epam.kisel.bean.ball.Ball;
import by.epam.kisel.utility.BasketSmallerThanBallException;
import by.epam.kisel.utility.ExcessWeightException;
import by.epam.kisel.utility.NegativeValueException;
import by.epam.kisel.utility.NotEnoughFreeSpaceException;

public class RoundBasket extends Basket implements BasketParams {

	private double diameter;

	public RoundBasket(double diameter, double height, double weightCapacity) {
		this.diameter = diameter;
		setHeight(height);
		setWeightCapacity(weightCapacity);

		setFreeSpace(countVolume());
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

		return diameter == other.diameter && getHeight() == other.getHeight()
				&& getWeightCapacity() == other.getWeightCapacity();
	}

	public double getDiameter() {
		return diameter;
	}

}
