package by.epam.kisel.utility;

import java.util.Scanner;

import by.epam.kisel.bean.*;

public class InputUtility {

	private static Scanner sc = new Scanner(System.in);

	public static double inputDouble(String message) {
		double value;
		System.out.println(message);

		while (!sc.hasNextDouble()) {
			sc.next();
		}
		value = sc.nextDouble();
		return value;
	}

	public static String inputString(String message) {
		String text;
		System.out.println(message);
		text = sc.next();

		return text;
	}

	public static boolean inputBoolean(String message) {
		boolean state;
		System.out.println(message);

		while (!sc.hasNextBoolean()) {
			sc.next();
		}
		state = sc.nextBoolean();
		return state;
	}

	public static Basket inputBasket() {
		double length = 0;
		double width = 0;
		double height = 0;
		double diameter = 0;
		double weightCapacity = 0;

		boolean round = inputBoolean("basket is round: ");

		System.out.println("Basket: ");

		if (round) {
			diameter = inputDouble("diameter: ");
		} else {
			length = inputDouble("length: ");
			width = inputDouble("width: ");
		}
		height = inputDouble("height: ");
		weightCapacity = inputDouble("weightCapacity: ");

		Basket rectangleBasket = new Basket(length, width, height, weightCapacity);
		Basket roundBasket = new Basket(diameter, height, weightCapacity);
		return round ? roundBasket : rectangleBasket;
	}

	public static Ball inputBall(int number) {
		double weight;
		double diameter;
		String colourStr;

		System.out.println("Ball №" + number);

		weight = inputDouble("weight: ");
		diameter = inputDouble("diameter: ");
		colourStr = inputString("colour: ");

		BallColours colour = BallColours.valueOf(colourStr);
		Ball ball = new Ball(weight, diameter, colour);
		return ball;
	}
}
