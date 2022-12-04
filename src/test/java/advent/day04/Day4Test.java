package advent.day04;

import static advent.utils.Utils.input;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class Day4Test {

	@Test
	public void test() throws IOException {
		assertEquals(644, new Day4().solveStep1(input("day04")));
		assertEquals(926, new Day4().solveStep2(input("day04")));
	}
}
