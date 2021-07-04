package by.epam.kisel.service;

import static org.junit.Assert.*;

import org.junit.Test;

import by.epam.kisel.bean.ball.Ball;
import by.epam.kisel.bean.ball.Colour;

public class TestBallService {
	
	private Ball testBall = new Ball();
	private Ball negativeDiameterBall = new Ball(1, -1, Colour.BLACK);
	
	@Test
	public void testCountVolume() {
		double expected = 0.5;
		double actual = BallService.countVolume(testBall.getDiameter());
		assertEquals(expected, actual, 0.1);
	}
	
	@Test
	public void testCountVolume_NEGATIVE_DIAMETER() {
		double expected = 0.5;
		double actual = BallService.countVolume(negativeDiameterBall.getDiameter());
		assertEquals(expected, actual, 0.1);
	}
}
