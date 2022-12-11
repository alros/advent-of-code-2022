package advent.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day11 {

	public long solveStep1(BufferedReader br) throws IOException {
		return solve(br,20,3);
	}
	
	public long solveStep2(BufferedReader br) throws IOException {
		return solve(br,10000,1);
	}
	
  public long solve(BufferedReader br, int loops, int factor)
      throws IOException {
    List<Monkey> monkeys = parseAllMonkeys(br);

    int lcm = monkeys.stream().map(m -> m.getDivisible()).reduce((a, b) -> a * b).get();

    for (int round = 0; round < loops; round++) {
    	monkeys.forEach(monkey-> play(monkey, monkeys, factor, lcm));
    }

    return monkeys.stream()
            .sorted((a, b) -> b.getInspected() - a.getInspected())
            .limit(2)
            .map(m->(long)m.getInspected())
            .reduce((a,b)->a*b)
            .get();
  }

private List<Monkey> parseAllMonkeys(BufferedReader br) throws IOException {
	List<Monkey> monkeys = new ArrayList<>();
    while( br.readLine() != null) {
      monkeys.add(parseMonkey(br));
    }
	return monkeys;
}

  private Monkey parseMonkey(BufferedReader br) throws IOException {
    return Monkey.builder().worryLevel(new ArrayList<>(
            Arrays.stream(gerFirstLine(br).split(":")[1].split(",")).map(n -> Long.parseLong(n.trim())).toList()))
    		.operation(br.readLine().split(":")[1].split("=")[1])
    		.divisible(Integer.parseInt(br.readLine().trim().split(" ")[3]))
    		.monkeyTrue(Integer.parseInt(br.readLine().trim().split(" ")[5]))
    		.monkeyFalse( Integer.parseInt(br.readLine().trim().split(" ")[5]))
    		.build();
  }

private String gerFirstLine(BufferedReader br) throws IOException {
	String line = br.readLine();
    if (line.isEmpty() || line.indexOf("Monkey") == 0) {
      line = br.readLine();
    }
	return line;
}

  private void play(Monkey monkey, List<Monkey> monkeys, int factor, int lcm){
    while (!monkey.getWorryLevel().isEmpty()) {
      long newWorryLevel =
          calculate(monkey.getOperation().replaceAll("old", monkey.getWorryLevel().remove(0).toString()), factor);
      monkeys.get(newWorryLevel % monkey.getDivisible() == 0?monkey.getMonkeyTrue():monkey.getMonkeyFalse()).getWorryLevel().add(newWorryLevel % lcm);
      monkey.incInspected();
    }
  }

  private long calculate(String expr, int factor) {
    String[] split = expr.trim().split(" ");
    long a = Long.parseLong(split[0]);
    long b = Long.parseLong(split[2]);
    if ("*".equals(split[1])) {
      return a * b / factor;
    } else {
      return (a + b) / factor;
    }
  }


}
