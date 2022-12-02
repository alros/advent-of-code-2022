package advent.day02;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class ShapeTest {

	@Test
	public void scoreAgainst() {
		assertEquals(3, Shape.Paper.scoreAgainst(Shape.Paper));
		assertEquals(3, Shape.Scissors.scoreAgainst(Shape.Scissors));
		assertEquals(3, Shape.Rock.scoreAgainst(Shape.Rock));

		assertEquals(6, Shape.Paper.scoreAgainst(Shape.Rock));
		assertEquals(6, Shape.Scissors.scoreAgainst(Shape.Paper));
		assertEquals(6, Shape.Rock.scoreAgainst(Shape.Scissors));

		assertEquals(0, Shape.Paper.scoreAgainst(Shape.Scissors));
		assertEquals(0, Shape.Scissors.scoreAgainst(Shape.Rock));
		assertEquals(0, Shape.Rock.scoreAgainst(Shape.Paper));
	}
	
	@Test
	public void parse() {
		assertEquals(Shape.Rock, Shape.fromValue("X"));
		assertEquals(Shape.Rock, Shape.fromValue("A"));
		assertEquals(Shape.Paper, Shape.fromValue("Y"));
		assertEquals(Shape.Paper, Shape.fromValue("B"));
		assertEquals(Shape.Scissors, Shape.fromValue("Z"));
		assertEquals(Shape.Scissors, Shape.fromValue("C"));
	}
	
	@Test
	public void get() {
		assertEquals(Shape.Scissors, Shape.Rock.getByOutcome("X"));
		assertEquals(Shape.Paper, Shape.Scissors.getByOutcome("X"));
		assertEquals(Shape.Rock, Shape.Paper.getByOutcome("X"));
		assertEquals(Shape.Rock, Shape.Rock.getByOutcome("Y"));
		assertEquals(Shape.Scissors, Shape.Scissors.getByOutcome("Y"));
		assertEquals(Shape.Paper, Shape.Paper.getByOutcome("Y"));
		assertEquals(Shape.Paper, Shape.Rock.getByOutcome("Z"));
		assertEquals(Shape.Rock, Shape.Scissors.getByOutcome("Z"));
		assertEquals(Shape.Scissors, Shape.Paper.getByOutcome("Z"));
	}
}
