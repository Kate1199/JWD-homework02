package by.epam.kisel.bean.ball;

public class Ball {
	private double weight;
	private double diameter;
	private Colour colour;
	
	private static final double MIN_WEIGHT = 1;
	private static final double MIN_DIAMETER = 1;

	public Ball() {
		weight = MIN_WEIGHT;
		diameter = MIN_DIAMETER;
		colour = Colour.BLUE;
	}

	public Ball(double weight, double diameter, Colour colour) {
		this.weight = weight;
		this.diameter = diameter;
		this.colour = colour;
	}
	
	public double getWeight() {
		return weight;
	}

	public double getDiameter() {
		return diameter;
	}

	public Colour getColour() {
		return colour;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
	
	public void setColour(Colour colour) {
		this.colour = colour;
	}

	public double countVolume() {
		double volume = Math.PI * Math.pow(diameter, 3) / 6;
		return volume;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " {weight = " + weight + 
				", diameter = " + diameter + ", colour = " + colour + "}";
	}

	@Override
	public int hashCode() {
		return (int) (weight * 31 - diameter * 31 + colour.hashCode());
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

		return weight == other.weight && diameter == other.diameter
				&& (colour == other.colour || colour != null && colour.equals(other.colour));
	}
}
