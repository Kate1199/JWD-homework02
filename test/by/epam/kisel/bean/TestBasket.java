package by.epam.kisel.bean;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import by.epam.kisel.bean.ball.Ball;
import by.epam.kisel.bean.ball.Colour;
import by.epam.kisel.bean.basket.Basket;

public class TestBasket {

	private Ball testBall1 = new Ball(5, 2, Colour.BLUE);
	private Ball testBall2 = new Ball(6, 3, Colour.BLUE);
	private Ball negativeWeightBall = new Ball(-6, 3, Colour.BLACK);
	private Ball negativeDiameterBall = new Ball(6, -3, Colour.BLACK);
	private Ball tooHeavyBall = new Ball(60, 90, Colour.BLACK);
	private Ball tooBigBall = new Ball(40, 110, Colour.BLACK);
	private Basket testBasket;
	
	@Before
	public void setUp() {
		testBasket = new Basket(100, 50);
		testBasket.add(testBall1);
	}

	@Test
	public void testAdd() {
		boolean condition = testBasket.add(testBall1);
		assertTrue(condition);
	}
	
	@Test
	public void testAdd_NULL() {
		boolean condition  = testBasket.add(null);
		assertFalse(condition);
	}
	
	@Test
	public void testAdd_NEGATIVE_WEIGHT() {
		boolean condition  = testBasket.add(negativeWeightBall);
		assertFalse(condition);
	}
	
	@Test
	public void testAdd_NEGATIVE_DIAMETER() {
		boolean condition  = testBasket.add(negativeDiameterBall);
		assertFalse(condition);
	}
	
	@Test
	public void testAdd_TOO_HEAVY_BALL() {
		boolean condition  = testBasket.add(tooHeavyBall);
		assertFalse(condition);
	}
	
	@Test
	public void testAdd_TOO_BIG_BALL() {
		boolean condition  = testBasket.add(tooBigBall);
		assertFalse(condition);
	}
	
	@Test
	public void testRemove() {
		testBasket.add(testBall1);
		boolean condition  = testBasket.remove(testBall1);
		assertTrue(condition);
	}
	
	@Test
	public void testRemove_NO_SUCH_ELMENT() {
		testBasket.add(testBall1);
		boolean condition  = testBasket.remove(tooHeavyBall);
		assertFalse(condition);
	}
	
	@Test
	public void testRemove_NULL() {
		boolean condition  = testBasket.remove(null);
		assertFalse(condition);
	}
	
	@Test
	public void testCountWeightOfBalls() {
		testBasket.add(testBall2);
		double expected = 11;
		double actual = testBasket.countWeightOfBalls();
		assertEquals(expected, actual, 0.1);
	}
	
	@Test
	public void testCountFreeSpace() {
		testBasket.add(testBall2);
		double expected = 81.6;
		double actual = testBasket.countFreeSpace();
		assertEquals(expected, actual, 0.1);
	}
	
	@Test
	public void testSize() {
		int expected = 1;
		int actual = testBasket.size();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGet() {
		Ball expected = new Ball(5, 2, Colour.BLUE);
		Ball actual = testBasket.get(0);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGet_NO_SUCH_INDEX() {
		Ball expected = new Ball(0, 0, null);
		Ball actual = testBasket.get(-1);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSet() {
		boolean condition = testBasket.set(0, testBall2);
		assertTrue(condition);;
	}
	
	@Test
	public void testSet_NULL() {
		boolean condition = testBasket.set(0, null);
		assertFalse(condition);
	}
	
	@Test
	public void testSet_NO_SUCH_INDEX() {
		boolean condition = testBasket.set(3, testBall2);
		assertFalse(condition);
	}

}
