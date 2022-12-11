package advent.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.script.ScriptException;

public class Day11 {

  public long solve(BufferedReader br, int loops, int divideWorry)
      throws IOException, ScriptException {
    Map<Integer, Monkey> monkeys = new HashMap<>();
    int monkeyId = 0;
    for (; br.readLine() != null; monkeyId++) {
      monkeys.put(monkeyId, parseMonkey(monkeyId, br));
    }

    int lcm = monkeys.values().stream().map(m -> m.getDivisible()).reduce((a, b) -> a * b).get();

    for (int round = 0; round < loops; round++) {
      for (int i = 0; i < monkeyId; i++) {
        play(i, monkeys, divideWorry, lcm);
      }
    }

    List<Monkey> mostActive =
        monkeys.values().stream()
            .sorted((a, b) -> b.getInspected() - a.getInspected())
            .limit(2)
            .toList();
    return ((long) mostActive.get(0).getInspected()) * mostActive.get(1).getInspected();
  }

  private Monkey parseMonkey(int id, BufferedReader br) throws IOException {
    String line = br.readLine();
    if (line.isEmpty() || line.indexOf("Monkey") == 0) {
      line = br.readLine();
    }
    List<Long> worryLevel =
        Arrays.stream(line.split(":")[1].split(",")).map(n -> Long.parseLong(n.trim())).toList();
    String operation = br.readLine().split(":")[1].split("=")[1];
    int divisible = Integer.parseInt(br.readLine().trim().split(" ")[3]);
    int monkeyTrue = Integer.parseInt(br.readLine().trim().split(" ")[5]);
    int monkeyFalse = Integer.parseInt(br.readLine().trim().split(" ")[5]);
    return new Monkey(id, worryLevel, operation, divisible, monkeyTrue, monkeyFalse);
  }

  private void play(int monkeyId, Map<Integer, Monkey> monkeys, int divideWorry, int lcm)
      throws ScriptException {
    Monkey monkey = monkeys.get(monkeyId);
    if (monkey.getWorryLevel().isEmpty()) {
      return;
    }
    for (; !monkey.getWorryLevel().isEmpty(); ) {
      Long worryLevel = monkey.getWorryLevel().remove(0);
      Long newWorryLevel =
          calc(monkey.getOperation().replaceAll("old", worryLevel.toString()), divideWorry);
      if (newWorryLevel % monkey.getDivisible() == 0) {
        monkeys.get(monkey.getMonkeyTrue()).getWorryLevel().add(newWorryLevel % lcm);
      } else {
        monkeys.get(monkey.getMonkeyFalse()).getWorryLevel().add(newWorryLevel % lcm);
      }
      monkey.incInspected();
    }
  }

  private Long calc(String expr, int divideWorry) {
    String[] split = expr.trim().split(" ");
    long a = Long.parseLong(split[0]);
    long b = Long.parseLong(split[2]);
    if ("*".equals(split[1])) {
      return a * b / divideWorry;
    } else {
      return (a + b) / divideWorry;
    }
  }
}
