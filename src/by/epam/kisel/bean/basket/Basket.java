package by.epam.kisel.bean.basket;

import java.util.ArrayList;

import by.epam.kisel.bean.ball.Ball;

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
	
	private boolean isNegative(double ballWeight, double ballDiameter) {
		return ballWeight <= 0 || ballDiameter <= 0;
	}
	
	private boolean hasBallExcessWeight(double ballWeight) {
		return countWeightOfBalls() + ballWeight > weightCapacity;
	}
	
	private boolean hasFreeSpace(double ballVolume) {
		return countFreeSpace() >= ballVolume;
	}

	public boolean add(Ball ball) {

		double ballVolume = ball.countVolume();
		double ballWeight = ball.getWeight();
		double ballDiameter = ball.getDiameter();
		
		boolean add = !isNegative(ballWeight, ballDiameter) && !hasBallExcessWeight(ballWeight) 
				&& hasFreeSpace(ballVolume);

		return add && balls.add(ball);
	}

	public boolean remove(Ball ball) {
		boolean remove = false;
		if (balls.contains(ball)) {
			remove = balls.remove(ball);
		} 
		return remove;
	}

	protected boolean isHeightSmallerThan(Ball ball) {
		return height < ball.getDiameter();
	}
	
	public int size() {
		return balls.size();
	}
	
	public Ball get(int index) {
		return balls.get(index);
	}

	public double countFreeSpace() {
		double ballsVolume = 0;
		double freeSpace;
		for(Ball ball : balls) {
			ballsVolume = ballsVolume + ball.countVolume();
		}
		freeSpace = volume - ballsVolume;
		return freeSpace;
	}

	public double countWeightOfBalls() {
		double weight = 0;
		for(Ball ball : balls) {
			weight = weight + ball.getWeight();
		}
		return weight;
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
