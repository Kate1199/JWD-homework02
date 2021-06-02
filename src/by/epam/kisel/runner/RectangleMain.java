package by.epam.kisel.runner;

import by.epam.kisel.bean.*;
import by.epam.kisel.bean.ball.Ball;
import by.epam.kisel.bean.ball.BallColours;
import by.epam.kisel.bean.basket.Basket;
import by.epam.kisel.utility.BasketSmallerThanBallException;
import by.epam.kisel.utility.ExcessWeightException;
import by.epam.kisel.utility.InputUtility;
import by.epam.kisel.utility.NegativeValueException;
import by.epam.kisel.utility.NoSuchBallAtBasketException;
import by.epam.kisel.utility.NotEnoughFreeSpaceException;

public class RectangleMain {

	public static void main(String[] args) {

		Basket rectangleBasket = InputUtility.inputRectangleBasket();

		Ball ball1 = InputUtility.inputBall(1);
		Ball ball2 = InputUtility.inputBall(2);
		Ball ball3 = InputUtility.inputBall(3);

		try {
			rectangleBasket.add(ball1);
			rectangleBasket.add(ball2);
			rectangleBasket.add(ball3);
		} catch (NegativeValueException e) {
			e.printStackTrace();
		} catch (BasketSmallerThanBallException e) {
			e.printStackTrace();
		} catch (ExcessWeightException e) {
			e.printStackTrace();
		} catch (NotEnoughFreeSpaceException e) {
			e.printStackTrace();
		}

		System.out.println(rectangleBasket.toString());

		try {
			rectangleBasket.printBallPaintedIn(BallColours.BLUE);
			rectangleBasket.remove(ball2);
			System.out.println("\n" + rectangleBasket.toString() + "\n");
			rectangleBasket.printBallPaintedIn(BallColours.BLUE);
		} catch (NoSuchBallAtBasketException e) {
			e.printStackTrace();
		}

	}

}
