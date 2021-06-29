package by.epam.kisel.runner;

import by.epam.kisel.bean.ball.Ball;
import by.epam.kisel.bean.ball.Colour;
import by.epam.kisel.bean.basket.Basket;
import by.epam.kisel.utility.InputUtility;
import by.epam.kisel.view.BasketView;

public class Main {

	public static void main(String[] args) {
		Basket basket = InputUtility.inputBasket();

		Ball ball1 = InputUtility.inputBall(1);
		Ball ball2 = InputUtility.inputBall(2);
		Ball ball3 = InputUtility.inputBall(3);

		basket.add(ball1);
		basket.add(ball2);
		basket.add(ball3);

		System.out.println(basket.toString());

		BasketView.printBallPaintedIn(Colour.BLUE, basket);
		basket.remove(ball3);
		System.out.println("\n" + basket.toString());
		BasketView.printBallPaintedIn(Colour.BLUE, basket);
	}

}
