package advent.day02;

import java.util.function.BiFunction;
import java.util.stream.Stream;

public class Day2 {

  public int solveStep1(Stream<String> inputStream) {
    return solve(inputStream, (opponentHand, outcome) -> Shape.fromValue(outcome));
  }

  public int solveStep2(Stream<String> inputStream) {
    return solve(inputStream, (opponentHand, outcome) -> opponentHand.getByOutcome(outcome));
  }

  private int solve(Stream<String> inputStream, BiFunction<Shape, String, Shape> mapping) {
    return inputStream
        .map(line -> line.split(" "))
        .map(
            split -> {
              Shape opponentHand = Shape.fromValue(split[0]);
              Shape myHand = mapping.apply(opponentHand, split[1]);
              return myHand.getScore() + myHand.scoreAgainst(opponentHand);
            })
        .reduce(0, (a, b) -> a + b);
  }
}
