package advent.day01;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class SolutionTest {

	@Test
	public void step1() throws Exception {
		assertEquals(66487, new Solution().solveStep1());
	}
	@Test
	public void step2() throws Exception {
		assertEquals(197301, new Solution().solveStep2());
	}
}
