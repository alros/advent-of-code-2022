package advent.day06;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Test;

public class Day6Test {

  @Test
  public void test() throws IOException {
    try (BufferedReader r = new BufferedReader(new FileReader("input/day06/input-test.txt"))) {
      assertEquals(7, new Day06().solveStep1(r.readLine()));
      assertEquals(5, new Day06().solveStep1(r.readLine()));
      assertEquals(6, new Day06().solveStep1(r.readLine()));
      assertEquals(10, new Day06().solveStep1(r.readLine()));
      assertEquals(11, new Day06().solveStep1(r.readLine()));
    }

    try (BufferedReader r = new BufferedReader(new FileReader("input/day06/input-test.txt"))) {
      assertEquals(19, new Day06().solveStep2(r.readLine()));
      assertEquals(23, new Day06().solveStep2(r.readLine()));
      assertEquals(23, new Day06().solveStep2(r.readLine()));
      assertEquals(29, new Day06().solveStep2(r.readLine()));
      assertEquals(26, new Day06().solveStep2(r.readLine()));
    }

    try (BufferedReader r = new BufferedReader(new FileReader("input/day06/input.txt"))) {
      assertEquals(1876, new Day06().solveStep1(r.readLine()));
    }

    try (BufferedReader r = new BufferedReader(new FileReader("input/day06/input.txt"))) {
      assertEquals(2202, new Day06().solveStep2(r.readLine()));
    }
  }
}
