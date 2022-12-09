package advent.day09;

import static advent.utils.Utils.bufReader;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class Day09Test {

	@Test
	public void moveFromOverlapping() {
		Point head = new Point(0, 0);
		Point tail = new Point(0, 0);
		Set<Point> visited = new HashSet<Point>();
		Status status;

		status = new Day09().move("R 1", new Status(List.of(head, tail), visited));
		assertEquals(0, status.visited().size());

		status = new Day09().move("L 1", new Status(List.of(head, tail), visited));
		assertEquals(0, status.visited().size());

		status = new Day09().move("U 1", new Status(List.of(head, tail), visited));
		assertEquals(0, status.visited().size());

		status = new Day09().move("D 1", new Status(List.of(head, tail), visited));
		assertEquals(0, status.visited().size());
	}

	@Test
	public void moveInLineR() {
		Point head = new Point(1, 0);
		Point tail = new Point(0, 0);
		Set<Point> visited = new HashSet<Point>();
		Status status = new Day09().move("R 1", new Status(List.of(head, tail), visited));

		assertEquals(1, status.visited().size());
		assertTrue(status.visited().contains(new Point(1, 0)));
		assertEquals(new Point(2, 0), status.head());
		assertEquals(new Point(1, 0), status.tail());
	}

	@Test
	public void moveInLineL() {
		Point head = new Point(-1, 0);
		Point tail = new Point(0, 0);
		Set<Point> visited = new HashSet<Point>();
		Status status = new Day09().move("L 1", new Status(List.of(head, tail), visited));

		assertEquals(1, status.visited().size());
		assertTrue(status.visited().contains(new Point(-1, 0)));
		assertEquals(new Point(-2, 0), status.head());
		assertEquals(new Point(-1, 0), status.tail());
	}

	@Test
	public void moveInLineU() {
		Point head = new Point(0, 1);
		Point tail = new Point(0, 0);
		Set<Point> visited = new HashSet<Point>();
		Status status = new Day09().move("U 1", new Status(List.of(head, tail), visited));

		assertEquals(1, status.visited().size());
		assertTrue(status.visited().contains(new Point(0, 1)));
		assertEquals(new Point(0, 2), status.head());
		assertEquals(new Point(0, 1), status.tail());
	}

	@Test
	public void moveInLineD() {
		Point head = new Point(0, -1);
		Point tail = new Point(0, 0);
		Set<Point> visited = new HashSet<Point>();
		Status status = new Day09().move("D 1", new Status(List.of(head, tail), visited));

		assertEquals(1, status.visited().size());
		assertTrue(status.visited().contains(new Point(0, -1)));
		assertEquals(new Point(0, -2), status.head());
		assertEquals(new Point(0, -1), status.tail());
	}

	@Test
	public void moveDiag1U() {
		Point head = new Point(1, 1);
		Point tail = new Point(0, 0);
		Set<Point> visited = new HashSet<Point>();
		Status status = new Day09().move("U 1", new Status(List.of(head, tail), visited));
		assertEquals(1, status.visited().size());
		assertTrue(status.visited().contains(new Point(1, 1)));
		assertEquals(new Point(1, 2), status.head());
		assertEquals(new Point(1, 1), status.tail());
	}

	@Test
	public void moveDiag1R() {
		Point head = new Point(1, 1);
		Point tail = new Point(0, 0);
		Set<Point> visited = new HashSet<Point>();
		Status status = new Day09().move("R 1", new Status(List.of(head, tail), visited));
		assertEquals(1, status.visited().size());
		assertTrue(status.visited().contains(new Point(1, 1)));
		assertEquals(new Point(2, 1), status.head());
		assertEquals(new Point(1, 1), status.tail());
	}

	@Test
	public void moveDiag1D() {
		Point head = new Point(-1, -1);
		Point tail = new Point(0, 0);
		Set<Point> visited = new HashSet<Point>();
		Status status = new Day09().move("D 1", new Status(List.of(head, tail), visited));
		assertEquals(1, status.visited().size());
		assertTrue(status.visited().contains(new Point(-1, -1)));
		assertEquals(new Point(-1, -2), status.head());
		assertEquals(new Point(-1, -1), status.tail());
	}

	@Test
	public void moveDiag1L() {
		Point head = new Point(-1, -1);
		Point tail = new Point(0, 0);
		Set<Point> visited = new HashSet<Point>();
		Status status = new Day09().move("L 1", new Status(List.of(head, tail), visited));
		assertEquals(1, status.visited().size());
		assertTrue(status.visited().contains(new Point(-1, -1)));
		assertEquals(new Point(-2, -1), status.head());
		assertEquals(new Point(-1, -1), status.tail());
	}

	@Test
	public void moveDiag1DBack() {
		Point head = new Point(1, 1);
		Point tail = new Point(0, 0);
		Set<Point> visited = new HashSet<Point>();
		Status status = new Day09().move("D 1", new Status(List.of(head, tail), visited));
		assertEquals(0, status.visited().size());
		assertEquals(new Point(1, 0), status.head());
		assertEquals(new Point(0, 0), status.tail());
	}

	@Test
	public void moveDiag1UBack() {
		Point tail = new Point(0, 0);
		Point head = new Point(-1, -1);
		Set<Point> visited = new HashSet<Point>();
		Status status = new Day09().move("U 1", new Status(List.of(head, tail), visited));
		assertEquals(0, status.visited().size());
		assertEquals(new Point(-1, 0), status.head());
		assertEquals(new Point(0, 0), status.tail());
	}

	@Test
	public void moveDiag1RBack() {
		Point tail = new Point(0, 0);
		Point head = new Point(-1, -1);
		Set<Point> visited = new HashSet<Point>();
		Status status = new Day09().move("R 1", new Status(List.of(head, tail), visited));
		assertEquals(0, status.visited().size());
		assertEquals(new Point(0, -1), status.head());
		assertEquals(new Point(0, 0), status.tail());
	}

	@Test
	public void moveDiag1LBack() {
		Point tail = new Point(0, 0);
		Point head = new Point(1, 1);
		Set<Point> visited = new HashSet<Point>();
		Status status = new Day09().move("L 1", new Status(List.of(head, tail), visited));
		assertEquals(0, status.visited().size());
		assertEquals(new Point(0, 1), status.head());
		assertEquals(new Point(0, 0), status.tail());
	}

	@Test
	public void moveDiagLBackMultiple() {
		Point tail = new Point(0, 0);
		Point head = new Point(1, 1);
		Set<Point> visited = new HashSet<Point>();
		Status status = new Day09().move("L 4", new Status(List.of(head, tail), visited));
		assertEquals(2, status.visited().size());
		assertEquals(new Point(-3, 1), status.head());
		assertEquals(new Point(-2, 1), status.tail());
	}

	@Test
	public void moveLineLBackMultiple() {
		Point tail = new Point(0, 0);
		Point head = new Point(1, 0);
		Set<Point> visited = new HashSet<Point>();
		Status status = new Day09().move("L 4", new Status(List.of(head, tail), visited));
		assertEquals(2, status.visited().size());
		assertEquals(new Point(-3, 0), status.head());
		assertEquals(new Point(-2, 0), status.tail());
	}

	@Test
	public void moveLineUBackMultiple() {
		Point tail = new Point(0, 0);
		Point head = new Point(0, -1);
		Set<Point> visited = new HashSet<Point>(List.of(new Point(0, 0), new Point(0, 1), new Point(0, 2)));
		Status status = new Day09().move("U 4", new Status(List.of(head, tail), visited));
		assertEquals(3, status.visited().size());
		assertEquals(new Point(0, 3), status.head());
		assertEquals(new Point(0, 2), status.tail());
	}

	@Test
	public void moveLineRDoubleDigits() {
		Point tail = new Point(0, 0);
		Point head = new Point(0, 0);
		Set<Point> visited = new HashSet<Point>();
		Status status = new Day09().move("R 40", new Status(List.of(head, tail), visited));
		assertEquals(39, status.visited().size());
		assertEquals(new Point(40, 0), status.head());
		assertEquals(new Point(39, 0), status.tail());
	}

	@Test
	public void moveLineLoop() {
		Point tail = new Point(0, 0);
		Point head = new Point(0, 0);
		Set<Point> visited = new HashSet<Point>();
		Status status = new Day09().move("R 2", new Status(List.of(head, tail), visited));
		status = new Day09().move("U 2", status);
		assertEquals(2, status.visited().size());
		assertEquals(new Point(2, 2), status.head());
		assertEquals(new Point(2, 1), status.tail());
	}

	@Test
	public void test() throws IOException {
		String prefix = "day09";
		assertEquals(13, new Day09().solveStep1(bufReader(prefix, "-test")));
		assertEquals(6339, new Day09().solveStep1(bufReader(prefix, "")));
//		assertEquals(1, new Day09().solveStep2(bufReader(prefix,"-test")));
//		assertEquals(36, new Day09().solveStep2(bufReader(prefix,"-test2")));
//   	assertEquals(?, new Day09().solveStep2(bufReader(prefix)));
	}
}
