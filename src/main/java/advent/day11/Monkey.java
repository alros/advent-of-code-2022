package advent.day11;

import java.util.ArrayList;
import java.util.List;

public class Monkey {

  private final int id;
  private final List<Long> worryLevel;
  private final String operation;
  private final int divisible;
  private final int monkeyTrue;
  private final int monkeyFalse;
  private int inspected;

  public Monkey(
      int id,
      List<Long> worryLevel,
      String operation,
      int divisible,
      int monkeyTrue,
      int monkeyFalse) {
    this.id = id;
    this.worryLevel = new ArrayList<>(worryLevel);
    this.operation = operation;
    this.divisible = divisible;
    this.monkeyTrue = monkeyTrue;
    this.monkeyFalse = monkeyFalse;
  }

  public int getId() {
    return id;
  }

  public List<Long> getWorryLevel() {
    return worryLevel;
  }

  public String getOperation() {
    return operation;
  }

  public int getDivisible() {
    return divisible;
  }

  public int getMonkeyTrue() {
    return monkeyTrue;
  }

  public int getMonkeyFalse() {
    return monkeyFalse;
  }

  public void incInspected() {
    inspected++;
  }

  public int getInspected() {
    return inspected;
  }

  @Override
  public String toString() {
    return "Monkey [id=" + id + ", inspected=" + inspected + "]";
  }
}
