package advent.day02;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class SolutionTest {

	@Test
	public void test() throws IOException {
		assertEquals(12855, new Solution().solveStep1());
		assertEquals(13726, new Solution().solveStep2());
	}
}
