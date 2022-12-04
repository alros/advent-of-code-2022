package advent;

import static advent.utils.Utils.input;

import java.io.IOException;

import advent.day01.Day1;
import advent.day02.Day2;
import advent.day03.Day3;
import advent.day04.Day4;

public class Runner {

	public static void main(String[] args) throws IOException {
		System.out.println("day 1 - step 1: "+new Day1().solveStep1(input("day01")));
		System.out.println("day 1 - step 2: "+new Day1().solveStep2(input("day01")));
		System.out.println("day 2 - step 1: "+new Day2().solveStep1(input("day02")));
		System.out.println("day 2 - step 2: "+new Day2().solveStep2(input("day02")));
		System.out.println("day 3 - step 1: "+new Day3().solveStep1(input("day03")));
		System.out.println("day 3 - step 2: "+new Day3().solveStep2(input("day03")));
		System.out.println("day 4 - step 1: "+new Day4().solveStep1(input("day04")));
		System.out.println("day 4 - step 2: "+new Day4().solveStep2(input("day04")));
	}

}
