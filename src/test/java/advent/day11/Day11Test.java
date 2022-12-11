package advent.day11;

import static advent.utils.Utils.bufReader;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import javax.script.ScriptException;
import org.junit.Test;

public class Day11Test {

	private static final Day11 day11 = new Day11();
	private static final String prefix = "day11";

	@Test
	public void testStep1Ex() throws IOException, ScriptException {
		assertEquals(10605, day11.solve(bufReader(prefix, "-test"), 20, 3));
	}

	@Test
	public void testStep1() throws IOException, ScriptException {
		assertEquals(72884, day11.solve(bufReader(prefix, ""), 20, 3));
	}

	@Test
	public void testStep2Ex() throws IOException, ScriptException {
		assertEquals(2713310158L, day11.solve(bufReader(prefix, "-test"), 10000, 1));
	}

	@Test
	public void testStep2() throws IOException, ScriptException {
		assertEquals(15310845153L, day11.solve(bufReader(prefix), 10000, 1));
	}

}
