package by.epam.kisel.bean.basket;

import java.util.ArrayList;
import java.util.stream.Stream;

import by.epam.kisel.bean.ball.Ball;
import by.epam.kisel.bean.ball.BallColours;
import by.epam.kisel.utility.BasketSmallerThanBallException;
import by.epam.kisel.utility.ExcessWeightException;
import by.epam.kisel.utility.NegativeValueException;
import by.epam.kisel.utility.NoSuchBallAtBasketException;
import by.epam.kisel.utility.NotEnoughFreeSpaceException;

public class Basket {

	private double volume;
	private double height;
	private double weightCapacity;
	private double freeSpace;
	private double weightOfBalls;
	private ArrayList<Ball> balls = new ArrayList<>();

	public Basket() {
		volume = 125;
		weightCapacity = 50;
	}

	public Basket(double volume, double weightCapacity) {
		this.volume = volume;
		this.weightCapacity = weightCapacity;

		freeSpace = volume;
	}

	public void add(Ball ball) throws BasketSmallerThanBallException, NotEnoughFreeSpaceException,
			ExcessWeightException, NegativeValueException {

		double ballVolume = ball.countVolume();
		double ballWeight = ball.getWeight();
		double ballDiameter = ball.getDiameter();

		if (ballWeight <= 0 || ballDiameter <= 0) {
			throw new NegativeValueException("Ball's weight or diameter is below zero. \nWeight = " + ballWeight
					+ " diameter = " + ballDiameter);
		}

		if (weightOfBalls + ballWeight <= weightCapacity) {
			weightOfBalls += ballWeight;
		} else {
			throw new ExcessWeightException("Ball is too heavy");
		}

		if (freeSpace >= ballVolume) {
			freeSpace -= ballVolume;
		} else {
			throw new NotEnoughFreeSpaceException("Too little space for the ball");
		}

		balls.add(ball);
	}

	public void remove(Ball ball) throws NoSuchBallAtBasketException {
		if (balls.contains(ball)) {
			weightOfBalls -= ball.getWeight();
			freeSpace += ball.countVolume();
			balls.remove(ball);
		} else {
			throw new NoSuchBallAtBasketException("There is no such ball in the basket");
		}
	}

	public long countBallPaintedIn(BallColours colour) throws NoSuchBallAtBasketException {
		long numberOfPaintedBalls = 0;

		Stream<Ball> ballStream = balls.stream();
		numberOfPaintedBalls = ballStream.filter(ball -> ball.getColour().equals(colour)).count();

		if (numberOfPaintedBalls == 0) {
			throw new NoSuchBallAtBasketException("There is no such ball in the basket");
		}
		return numberOfPaintedBalls;
	}

	public void printBallPaintedIn(BallColours colour) throws NoSuchBallAtBasketException {
		System.out.println("Number of balls, painted in " + colour + ": " + countBallPaintedIn(colour));
	}

	public boolean isHeightSmallerThan(Ball ball) {
		return height < ball.getDiameter();
	}

	@Override
	public String toString() {
		return balls.toString() + ", weightOfBalls = " + weightOfBalls + ", freeSpace = " + freeSpace;
	}

	@Override
	public int hashCode() {
		int hash = (int) (weightCapacity - volume) * 31;
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

		Basket other = (Basket) obj;

		return volume == other.volume && weightCapacity == other.weightCapacity;
	}

	public double getVolume() {
		return volume;
	}

	public double getHeight() {
		return height;
	}

	public double getWeightCapacity() {
		return weightCapacity;
	}

	public double getFreeSpace() {
		return freeSpace;
	}

	public double getWeightOfBalls() {
		return weightOfBalls;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setWeightCapacity(double weightCapacity) {
		this.weightCapacity = weightCapacity;
	}

	public void setFreeSpace(double freeSpace) {
		this.freeSpace = freeSpace;
	}

}
