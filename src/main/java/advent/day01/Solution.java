package advent.day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	private static final Path INPUT_FILE = Path.of("input/day1/input.txt");
//	private static final Path INPUT_FILE = Path.of("input/day1/input-test.txt");

	public static void main(String[] args) throws IOException {
		Solution solution = new Solution();
		System.out.println("step1: " + solution.solveStep1());
		System.out.println("step2: " + solution.solveStep2());
	}

	public int solveStep1() throws IOException {
		return getSortedElves().get(0);
	}

	public int solveStep2() throws IOException {
		return getSortedElves().stream().limit(3).reduce(0, (a, b) -> a + b);
	}

	private List<Integer> getSortedElves() throws IOException {
		var elves = new LinkedList<Integer>(List.of(0));
		for (String line : Files.readAllLines(INPUT_FILE)) {
			if (line.isBlank()) {
				elves.add(0);
			} else {
				elves.add(elves.removeLast() + Integer.parseInt(line));
			}
		}
		Collections.sort(elves, (a, b) -> b - a);
		return elves;
	}
}
