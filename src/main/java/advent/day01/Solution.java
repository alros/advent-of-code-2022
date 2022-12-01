package advent.day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	private static final Path INPUT_FILE = Path.of("input/day1/input.txt");
//	private static final Path INPUT_FILE = Path.of("input/day1/input-test.txt");

	public static void main(String[] args) throws IOException {
		Solution solution = new Solution();
		System.out.println("step1: "+solution.solveStep1());
		System.out.println("step2: "+solution.solveStep2());
	}

	public int solveStep1() throws IOException {
		return getTop(1);
	}

	public int solveStep2() throws IOException {
		return getTop(3);
	}
	
	public int getTop(int amount) throws IOException {
		var tot = 0;
		var elves = getSortedElves();
		for(int i=1;i<=amount;i++) {
			tot+=elves.get(elves.size() - i);
		}
		return tot;
	}

	private List<Integer> getSortedElves() throws IOException {
		var caloriesCurrentElf = 0;
		var elves = new ArrayList<Integer>();
		for (String line : Files.readAllLines(INPUT_FILE)) {
			if (line.isBlank()) {
				elves.add(caloriesCurrentElf);
				caloriesCurrentElf = 0;
			} else {
				caloriesCurrentElf += Integer.parseInt(line);
			}
		}
		elves.add(caloriesCurrentElf);
		Collections.sort(elves);
		return elves;
	}
}
