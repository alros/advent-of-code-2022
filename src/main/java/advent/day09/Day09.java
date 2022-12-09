package advent.day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day09 {

	public long solveStep1(BufferedReader br) throws IOException {
		Status status = new Status(rope(2), new HashSet<>(List.of(new Point(0, 0))));
		for (String line = br.readLine(); line != null; line = br.readLine()) {
			status = move(line, status);
		}
		return status.visited().size();
	}

	Knot rope(int len) {
		Knot head = new Knot(new Point(0, 0));
		for (int i = 0; i < len - 1; i++) {
			head = new Knot(new Point(0, 0), head);
		}
		return head;
	}

	Status move(String line, Status status) {
		Knot head = status.head();
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
			Point oldHead = head.getPoint();
			Point oldTail = head.next().getPoint();
			head.setPoint(new Point(head.getPoint().x() + incX, head.getPoint().y() + incY));

			Point newTail = chaseHead(head.getPoint(), oldHead, head.next());
			if (!oldTail.equals(newTail)) {
				visited.add(newTail);
				head.next().setPoint(newTail);
			}
		}
		return new Status(head, visited);
	}

	private Point chaseHead(Point head, Point oldHead, Knot tail) {
		if (Math.abs(head.x() - tail.getPoint().x()) <= 1
				&& (Math.abs(head.y() - tail.getPoint().y()) <= 1)) {
			// overlap || touching
			return tail.getPoint();
		} else {
			return oldHead;
		}
	}

	public int solveStep2(BufferedReader br) throws IOException {
		return 0;
	}

}
