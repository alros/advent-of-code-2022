package advent.day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day09 {

	public long solveStep1(BufferedReader br) throws IOException {
		Status status = new Status(List.of(new Point(0, 0), new Point(0, 0)), new HashSet<>(List.of(new Point(0, 0))));
		for (String line = br.readLine(); line != null; line = br.readLine()) {
			status = move(line, status);
		}
		return status.visited().size();
	}

	Status move(String line, Status status) {
		Point tail = status.tail();
		Point head = status.head();
		Set<Point> visited = status.visited();
		String[] split = line.split(" ");
		int incX = 0;
		int incY = 0;
		if ("R".equals(split[0])) {
			incX = 1;
		} else if ("L".equals(split[0])) {
			incX = -1;
		} else if ("D".equals(split[0])) {
			incY = -1;
		} else {
			incY = 1;
		}
		for (int steps = Integer.parseInt(split[1]); steps > 0; steps--) {
			Point oldHead = head;
			head = new Point(head.x() + incX, head.y() + incY);
			if (Math.abs(head.x() - tail.x()) <= 1 && (Math.abs(head.y() - tail.y()) <= 1)) {
				// overlap || touching
				continue;
			} else {
				tail = oldHead;
			}
			visited.add(tail);
		}
		return new Status(List.of(head, tail), visited);
	}

	public int solveStep2(BufferedReader br) throws IOException {
		return 0;
	}

}
