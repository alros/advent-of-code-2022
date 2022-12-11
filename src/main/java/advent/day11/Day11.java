package advent.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Day11 {

  private ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
  private ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");

  public int solve(BufferedReader br, int loops, int divideWorry)
      throws IOException, ScriptException {
    Map<Integer, Monkey> monkeys = new HashMap<>();
    int monkeyId = 0;
    for (; br.readLine() != null; monkeyId++) {
      monkeys.put(monkeyId, parseMonkey(monkeyId, br));
    }

    for (int round = 0; round < loops; round++) {
      System.out.println("\n\nloop " + round);
      for (int i = 0; i < monkeyId; i++) {
        play(i, monkeys, divideWorry);
        monkeys.values().stream()
            .sorted((a, b) -> a.getId() - b.getId())
            .forEach(System.out::println);
        System.out.println("====");
      }
    }

    List<Monkey> mostActive =
        monkeys.values().stream()
            .sorted((a, b) -> b.getInspected() - a.getInspected())
            .limit(2)
            .toList();
    return mostActive.get(0).getInspected() * mostActive.get(1).getInspected();
  }

  private Monkey parseMonkey(int id, BufferedReader br) throws IOException {
    String line = br.readLine();
    if (line.isEmpty() || line.indexOf("Monkey") == 0) {
      line = br.readLine();
    }
    List<Integer> worryLevel =
        Arrays.stream(line.split(":")[1].split(",")).map(n -> Integer.parseInt(n.trim())).toList();
    String operation = br.readLine().split(":")[1].split("=")[1];
    int divisible = Integer.parseInt(br.readLine().trim().split(" ")[3]);
    int monkeyTrue = Integer.parseInt(br.readLine().trim().split(" ")[5]);
    int monkeyFalse = Integer.parseInt(br.readLine().trim().split(" ")[5]);
    return new Monkey(id, worryLevel, operation, divisible, monkeyTrue, monkeyFalse);
  }

  private void play(int monkeyId, Map<Integer, Monkey> monkeys, int divideWorry)
      throws ScriptException {
    Monkey monkey = monkeys.get(monkeyId);
    if (monkey.getWorryLevel().isEmpty()) {
      return;
    }
    for (; !monkey.getWorryLevel().isEmpty(); ) {
      Integer worryLevel = monkey.getWorryLevel().remove(0);
      Integer newWorryLevel =
          ((Integer)
                  scriptEngine.eval(monkey.getOperation().replaceAll("old", worryLevel.toString())))
              / divideWorry;
      if (newWorryLevel % monkey.getDivisible() == 0) {
        System.out.println("throw " + newWorryLevel + " to " + monkey.getMonkeyTrue());
        monkeys.get(monkey.getMonkeyTrue()).getWorryLevel().add(newWorryLevel);
      } else {
        System.out.println("throw " + newWorryLevel + " to " + monkey.getMonkeyFalse());
        monkeys.get(monkey.getMonkeyFalse()).getWorryLevel().add(newWorryLevel);
      }
      monkey.incInspected();
    }
  }
}
