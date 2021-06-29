package by.epam.kisel.runner;

import by.epam.kisel.bean.ball.Ball;
import by.epam.kisel.bean.ball.Colour;
import by.epam.kisel.bean.basket.Basket;
import by.epam.kisel.utility.InputUtility;

import by.epam.kisel.view.BasketView;

public class RoundMain {

	public static void main(String[] args) {

		Basket roundBasket = InputUtility.inputRoundBasket();

		Ball ball1 = InputUtility.inputBall(1);
		Ball ball2 = InputUtility.inputBall(2);
		Ball ball3 = InputUtility.inputBall(3);

		roundBasket.add(ball1);
		roundBasket.add(ball2);
		roundBasket.add(ball3);

		System.out.println(roundBasket.toString());

		BasketView.printBallPaintedIn(Colour.BLUE, roundBasket);
		roundBasket.remove(ball1);
		System.out.println("\n" + roundBasket.toString());
		BasketView.printBallPaintedIn(Colour.BLUE, roundBasket);

	}
}
