package advent.day08;

import static advent.utils.Utils.input;
import static org.junit.Assert.assertEquals;

import advent.day07.Day08;
import java.io.IOException;
import org.junit.Test;

public class Day08Test {

  @Test
  public void test() throws IOException {
    assertEquals(21, new Day08().solveStep1(input("day08", "-test")));
    assertEquals(8, new Day08().solveStep2(input("day08", "-test")));
    assertEquals(1736, new Day08().solveStep1(input("day08")));
    assertEquals(268800, new Day08().solveStep2(input("day08")));
  }
}
