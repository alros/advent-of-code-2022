package advent.day02;

import java.util.Arrays;
import java.util.Set;

public enum Shape {
	Rock(1,"A","X"), Paper(2,"B","Y"), Scissors(3,"C","Z");

	private final int score;
	private final Set<String> aliases;

	Shape(int score, String... aliases) {
		this.score = score;
		this.aliases = Set.of(aliases);
	}

	public int getScore() {
		return score;
	}

	public int scoreAgainst(Shape shape) {
		if ((equals(Rock) && shape.equals(Scissors)) || (equals(Paper) && shape.equals(Rock))
				|| (equals(Scissors) && shape.equals(Paper))) {
			return 6;
		} else if (equals(shape)) {
			return 3;
		} else {
			return 0;
		}
	}
	
	public boolean hasAlias(String alias) {
		return aliases.contains(alias);
	}

	public static Shape fromValue(String value) {
		return Arrays.stream(values()).filter(v -> v.hasAlias(value)).findFirst().get();
	}

	public Shape getByOutcome(String outcome) {
		return "X".equals(outcome)?getLoosingShape():"Y".equals(outcome)?this:getWinningShape();
	}

	Shape getLoosingShape() {
		if(equals(Rock)) {
			return Scissors;
		}else if(equals(Scissors)) {
			return Paper;
		}else {
			return Rock;
		}
	}
	Shape getWinningShape() {
		if(equals(Rock)) {
			return Paper;
		}else if(equals(Scissors)) {
			return Rock;
		}else {
			return Scissors;
		}
	}
	
}