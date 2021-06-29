package by.epam.kisel.view;

import by.epam.kisel.bean.ball.Colour;
import by.epam.kisel.bean.basket.Basket;
import by.epam.kisel.service.BasketLogic;

public class BasketView {
	
	public static void printBallPaintedIn(Colour colour, Basket basket) {
		System.out.println("Number of balls, painted in " + colour + ": " + BasketLogic.countBallPaintedIn(colour, basket));
	}
}
