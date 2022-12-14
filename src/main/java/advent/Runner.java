package advent;

import static advent.utils.Utils.bufReader;
import static advent.utils.Utils.input;
import static advent.utils.Utils.readline;

import advent.day01.Day1;
import advent.day02.Day2;
import advent.day03.Day3;
import advent.day04.Day4;
import advent.day05.Day5;
import advent.day06.Day06;
import advent.day07.Day07;
import advent.day08.Day08;
import advent.day09.Day09;
import advent.day10.Day10;
import advent.day11.Day11;
import advent.day12.Day12;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Runner {

  public static void main(String[] args) throws IOException {
    System.out.println("day  1 - step 1: " + new Day1().solveStep1(input("day01")));
    System.out.println("day  1 - step 2: " + new Day1().solveStep2(input("day01")));
    System.out.print("\n");
    System.out.println("day  2 - step 1: " + new Day2().solveStep1(input("day02")));
    System.out.println("day  2 - step 2: " + new Day2().solveStep2(input("day02")));
    System.out.print("\n");
    System.out.println("day  3 - step 1: " + new Day3().solveStep1(input("day03")));
    System.out.println("day  3 - step 2: " + new Day3().solveStep2(input("day03")));
    System.out.print("\n");
    System.out.println("day  4 - step 1: " + new Day4().solveStep1(input("day04")));
    System.out.println("day  4 - step 2: " + new Day4().solveStep2(input("day04")));
    System.out.print("\n");
    System.out.println("day  5 - step 1: " + new Day5().solveStep1(input("day05")));
    System.out.println("day  5 - step 2: " + new Day5().solveStep2(input("day05")));
    System.out.print("\n");
    System.out.println("day  6 - step 1: " + new Day06().solveStep1(readline("day06")));
    System.out.println("day  6 - step 2: " + new Day06().solveStep2(readline("day06")));
    System.out.print("\n");
    System.out.println("day  7 - step 1: " + new Day07().solveStep1(bufReader("day07")));
    System.out.println("day  7 - step 2: " + new Day07().solveStep2(bufReader("day07")));
    System.out.print("\n");
    System.out.println("day  8 - step 1: " + new Day08().solveStep1(input("day08")));
    System.out.println("day  8 - step 2: " + new Day08().solveStep2(input("day08")));
    System.out.print("\n");
    System.out.println("day  9 - step 1: " + new Day09().solveStep1(bufReader("day09")));
    System.out.println("day  9 - step 2: " + new Day09().solveStep2(bufReader("day09")));
    System.out.print("\n");
    ByteArrayOutputStream buf = new ByteArrayOutputStream();
    System.out.println(
        "day 10 - step 1: " + new Day10().solve(bufReader("day10"), new PrintStream(buf)));
    System.out.println("day 10 - step 2:\n" + new String(buf.toByteArray()));
    System.out.println("day 11 - step 1: " + new Day11().solveStep1(bufReader("day11")));
    System.out.println("day 11 - step 1: " + new Day11().solveStep2(bufReader("day11")));
    System.out.print("\n");
    System.out.println("day 12 - step 1: " + new Day12().solveStep1(bufReader("day12")));
    System.out.println("day 12 - step 2: " + new Day12().solveStep2(bufReader("day12")));
  }
}
