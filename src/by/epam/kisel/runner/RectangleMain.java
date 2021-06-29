package by.epam.kisel.runner;

import by.epam.kisel.bean.ball.Ball;
import by.epam.kisel.bean.ball.Colour;
import by.epam.kisel.bean.basket.Basket;
import by.epam.kisel.utility.InputUtility;
import by.epam.kisel.view.BasketView;

public class RectangleMain {

	public static void main(String[] args) {

		Basket rectangleBasket = InputUtility.inputRectangleBasket();

		Ball ball1 = InputUtility.inputBall(1);
		Ball ball2 = InputUtility.inputBall(2);
		Ball ball3 = InputUtility.inputBall(3);

		rectangleBasket.add(ball1);
		rectangleBasket.add(ball2);
		rectangleBasket.add(ball3);

		System.out.println(rectangleBasket.toString());

		BasketView.printBallPaintedIn(Colour.BLUE, rectangleBasket);
		rectangleBasket.remove(ball2);
		System.out.println("\n" + rectangleBasket.toString());
		BasketView.printBallPaintedIn(Colour.BLUE, rectangleBasket);
	}

}
