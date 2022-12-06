package advent.day05;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day5 {

	public String solveStep1(Stream<String> inputStream) {
		return solve(inputStream, 0);
	}

	public String solveStep2(Stream<String> inputStream) {
		return solve(inputStream, 1);
	}

	private String solve(Stream<String> inputStream, int positionIncrement) {
		String[] lines = inputStream.toList().toArray(new String[0]);

		int index = 0;
		
		List<List<String>> stacks = new ArrayList<>();
		while (stacks.size() < (lines[0].length() + 1) / 4) {
			stacks.add(new Stack<>());
		}

		for (; index < lines.length && lines[index].charAt(1) != '1'; index++) {
			String[] charArray = lines[index].split("");
			for (int i = 0; 1 + i * 4 < charArray.length; i++) {
				if (!charArray[1 + i * 4].isBlank()) {
					stacks.get(i).add(charArray[1 + i * 4]);
				}
			}
		}

		index += 2;

		for (; index < lines.length; index++) {
			String[] split = lines[index].split(" ");
			for (int amount = parseInt(split[1]), position = 0; amount > 0; amount--, position += positionIncrement) {
				stacks.get(parseInt(split[5]) - 1).add(position, stacks.get(parseInt(split[3]) - 1).remove(0));
			}
		}

		return stacks.stream().map(s -> s.get(0)).collect(Collectors.joining());
	}
}
