package advent.day02;

import org.junit.Test;

import static advent.utils.Utils.input;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

public class Day2Test {

  @Test
  public void test() throws IOException {
    assertEquals(12855, new Day2().solveStep1(input("day02")));
    assertEquals(13726, new Day2().solveStep2(input("day02")));
  }
}
