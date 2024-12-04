package advent.day01;

import org.junit.Test;

import static advent.utils.Utils.input;
import static org.junit.Assert.assertEquals;


public class Day1Test {

    @Test
    public void step1() throws Exception {
        assertEquals(66487, new Day1().solveStep1(input("day01")));
    }

    @Test
    public void step2() throws Exception {
        assertEquals(197301, new Day1().solveStep2(input("day01")));
    }
}
