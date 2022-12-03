package advent.day03;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class SolutionTest {

	@Test
	public void test() throws IOException {
		assertEquals(7716, new Solution().solveStep1());
		assertEquals(2973, new Solution().solveStep2());
	}
	
}
