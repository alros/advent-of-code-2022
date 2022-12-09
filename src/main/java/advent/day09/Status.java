package advent.day09;

import java.util.List;
import java.util.Set;

public record Status(List<Point> rope, Set<Point> visited) {

	public Point head() {
		return rope.get(0);
	}
	
	public Point tail() {
		return rope.get(rope.size()-1);
	}
}

