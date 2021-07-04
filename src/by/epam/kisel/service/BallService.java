package by.epam.kisel.service;

import by.epam.kisel.bean.ball.Ball;

public class BallService {
	
	public static double countVolume(double diameter) {
		diameter = makePositiveValue(diameter);
		double volume = Math.PI * Math.pow(diameter, 3) / 6;
		return volume;
	}
	
	private static double makePositiveValue(double value) {
		if(isNegative(value)) {
			value = Math.abs(value);
		}
		return value;
	}
	
	public static boolean isNull(Ball ball) {
		return ball == null;
	}
	
	public static boolean isNegative(double ballWeight) {
		return ballWeight < 0;
	}
}
