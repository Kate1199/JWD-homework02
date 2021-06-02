package by.epam.kisel.runner;

import by.epam.kisel.bean.ball.Ball;
import by.epam.kisel.bean.ball.BallColours;
import by.epam.kisel.bean.basket.Basket;
import by.epam.kisel.utility.BasketSmallerThanBallException;
import by.epam.kisel.utility.ExcessWeightException;
import by.epam.kisel.utility.InputUtility;
import by.epam.kisel.utility.NegativeValueException;
import by.epam.kisel.utility.NoSuchBallAtBasketException;
import by.epam.kisel.utility.NotEnoughFreeSpaceException;

public class RoundMain {
	
	public static void main(String[] args) {

		Basket roundBasket = InputUtility.inputRoundBasket();

		Ball ball1 = InputUtility.inputBall(1);
		Ball ball2 = InputUtility.inputBall(2);
		Ball ball3 = InputUtility.inputBall(3);

		try {
			roundBasket.add(ball1);
			roundBasket.add(ball2);
			roundBasket.add(ball3);
		} catch (NegativeValueException e) {
			e.printStackTrace();
		} catch (BasketSmallerThanBallException e) {
			e.printStackTrace();
		} catch (ExcessWeightException e) {
			e.printStackTrace();
		} catch (NotEnoughFreeSpaceException e) {
			e.printStackTrace();
		}
		
		System.out.println(roundBasket.toString());
		
		try {
			roundBasket.printBallPaintedIn(BallColours.BLUE);
			roundBasket.remove(ball1);
			System.out.println("\n" + roundBasket.toString() + "\n");
			roundBasket.printBallPaintedIn(BallColours.BLUE);
		} catch (NoSuchBallAtBasketException e) {
			e.printStackTrace();
		}
	}
}
