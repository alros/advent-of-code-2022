package advent.day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.BiFunction;

public class Solution {

	private static final Path INPUT_FILE = Path.of("input/day2/input.txt");
//	private static final Path INPUT_FILE = Path.of("input/day2/input-test.txt");

	public static void main(String[] args) throws IOException {
		Solution solution = new Solution();
		System.out.println("step1: " + solution.solveStep1());
		System.out.println("step2: " + solution.solveStep2());
	}

	public int solveStep1() throws IOException {
		return solve((opponentHand, outcome) -> Shape.fromValue(outcome));
	}

	public int solveStep2() throws IOException {
		return solve((opponentHand, outcome) -> opponentHand.getByOutcome(outcome));
	}

	private int solve(BiFunction<Shape, String, Shape> mapping) throws IOException {
		return Files.readAllLines(INPUT_FILE).stream().map(line -> line.split(" ")).map(split -> {
			Shape opponentHand = Shape.fromValue(split[0]);
			Shape myHand = mapping.apply(opponentHand, split[1]);
			return myHand.getScore() + myHand.scoreAgainst(opponentHand);
		}).reduce(0, (a, b) -> a + b);
	}

}
