package advent.day05;

import static advent.utils.Utils.input;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import org.junit.Test;

public class Day5Test {

  @Test
  public void test() throws IOException {
    assertEquals("FRDSQRRCD", new Day5().solveStep1(input("day05")));
    assertEquals("HRFTQVWNN", new Day5().solveStep2(input("day05")));
  }
}
