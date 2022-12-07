package advent.day01;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Day1 {

  public int solveStep1(Stream<String> inputStream) throws IOException {
    return getSortedElves(inputStream).get(0);
  }

  public int solveStep2(Stream<String> inputStream) throws IOException {
    return getSortedElves(inputStream).stream().limit(3).reduce(0, (a, b) -> a + b);
  }

  private List<Integer> getSortedElves(Stream<String> inputStream) throws IOException {
    var elves = new LinkedList<Integer>(List.of(0));
    inputStream.forEach(
        line -> elves.add(line.isBlank() ? 0 : elves.removeLast() + Integer.parseInt(line)));
    Collections.sort(elves, (a, b) -> b - a);
    return elves;
  }
}
