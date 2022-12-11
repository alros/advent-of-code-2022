package advent.day11;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Monkey {

  private final List<Long> worryLevel;
  private final String operation;
  private final int divisible;
  private final int monkeyTrue;
  private final int monkeyFalse;
  private int inspected;

  public void incInspected() {
    inspected++;
  }
}
