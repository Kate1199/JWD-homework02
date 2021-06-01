package by.epam.kisel.runner;

import by.epam.kisel.bean.*;
import by.epam.kisel.utility.BasketSmallerThanBallException;
import by.epam.kisel.utility.ExcessWeightException;
import by.epam.kisel.utility.InputUtility;
import by.epam.kisel.utility.NegativeValueException;
import by.epam.kisel.utility.NotEnoughFreeSpaceException;

public class RectangleMain {

	public static void main(String[] args) {

		Basket rectangleBasket = InputUtility.inputBasket();

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
		rectangleBasket.remove(ball2);
		System.out.println("\n" + rectangleBasket.toString());
	}

}
