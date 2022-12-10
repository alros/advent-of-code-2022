package advent.day10;

public enum InstructionType {
  noop(1),
  addx(2);

  private int duration;

  InstructionType(int duration) {
    this.duration = duration;
  }

  public int getDuration() {
    return duration;
  }
}
