package by.epam.kisel.bean;

import java.util.ArrayList;
import java.util.stream.Stream;

import by.epam.kisel.utility.BasketSmallerThanBallException;
import by.epam.kisel.utility.ExcessWeightException;
import by.epam.kisel.utility.NegativeValueException;
import by.epam.kisel.utility.NoSuchBallAtBasketException;
import by.epam.kisel.utility.NotEnoughFreeSpaceException;

public class Basket {
	private double length;
	private double width;
	private double height;
	private double diameter;
	private double weightCapacity;

	private double freeSpace;
	private double weightOfBalls;

	private boolean round;
	private ArrayList<Ball> balls = new ArrayList<>();

	public Basket() {
		length = 20;
		width = 20;
		height = 20;
		weightCapacity = 50;

		freeSpace = countVolume();
	}

	public Basket(double length, double width, double height, double weightCapacity) {
		this.length = length;
		this.width = width;
		this.height = height;
		this.weightCapacity = weightCapacity;

		freeSpace = countVolume();
	}

	public Basket(double diameter, double height, double weightCapacity) {
		this.diameter = diameter;
		this.height = height;
		this.weightCapacity = weightCapacity;

		round = true;
		freeSpace = countVolume();
	}
	
	public Ball findBy(BallColours colour) throws NoSuchBallAtBasketException {
		
		for(Ball ball : balls) {
			if(ball.getColour().equals(colour)) {
				return ball;
			} else {
				break;
			}
		}
		throw new NoSuchBallAtBasketException("There is no such ball in the basket");
	}

	public boolean isSmallerThan(Ball ball) {
		boolean smallerThanBall;
		boolean moreThanBasketHeight = ball.getDiameter() > height;

		if (round) {
			boolean moreThanBasketDiameter = ball.getDiameter() > diameter;
			smallerThanBall = moreThanBasketDiameter || moreThanBasketHeight;
		} else {
			boolean moreThanBasketLength = ball.getDiameter() > length;
			boolean moreThanBasketWidth = ball.getDiameter() > width;
			smallerThanBall = moreThanBasketLength || moreThanBasketWidth || moreThanBasketHeight;
		}
		return smallerThanBall;
	}

	public void add(Ball ball) throws BasketSmallerThanBallException, NotEnoughFreeSpaceException,
			ExcessWeightException, NegativeValueException {

		double ballVolume = ball.countVolume();
		double ballWeight = ball.getWeight();
		double ballDiameter = ball.getDiameter();
		
		if (ballWeight <= 0 || ballDiameter <= 0) {
			throw new NegativeValueException("Ball's weight or diameter is below zero. \nWeight = "
		+ ballWeight + " diameter = " + ballDiameter);
		}

		if (isSmallerThan(ball)) {
			throw new BasketSmallerThanBallException("Basket is smaller than ball");
		}

		if (weightOfBalls + ballWeight < weightCapacity) {
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
	
	public void remove(Ball ball) {
		weightOfBalls -= ball.getWeight();
		freeSpace += ball.countVolume();
		balls.remove(ball);
	}
	
	public long countBallPaintedIn(BallColours colour) throws NoSuchBallAtBasketException {
		long numberOfPaintedBalls = 0;
		
		Stream<Ball> ballStream = balls.stream();
		numberOfPaintedBalls = ballStream.filter(ball -> ball.getColour().equals(colour))
		.count();	
		
		if(numberOfPaintedBalls == 0) {
			throw new NoSuchBallAtBasketException("There is no such ball in the basket");			
		}
		return numberOfPaintedBalls;
	}

	public double countVolume() {
		double volume;
		if (round) {
			volume = Math.PI * height * Math.pow(diameter, 2) / 4;
		} else {
			volume = length * width * height;
		}
		return volume;
	}

	@Override
	public String toString() {
		return balls.toString() + ", weightOfBalls = " + weightOfBalls
				+ ", freeSpace = " + freeSpace;
	}

	@Override
	public int hashCode() {
		int hash;
		if (round) {
			hash = (int) (diameter + height) * 31;
		} else {
			hash = (int) (length - width + height) * 31;
		}
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
		return hashCode() == other.hashCode();
	}
	
	public boolean isRound() {
		return round;
	}

	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public double getDiameter() {
		return diameter;
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

}
