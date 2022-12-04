package advent.day04;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() throws IOException {
		assertEquals(644, new Solution().solveStep1());
		assertEquals(926, new Solution().solveStep2());
	}
}
