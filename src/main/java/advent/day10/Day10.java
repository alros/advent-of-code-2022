package advent.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Day10 {

  public long solve(BufferedReader br, PrintStream out) throws IOException {
    return getInterestingCycles(br, out).stream().reduce((a, b) -> a + b).get();
  }

  public List<Integer> getInterestingCycles(BufferedReader bufReader, PrintStream out)
      throws IOException {
    List<Integer> calculateX = calculateX(bufReader, out);
    List<Integer> interesting = new ArrayList<>();
    for (int i = 20; i < calculateX.size(); i += 40) {
      interesting.add(calculateX.get(i - 1) * i);
    }
    return interesting;
  }

  public List<Integer> calculateX(BufferedReader bufReader, PrintStream out) throws IOException {
    List<Instruction> instructions = new ArrayList<>();
    List<Integer> valuesOfX = new ArrayList<>(List.of(1));
    int cycle = 0;
    int x = 1;
    for (String line = bufReader.readLine(); line != null; line = bufReader.readLine()) {
      String[] split = line.split(" ");
      cycle++;
      instructions.add(
          new Instruction(
              InstructionType.valueOf(split[0]),
              split.length > 1 ? Integer.parseInt(split[1]) : 0));
      x = loop(instructions, valuesOfX, x, cycle, out);
    }
    while (instructions.stream().filter(i -> i.isIncomplete()).findAny().isPresent()) {
      cycle++;
      x = loop(instructions, valuesOfX, x, cycle, out);
    }
    return valuesOfX;
  }

  private int loop(
      List<Instruction> instructions, List<Integer> valuesOfX, int x, int cycle, PrintStream out) {
    boolean lit = (((cycle - 1) % 40) >= x - 1) && (((cycle - 1) % 40) <= x + 1);
    out.print(lit ? "#" : ".");
    if (cycle % 40 == 0) {
      out.print("\n");
    }
    x += instructions.get(0).tick();
    valuesOfX.add(x);
    instructions.removeIf(i -> !i.isIncomplete());
    return x;
  }
}
