package advent.day12;

import static advent.utils.Utils.bufReader;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import advent.day12.Day12.Point;
import java.io.IOException;
import java.util.List;
import javax.script.ScriptException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class Day12Test {

  private static final Day12 day12 = new Day12();
  private static final String prefix = "day12";

  private List<String> map;

  @Before
  public void setup() throws IOException {
    map = day12.parseMap((bufReader(prefix, "-test")));
  }

  @Test
  public void testFindStart() throws IOException {
    int[] pos = day12.locatePosition(map, "S").get(0);
    assertEquals(0, pos[0]);
    assertEquals(0, pos[1]);
  }

  @Test
  public void testFindEnd() throws IOException, ScriptException {
    int[] pos = day12.locatePosition(map, "E").get(0);
    assertEquals(2, pos[0]);
    assertEquals(5, pos[1]);
  }

  @Test
  public void testCantMoveBorder() throws IOException, ScriptException {
    assertFalse(day12.canMove(map, new Point(0, 0), new Point(0, -1)));
    assertFalse(day12.canMove(map, new Point(0, 0), new Point(-1, 0)));
    assertFalse(day12.canMove(map, new Point(7, 4), new Point(7, 5)));
    assertFalse(day12.canMove(map, new Point(7, 4), new Point(8, 4)));
  }

  @Test
  public void testCantMoveInner() throws IOException, ScriptException {
    assertFalse(day12.canMove(map, new Point(0, 2), new Point(0, 3)));
    assertFalse(day12.canMove(map, new Point(2, 7), new Point(2, 6)));
  }

  @Test
  public void testCanMove() throws IOException, ScriptException {
    assertTrue(day12.canMove(map, new Point(0, 1), new Point(0, 2)));
    assertTrue(day12.canMove(map, new Point(2, 2), new Point(2, 1)));
    assertTrue(day12.canMove(map, new Point(1, 2), new Point(2, 2)));
    assertTrue(day12.canMove(map, new Point(2, 7), new Point(1, 7)));
  }

  @Test
  public void testStep1Ex() throws IOException, ScriptException {
    assertEquals(31, day12.solveStep1(bufReader(prefix, "-test")));
  }

  @Test
  public void testStep1() throws IOException, ScriptException {
    assertEquals(520, day12.solveStep1(bufReader(prefix, "")));
  }

  @Test
  public void testStep2Ex() throws IOException, ScriptException {
    assertEquals(29, day12.solveStep2(bufReader(prefix, "-test")));
  }

  @Test
  public void testStep2() throws IOException, ScriptException {
    assertEquals(508, day12.solveStep2(bufReader(prefix, "")));
  }

  @Test
  @Ignore // remove @Ignore to run the visualisation
  public void testStepDisplay() throws IOException, ScriptException {
    new Day12(true).solveStep1(bufReader(prefix, ""));
  }
}
