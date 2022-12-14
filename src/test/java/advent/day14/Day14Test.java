package advent.day14;

import static advent.utils.Utils.bufReader;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

public class Day14Test {

	private static final Day14 day14 = new Day14();
	private static final String prefix = "day14";

	@Test
	public void testInput1Ex() throws IOException {
		assertEquals(24, day14.solveStep1(bufReader(prefix, "-test")));
	}

	@Test
	public void testInput1() throws IOException {
		assertEquals(885, day14.solveStep1(bufReader(prefix)));
	}

	@Test
	public void testInput2Ex() throws IOException {
		assertEquals(93, day14.solveStep2(bufReader(prefix, "-test")));
	}

	@Test
	public void testInput2() throws IOException {
		assertEquals(28691, day14.solveStep2(bufReader(prefix)));
	}

	@Test
	@Ignore
	public void testInput2View() throws IOException {
		new Day14(true).solveStep2(bufReader(prefix));
	}

}
