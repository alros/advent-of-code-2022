package advent.day03;

import static advent.utils.Utils.input;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import org.junit.Test;

public class Day3Test {

  @Test
  public void test() throws IOException {
    assertEquals(7716, new Day3().solveStep1(input("day03")));
    assertEquals(2973, new Day3().solveStep2(input("day03")));
  }
}
