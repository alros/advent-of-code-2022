package advent.day07;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class Day08 {

	public long solveStep1(Stream<String> stream) throws IOException {
		Integer[][] trees = map(stream);
		return Arrays.stream(findVisible(trees)).filter(i -> i > 0).count();
	}

	private Integer[][] map(Stream<String> stream) throws IOException {
		return stream.map(line -> Arrays.stream(line.split("")).map(Integer::parseInt).toList().toArray(new Integer[0]))
				.toList().toArray(new Integer[0][0]);
	}

	private int[] findVisible(Integer[][] trees) {
		int[] visible = new int[trees.length * trees[0].length];

		for (int x = 0; x < trees.length; x++) {
			int cur = trees[x][0];
			visible[x] = 1;
			for (int y = 1; y < trees[x].length; y++) {
				cur = checkAndUpdate(trees, visible, cur, x, y);
			}
		}

		for (int x = 0; x < trees.length; x++) {
			int cur = trees[x][trees[0].length - 1];
			visible[x + trees.length * (trees[0].length - 1)] = 1;
			for (int y = trees[0].length - 2; y >= 0; y--) {
				cur = checkAndUpdate(trees, visible, cur, x, y);
			}
		}

		for (int y = 0; y < trees[0].length; y++) {
			int cur = trees[0][y];
			visible[y * trees.length] = 1;
			for (int x = 1; x < trees.length; x++) {
				cur = checkAndUpdate(trees, visible, cur, x, y);
			}
		}

		for (int y = 0; y < trees[0].length; y++) {
			int cur = trees[trees.length - 1][y];
			visible[trees.length - 1 + y * trees.length] = 1;
			for (int x = trees.length - 2; x >= 0; x--) {
				cur = checkAndUpdate(trees, visible, cur, x, y);
			}
		}

		return visible;
	}

	private int checkAndUpdate(Integer[][] trees, int[] visible, int cur, int x, int y) {
		if (cur < trees[x][y]) {
			cur = trees[x][y];
			visible[x + y * trees.length] = 1;
		}
		return cur;
	}

	public int solveStep2(Stream<String> stream) throws IOException {
		Integer[][] trees = map(stream);
		int max = 0;
		for (int x = 0; x < trees.length; x++) {
			for (int y = 0; y < trees[x].length; y++) {

				int a = 0, b = 0, c = 0, d = 0;
				for (int j = y + 1; j < trees[0].length; j++) {
					a++;
					if (trees[x][j] >= trees[x][y]) {
						break;
					}
				}
				for (int j = y - 1; j >= 0; j--) {
					b++;
					if (trees[x][j] >= trees[x][y]) {
						break;
					}
				}
				for (int i = x + 1; i < trees.length; i++) {
					c++;
					if (trees[i][y] >= trees[x][y]) {
						break;
					}
				}
				for (int i = x - 1; i >= 0; i--) {
					d++;
					if (trees[i][y] >= trees[x][y]) {
						break;
					}
				}
				int v = a * b * c * d;
				max = max < v ? v : max;
			}
		}
		return max;
	}
}
