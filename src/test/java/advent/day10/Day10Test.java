package advent.day10;

import static advent.utils.Utils.bufReader;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import org.junit.Test;

public class Day10Test {

	private static final Day10 day10 = new Day10();
	private static final String prefix = "day10";

	@Test
	public void testCalculateX() throws IOException {
		List<Integer> calculateX = day10.calculateX(bufReader(prefix, "-test2"), System.out);
		int d = 1;
		assertEquals(21, calculateX.get(20 - d).intValue());
		assertEquals(19, calculateX.get(60 - d).intValue());
		assertEquals(18, calculateX.get(100 - d).intValue());
		assertEquals(16, calculateX.get(180 - d).intValue());
		assertEquals(18, calculateX.get(220 - d).intValue());
	}

	@Test
	public void testInterestingCycles() throws IOException {
		assertEquals(List.of(420, 1140, 1800, 2940, 2880, 3960),
				day10.getInterestingCycles(bufReader(prefix, "-test2"), System.out));
	}

	@Test
	public void testExample1() throws IOException {
		assertEquals(13140, day10.solve(bufReader(prefix, "-test2"), System.out));
	}

	@Test
	public void testSol1() throws IOException {
		assertEquals(14820, day10.solve(bufReader(prefix, ""), System.out));
	}

	@Test
	public void testExample2() throws IOException {
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		day10.solve(bufReader(prefix, "-test2"), new PrintStream(buf));
		assertEquals("##..##..##..##..##..##..##..##..##..##..\n"//
				+ "###...###...###...###...###...###...###.\n"//
				+ "####....####....####....####....####....\n"//
				+ "#####.....#####.....#####.....#####.....\n"//
				+ "######......######......######......####\n"//
				+ "#######.......#######.......#######.....\n", //
				new String(buf.toByteArray()));
	}

	@Test
	public void testSol2() throws IOException {
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		day10.solve(bufReader(prefix, ""), new PrintStream(buf));
		assertEquals("###..####.####.#..#.####.####.#..#..##..\n"//
				+ "#..#....#.#....#.#..#....#....#..#.#..#.\n"//
				+ "#..#...#..###..##...###..###..####.#..#.\n"//
				+ "###...#...#....#.#..#....#....#..#.####.\n"//
				+ "#.#..#....#....#.#..#....#....#..#.#..#.\n"//
				+ "#..#.####.####.#..#.####.#....#..#.#..#.\n", //
				new String(buf.toByteArray()));
	}

}
