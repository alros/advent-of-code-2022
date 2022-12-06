package advent.day06;

public class Day06 {

	public int solveStep1(String line) {
		return solve(line, 4);
	}

	public int solveStep2(String line) {
		return solve(line, 14);
	}

	private int solve(String line, int amount) {
		String candidate = "";
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			int index = candidate.indexOf(ch);
			if (index >= 0) {
				candidate = candidate.substring(index + 1);
			}
			candidate += ch;
			if (candidate.length() == amount) {
				return i + 1;
			}
		}
		return -1;
	}

}
