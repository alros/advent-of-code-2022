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

  private static final Day09 day09 = new Day09();
  private static final String prefix = "day09";

  @Test
  public void moveFromOverlapping() {
    Knot head = day09.rope(2);
    Set<Point> visited = new HashSet<Point>();
    Status status;

    status = day09.move("R 1", new Status(head, visited));
    assertEquals(0, status.visited().size());

    status = day09.move("L 1", new Status(head, visited));
    assertEquals(0, status.visited().size());

    status = day09.move("U 1", new Status(head, visited));
    assertEquals(0, status.visited().size());

    status = day09.move("D 1", new Status(head, visited));
    assertEquals(0, status.visited().size());
  }

  @Test
  public void moveInLineR() {
    Knot head = day09.rope(2);
    head.setPoint(new Point(1, 0));
    Status status = day09.move("R 1", new Status(head, new HashSet<Point>()));

    assertEquals(1, status.visited().size());
    assertTrue(status.visited().contains(new Point(1, 0)));
    assertEquals(new Point(2, 0), status.head().getPoint());
    assertEquals(new Point(1, 0), status.tail().getPoint());
  }

  @Test
  public void moveInLineRrope3() {
    Knot head = day09.rope(3);
    head.setPoint(new Point(0, 0));
    Status status = day09.move("R 3", new Status(head, new HashSet<Point>()));

    assertEquals(1, status.visited().size());
    assertTrue(status.visited().contains(new Point(1, 0)));
    assertEquals(new Point(3, 0), status.head().getPoint());
    assertEquals(new Point(1, 0), status.tail().getPoint());
  }

  @Test
  public void moveInLineL() {
    Knot head = day09.rope(2);
    head.setPoint(new Point(-1, 0));
    Status status = new Day09().move("L 1", new Status(head, new HashSet<Point>()));

    assertEquals(1, status.visited().size());
    assertTrue(status.visited().contains(new Point(-1, 0)));
    assertEquals(new Point(-2, 0), status.head().getPoint());
    assertEquals(new Point(-1, 0), status.tail().getPoint());
  }

  @Test
  public void moveInLineU() {
    Knot head = day09.rope(2);
    head.setPoint(new Point(0, 1));
    Status status = new Day09().move("U 1", new Status(head, new HashSet<Point>()));

    assertEquals(1, status.visited().size());
    assertTrue(status.visited().contains(new Point(0, 1)));
    assertEquals(new Point(0, 2), status.head().getPoint());
    assertEquals(new Point(0, 1), status.tail().getPoint());
  }

  @Test
  public void moveInLineD() {
    Knot head = day09.rope(2);
    head.setPoint(new Point(0, -1));
    Status status = new Day09().move("D 1", new Status(head, new HashSet<Point>()));

    assertEquals(1, status.visited().size());
    assertTrue(status.visited().contains(new Point(0, -1)));
    assertEquals(new Point(0, -2), status.head().getPoint());
    assertEquals(new Point(0, -1), status.tail().getPoint());
  }

  @Test
  public void moveDiag1U() {
    Knot head = day09.rope(2);
    head.setPoint(new Point(1, 1));
    Status status = new Day09().move("U 1", new Status(head, new HashSet<Point>()));
    assertEquals(1, status.visited().size());
    assertTrue(status.visited().contains(new Point(1, 1)));
    assertEquals(new Point(1, 2), status.head().getPoint());
    assertEquals(new Point(1, 1), status.tail().getPoint());
  }

  @Test
  public void moveDiag1R() {
    Knot head = day09.rope(2);
    head.setPoint(new Point(1, 1));
    Status status = new Day09().move("R 1", new Status(head, new HashSet<Point>()));
    assertEquals(1, status.visited().size());
    assertTrue(status.visited().contains(new Point(1, 1)));
    assertEquals(new Point(2, 1), status.head().getPoint());
    assertEquals(new Point(1, 1), status.tail().getPoint());
  }

  @Test
  public void moveDiag1Rrope3() {
    Knot head = day09.rope(3);
    head.setPoint(new Point(1, 1));
    Status status = new Day09().move("R 10", new Status(head, new HashSet<Point>()));
    assertEquals(9, status.visited().size());
    assertTrue(status.visited().contains(new Point(1, 1)));
    assertEquals(new Point(11, 1), status.head().getPoint());
    for (int i = 1; i <= 9; i++) {
      assertEquals(new Point(9, 1), status.tail().getPoint());
    }
  }

  @Test
  public void moveDiag1D() {
    Knot head = day09.rope(2);
    head.setPoint(new Point(-1, -1));
    Status status = new Day09().move("D 1", new Status(head, new HashSet<Point>()));
    assertEquals(1, status.visited().size());
    assertTrue(status.visited().contains(new Point(-1, -1)));
    assertEquals(new Point(-1, -2), status.head().getPoint());
    assertEquals(new Point(-1, -1), status.tail().getPoint());
  }

  @Test
  public void moveDiag1L() {
    Knot head = day09.rope(2);
    head.setPoint(new Point(-1, -1));

    Status status = new Day09().move("L 1", new Status(head, new HashSet<Point>()));
    assertEquals(1, status.visited().size());
    assertTrue(status.visited().contains(new Point(-1, -1)));
    assertEquals(new Point(-2, -1), status.head().getPoint());
    assertEquals(new Point(-1, -1), status.tail().getPoint());
  }

  @Test
  public void moveDiag1DBack() {
    Knot head = day09.rope(2);
    head.setPoint(new Point(1, 1));
    Status status = new Day09().move("D 1", new Status(head, new HashSet<Point>()));
    assertEquals(0, status.visited().size());
    assertEquals(new Point(1, 0), status.head().getPoint());
    assertEquals(new Point(0, 0), status.tail().getPoint());
  }

  @Test
  public void moveDiag1UBack() {
    Knot head = day09.rope(2);
    head.setPoint(new Point(-1, -1));
    Status status = new Day09().move("U 1", new Status(head, new HashSet<Point>()));
    assertEquals(0, status.visited().size());
    assertEquals(new Point(-1, 0), status.head().getPoint());
    assertEquals(new Point(0, 0), status.tail().getPoint());
  }

  @Test
  public void moveDiag1RBack() {
    Knot head = day09.rope(2);
    head.setPoint(new Point(-1, -1));
    Status status = new Day09().move("R 1", new Status(head, new HashSet<Point>()));
    assertEquals(0, status.visited().size());
    assertEquals(new Point(0, -1), status.head().getPoint());
    assertEquals(new Point(0, 0), status.tail().getPoint());
  }

  @Test
  public void moveDiag1LBack() {
    Knot head = day09.rope(2);
    head.setPoint(new Point(1, 1));
    Status status = new Day09().move("L 1", new Status(head, new HashSet<Point>()));
    assertEquals(0, status.visited().size());
    assertEquals(new Point(0, 1), status.head().getPoint());
    assertEquals(new Point(0, 0), status.tail().getPoint());
  }

  @Test
  public void moveDiagLBackMultiple() {
    Knot head = day09.rope(2);
    head.setPoint(new Point(1, 1));
    Status status = new Day09().move("L 4", new Status(head, new HashSet<Point>()));
    assertEquals(2, status.visited().size());
    assertEquals(new Point(-3, 1), status.head().getPoint());
    assertEquals(new Point(-2, 1), status.tail().getPoint());
  }

  @Test
  public void moveLineLBackMultiple() {
    Knot head = day09.rope(2);
    head.setPoint(new Point(1, 0));
    Status status = new Day09().move("L 4", new Status(head, new HashSet<Point>()));
    assertEquals(2, status.visited().size());
    assertEquals(new Point(-3, 0), status.head().getPoint());
    assertEquals(new Point(-2, 0), status.tail().getPoint());
  }

  @Test
  public void moveLineUBackMultiple() {
    Knot head = day09.rope(2);
    head.setPoint(new Point(0, -1));
    Set<Point> visited =
        new HashSet<Point>(List.of(new Point(0, 0), new Point(0, 1), new Point(0, 2)));
    Status status = new Day09().move("U 4", new Status(head, visited));
    assertEquals(3, status.visited().size());
    assertEquals(new Point(0, 3), status.head().getPoint());
    assertEquals(new Point(0, 2), status.tail().getPoint());
  }

  @Test
  public void moveLineRDoubleDigits() {
    Knot head = day09.rope(2);
    Status status = new Day09().move("R 40", new Status(head, new HashSet<Point>()));
    assertEquals(39, status.visited().size());
    assertEquals(new Point(40, 0), status.head().getPoint());
    assertEquals(new Point(39, 0), status.tail().getPoint());
  }

  @Test
  public void moveLineLoop() {
    Knot head = day09.rope(2);
    Status status = new Day09().move("R 2", new Status(head, new HashSet<Point>()));
    status = new Day09().move("U 2", status);
    assertEquals(2, status.visited().size());
    assertEquals(new Point(2, 2), status.head().getPoint());
    assertEquals(new Point(2, 1), status.tail().getPoint());
  }

  @Test
  public void testWith10() {
    Knot head = day09.rope(10);
    Status status = new Day09().move("R 4", new Status(head, new HashSet<Point>()));
    status = new Day09().move("U 4", status);
    Knot h = status.head();
    assertEquals(new Point(4, 4), h.getPoint());
    h = h.next();
    assertEquals(new Point(4, 3), h.getPoint());
    h = h.next();
    assertEquals(new Point(4, 2), h.getPoint());
    h = h.next();
    assertEquals(new Point(3, 2), h.getPoint());
    h = h.next();
    assertEquals(new Point(2, 2), h.getPoint());
    h = h.next();
    assertEquals(new Point(1, 1), h.getPoint());
    h = h.next();
    assertEquals(new Point(0, 0), h.getPoint());
  }

  @Test
  public void test1() throws IOException {
    assertEquals(13, day09.solveStep1(bufReader(prefix, "-test")));
    assertEquals(6339, day09.solveStep1(bufReader(prefix, "")));
  }

  @Test
  public void test2() throws IOException {
    assertEquals(1, day09.solveStep2(bufReader(prefix, "-test")));
    assertEquals(36, day09.solveStep2(bufReader(prefix, "-test2")));
    assertEquals(2541, day09.solveStep2(bufReader(prefix)));
  }
}
