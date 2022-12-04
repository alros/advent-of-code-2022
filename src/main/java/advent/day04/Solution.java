package advent.day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.function.Predicate;

public class Solution {

	private static final Path INPUT_FILE = Path.of("input/day04/input.txt");
//	private static final Path INPUT_FILE = Path.of("input/day04/input-test.txt");

	public static void main(String[] args) throws IOException {
		Solution solution = new Solution();
		System.out.println("step1: " + solution.solveStep1());
		System.out.println("step2: " + solution.solveStep2());
	}

	public long solveStep1() throws IOException {
		return findOverlap(arr -> 
			   (arr[0] <= arr[2] && arr[1] >= arr[3])
			|| (arr[0] >= arr[2] && arr[1] <= arr[3]));
	}
	public long solveStep2() throws IOException {
		return findOverlap(arr -> 
			   (arr[0] >= arr[2] && arr[0] <= arr[3])
			 ||(arr[1] >= arr[2] && arr[1] <= arr[3])
			 ||(arr[2] >= arr[0] && arr[2] <= arr[1])
			 ||(arr[3] >= arr[0] && arr[3] <= arr[1]));
	}
		
	private long findOverlap(Predicate<? super Integer[]> filter) throws IOException {
		return Files.readAllLines(INPUT_FILE).stream()
				.map(line -> line.split("[,-]"))
				.map(arr -> Arrays.asList(arr).stream().map(Integer::parseInt).toList().toArray(new Integer[4]))
				.filter(filter)
				.count();
	}

}
