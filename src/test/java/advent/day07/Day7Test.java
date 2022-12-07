package advent.day07;

import static advent.utils.Utils.bufReader;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import org.junit.Test;

public class Day7Test {

  @Test
  public void test() throws IOException {
    assertEquals(95437, new Day07().solveStep1(bufReader("day07", "-test")));
    assertEquals(24933642, new Day07().solveStep2(bufReader("day07", "-test")));
    assertEquals(1581595, new Day07().solveStep1(bufReader("day07")));
    assertEquals(1544176, new Day07().solveStep2(bufReader("day07")));
  }
}
