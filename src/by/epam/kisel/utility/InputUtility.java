package by.epam.kisel.utility;

import java.util.Scanner;

import by.epam.kisel.bean.*;
import by.epam.kisel.bean.ball.Ball;
import by.epam.kisel.bean.ball.BallColours;
import by.epam.kisel.bean.basket.Basket;
import by.epam.kisel.bean.basket.RectangleBasket;
import by.epam.kisel.bean.basket.RoundBasket;

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

	private static double inputHeight() {
		return inputDouble("height: ");
	}

	private static double inputWeightCapacity() {
		return inputDouble("weightCapacity: ");
	}

	public static Basket inputBasket() {
		double volume;
		double weightCapacity;

		System.out.println("Basket");

		volume = inputDouble("volume: ");
		weightCapacity = inputWeightCapacity();

		Basket basket = new Basket(volume, weightCapacity);
		return basket;
	}

	public static Basket inputRectangleBasket() {
		double length;
		double width;
		double height;
		double weightCapacity;

		System.out.println("RectangleBasket: ");

		length = inputDouble("length: ");
		width = inputDouble("width: ");
		height = inputHeight();
		weightCapacity = inputWeightCapacity();

		Basket rectangleBasket = new RectangleBasket(length, width, height, weightCapacity);
		return rectangleBasket;

	}

	public static Basket inputRoundBasket() {
		double diameter;
		double height;
		double weightCapacity;

		System.out.println("RoundBasket: ");

		diameter = inputDouble("diameter: ");
		height = inputHeight();
		weightCapacity = inputWeightCapacity();

		Basket roundBasket = new RoundBasket(diameter, height, weightCapacity);
		return roundBasket;
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
