package by.epam.kisel.bean.basket;

import java.util.ArrayList;

import by.epam.kisel.bean.ball.Ball;
import by.epam.kisel.service.BallService;

public class Basket {

	private double volume;
	private double height;
	private double weightCapacity;
	private ArrayList<Ball> balls = new ArrayList<>();
	
	private static final double MIN_VOLUME = 125;
	private static final double MIN_WEIGHTCAPACITY = 50;

	public Basket() {
		volume = MIN_VOLUME;
		weightCapacity = MIN_WEIGHTCAPACITY;
	}

	public Basket(double volume, double weightCapacity) {
		this.volume = volume;
		this.weightCapacity = weightCapacity;
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
	
	protected void setVolume(double volume) {
		this.volume = volume;
	}
	
	protected void setHeight(double height) {
		this.height = height;
	}

	protected void setWeightCapacity(double weightCapacity) {
		this.weightCapacity = weightCapacity;
	}
	
	public boolean add(Ball ball) {
		if(BallService.isNull(ball)) return false;
		
		double ballWeight = ball.getWeight();
		double ballDiameter = ball.getDiameter();
		double ballVolume = BallService.countVolume(ballDiameter);
		
		boolean add = !isNegativeWeightDiameter(ballWeight, ballDiameter) && !hasBallExcessWeight(ballWeight) 
				&& hasFreeSpace(ballVolume);

		return add && balls.add(ball);
	}
	
	private boolean isNegativeWeightDiameter (double ballWeight, double ballDiameter) {
		return BallService.isNegative(ballWeight) || BallService.isNegative(ballDiameter);
	}
	
	private boolean hasBallExcessWeight(double ballWeight) {
		return countWeightOfBalls() + ballWeight > weightCapacity;
	}
	
	public double countWeightOfBalls() {
		double weight = 0;
		for(Ball ball : balls) {
			weight = weight + ball.getWeight();
		}
		return weight;
	}
	
	private boolean hasFreeSpace(double ballVolume) {
		return countFreeSpace() >= ballVolume;
	}
	
	public double countFreeSpace() {
		double ballsVolume = 0;
		double freeSpace;
		for(Ball ball : balls) {
			ballsVolume = ballsVolume + BallService.countVolume(ball.getDiameter());
		}
		freeSpace = volume - ballsVolume;
		return freeSpace;
	}
	
	public int size() {
		return balls.size();
	}
	
	public Ball get(int index) {
		Ball ball;
		if (checkIndex(index)) {
			ball = new Ball(0, 0, null);
		} else {
			ball = balls.get(index);
		}
		return ball;
	}
	
	private boolean checkIndex(int index) {
		return index < 0 || index >= balls.size();
	}

	public boolean remove(Ball ball) {
		if (BallService.isNull(ball)) return false;
		return balls.remove(ball);
	}

	protected boolean isHeightSmallerThan(Ball ball) {
		return height < ball.getDiameter();
	}
	
	public boolean set(int index, Ball ball) {
		if (checkIndex(index) || BallService.isNull(ball)) return false;
		balls.set(index, ball);
		return true;
	}

	@Override
	public String toString() {
		return balls.toString() + ", weightOfBalls = " + countWeightOfBalls() + ", freeSpace = " + countFreeSpace();
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
}
