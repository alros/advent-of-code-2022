package advent.day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class Day09 {

	public long solveStep1(BufferedReader br) throws IOException {
		Status status = new Status(rope(2), new HashSet<>(List.of(new Point(0, 0))));
		for (String line = br.readLine(); line != null; line = br.readLine()) {
			status = move(line, status);
		}
		return status.visited().size();
	}

	public int solveStep2(BufferedReader br) throws IOException {
		Status status = new Status(rope(10), new HashSet<>(List.of(new Point(0, 0))));
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
		String[] split = line.split(" ");
		int[] inc=getInc(split[0]);
		for (int steps = Integer.parseInt(split[1]); steps > 0; steps--) {
			Knot head = status.head();
			Point oldHead = head.getPoint();
			head.setPoint(new Point(head.getPoint().x() + inc[0], head.getPoint().y() + inc[1]));
			while (head.next() != null) {
				Point oldTail = head.next().getPoint();
				Point newTail = chaseHead(head.getPoint(), oldHead, oldTail);
				if (!oldTail.equals(newTail) && head.next().next()==null) {
					status.visited().add(newTail);
				}
				if(!newTail.equals(oldTail)) {
					head.next().setPoint(newTail);
					oldHead=oldTail;
					head=head.next();
				}else {
					break;
				}
			}
		}
		System.out.println(line);
		for(Knot h=status.head();h!=null;h=h.next()) {
			System.out.println(h);
		}
		return status;
	}
	
	private int[] getInc(String dir) {
		int incX = 0;
		int incY = 0;
		if ("R".equals(dir)) {
			incX = 1;
		} else if ("L".equals(dir)) {
			incX = -1;
		} else if ("D".equals(dir)) {
			incY = -1;
		} else {
			incY = 1;
		}
		return new int[] {incX,incY};
	}

	private Point chaseHead(Point head, Point oldHead, Point oldTail) {
		if (Math.abs(head.x() - oldTail.x()) <= 1 && (Math.abs(head.y() - oldTail.y()) <= 1)) {
			// overlap || touching
			return oldTail;
		} else {
			return oldHead;
		}
	}

}
