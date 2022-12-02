package advent.day02;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public enum Shape {
	Rock(1, "A", "X"), Paper(2, "B", "Y"), Scissors(3, "C", "Z");

	private final static Map<Shape, Shape> wins;
	private final int score;
	private final Set<String> aliases;

	static {
		wins = Map.of(Rock, Scissors, Scissors, Paper, Paper, Rock);
	}

	Shape(int score, String... aliases) {
		this.score = score;
		this.aliases = Set.of(aliases);
	}

	public int getScore() {
		return score;
	}

	public int scoreAgainst(Shape shape) {
		return getLoosingShape().equals(shape) ? 6 : equals(shape) ? 3 : 0;
	}

	public boolean hasAlias(String alias) {
		return aliases.contains(alias);
	}

	public static Shape fromValue(String value) {
		return Arrays.stream(values()).filter(v -> v.hasAlias(value)).findFirst().get();
	}

	public Shape getByOutcome(String outcome) {
		return "X".equals(outcome) ? getLoosingShape() : "Y".equals(outcome) ? this : getWinningShape();
	}

	Shape getLoosingShape() {
		return wins.get(this);
	}

	Shape getWinningShape() {
		return Arrays.stream(values()).filter(v->v.getLoosingShape().equals(this)).findFirst().get();
	}

}