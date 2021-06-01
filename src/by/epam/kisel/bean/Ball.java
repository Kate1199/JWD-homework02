package by.epam.kisel.bean;

public class Ball {
	private double weight;
	private double diameter;
	private BallColours colour;
	
	public Ball() {
		weight = 1;
		diameter = 1;
		colour = BallColours.BLUE;
	}

	public Ball(double weight, double diameter, BallColours colour) {
		this.weight = weight;
		this.diameter = diameter;
		this.colour = colour;
	}

	public double countVolume() {
		double volume = Math.PI * Math.pow(diameter, 3) / 6;
		return volume;
	}
	
	@Override
	public String toString() {
		return "Ball {weight = " + weight +
				", diameter = " + diameter +
				", colour = " + colour + "}";
	}

	@Override
	public int hashCode() {
		return (int) ((weight + diameter + colour.hashCode()) * 31);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Ball other = (Ball) obj;

		return hashCode() == other.hashCode();
	}

	public double getWeight() {
		return weight;
	}

	public double getDiameter() {
		return diameter;
	}

	public BallColours getColour() {
		return colour;
	}
}
