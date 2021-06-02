package by.epam.kisel.runner;

import by.epam.kisel.bean.Ball;
import by.epam.kisel.bean.BallColours;
import by.epam.kisel.bean.Basket;
import by.epam.kisel.utility.BasketSmallerThanBallException;
import by.epam.kisel.utility.ExcessWeightException;
import by.epam.kisel.utility.InputUtility;
import by.epam.kisel.utility.NegativeValueException;
import by.epam.kisel.utility.NoSuchBallAtBasketException;
import by.epam.kisel.utility.NotEnoughFreeSpaceException;

public class Main {

	public static void main(String[] args) {
		Basket basket = InputUtility.inputBasket();

		Ball ball1 = InputUtility.inputBall(1);
		Ball ball2 = InputUtility.inputBall(2);
		Ball ball3 = InputUtility.inputBall(3);

		try {
			basket.add(ball1);
			basket.add(ball2);
			basket.add(ball3);
		} catch (BasketSmallerThanBallException e) {
			e.printStackTrace();
		} catch (NegativeValueException e) {
			e.printStackTrace();
		} catch (ExcessWeightException e) {
			e.printStackTrace();
		} catch (NotEnoughFreeSpaceException e) {
			e.printStackTrace();
		}

		System.out.println(basket.toString());

		try {
			basket.printBallPaintedIn(BallColours.BLUE);
			basket.remove(ball3);
			System.out.println("\n" + basket.toString() + "\n");
			basket.printBallPaintedIn(BallColours.BLUE);
		} catch (NoSuchBallAtBasketException e) {
			e.printStackTrace();
		}

	}

}
