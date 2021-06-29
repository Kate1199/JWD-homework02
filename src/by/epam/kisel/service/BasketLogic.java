package by.epam.kisel.service;

import by.epam.kisel.bean.ball.Colour;
import by.epam.kisel.bean.basket.Basket;

public class BasketLogic {

	public static int countBallPaintedIn(Colour colour, Basket basket) {
		int numberOfPaintedBalls = 0;

		if (!isNull(basket) && !isNull(colour)) {
			for (int i = 0; i < basket.size(); i++) {
				Colour ballColour = basket.get(i).getColour();

				if (ballColour.equals(colour)) {
					numberOfPaintedBalls++;
				}
			}
		}
		return numberOfPaintedBalls;
	}

	public static int countBalls(Basket basket) {
		int numberOfBalls = 0;
		if (!isNull(basket)) {
			numberOfBalls = basket.size();
		}
		return numberOfBalls;
	}

	private static boolean isNull(Object o) {
		return o == null;
	}

}
