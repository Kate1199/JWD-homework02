package by.epam.kisel.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import by.epam.kisel.bean.ball.Ball;
import by.epam.kisel.bean.ball.Colour;
import by.epam.kisel.bean.basket.Basket;

public class TestBasketService {
	
	private Basket testBasket;
	private Ball testBall = new Ball();
	
	@Before
	public void setUp() {
		testBasket = new Basket(100, 50);
		testBasket.add(testBall);
	}
	
	@Test
	public void testCountBallsPaintedIn() {
		int expected = 1;
		int actual = BasketService.countBallsPaintedIn(Colour.BLUE, testBasket);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCountBallsPaintedIn_NULL_COLOUR() {
		int expected = 0;
		int actual = BasketService.countBallsPaintedIn(null, testBasket);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCountBallsPaintedIn_NULL_BASKET() {
		int expected = 0;
		int actual = BasketService.countBallsPaintedIn(Colour.BLUE, null);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCountBallsPaintedIn_NO_SUCH_COLOUR() {
		int expected = 0;
		int actual = BasketService.countBallsPaintedIn(Colour.BLACK, testBasket);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCountBalls() {
		int expected = 1;
		int actual = BasketService.countBalls(testBasket);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCountBalls_NULL() {
		int expected = 0;
		int actual = BasketService.countBalls(null);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCountBalls_EMPTY() {
		testBasket.remove(testBall);
		int expected = 0;
		int actual = BasketService.countBalls(null);
		assertEquals(expected, actual);
	}
	
	
}
