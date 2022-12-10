package advent.day10;

public class Instruction {

  private final int param;
  private int cyclesToComplete;

  public Instruction(InstructionType type, int param) {
    this.param = param;
    this.cyclesToComplete = type.getDuration();
  }

  public int tick() {
    if (cyclesToComplete > 0) {
      cyclesToComplete--;
      return cyclesToComplete == 0 ? param : 0;
    } else {
      return 0;
    }
  }

  public boolean isIncomplete() {
    return cyclesToComplete > 0;
  }
}
