package advent.day14;

import static java.lang.Integer.parseInt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Day14 {

  private Point SAND_SOURCE = new Point(500, 0);

  private int EMPTY = 0;
  private int ROCK = 1;
  private int SAND = 2;

  public int solveStep1(BufferedReader br) throws IOException {
    return solve(br, false);
  }

  public int solveStep2(BufferedReader br) throws IOException {
    return solve(br, true);
  }

  private int solve(BufferedReader br, boolean endless) throws IOException {
    int[][] map = parse(br, endless);
    createView(map);
    return simulate(map, true);
  }

  private int[][] parse(BufferedReader br, boolean endless) throws IOException {
    List<List<Point>> lines = new ArrayList<>();
    for (String line = br.readLine(); line != null; line = br.readLine()) {
      lines.add(
          Arrays.stream(line.split(" -> "))
              .map(
                  s -> {
                    String[] sp = s.split(",");
                    return new Point(parseInt(sp[0]), parseInt(sp[1]));
                  })
              .toList());
    }
    int maxX =
        lines.stream()
                .flatMap(l -> l.stream())
                .sorted((a, b) -> b.x() - a.x())
                .findFirst()
                .get()
                .x()
            + 1;
    int maxY =
        lines.stream()
                .flatMap(l -> l.stream())
                .sorted((a, b) -> b.y() - a.y())
                .findFirst()
                .get()
                .y()
            + 1;
    int[][] map = new int[maxY + (endless ? 2 : 0)][maxX * (endless ? 2 : 1)];
    lines.forEach(
        l -> {
          Point start = l.get(0);
          map[start.y()][start.x()] = ROCK;
          for (int i = 1; i < l.size(); i++) {
            Point next = l.get(i);
            map[next.y()][next.x()] = ROCK;
            for (int x = (start.x() < next.x() ? start : next).x();
                x < (start.x() < next.x() ? next : start).x();
                x++) {
              map[start.y()][x] = ROCK;
            }
            for (int y = (start.y() < next.y() ? start : next).y();
                y < (start.y() < next.y() ? next : start).y();
                y++) {
              map[y][start.x()] = ROCK;
            }
            start = next;
          }
        });
    if (endless) {
      for (int x = 0; x < map[0].length; x++) {
        map[map.length - 1][x] = ROCK;
      }
    }
    return map;
  }

  private int simulate(int[][] map, boolean endless) {
    int units = 0;
    boolean fellOut = false;
    long cycle = 0;
    while (!fellOut) {
      Point unit = SAND_SOURCE;
      boolean atRest = false;
      while (!atRest) {
        cycle++;
        Point next = new Point(unit.x(), unit.y() + 1);
        if (next.y() >= map.length) {
          return units;
        }
        if (isEmpty(map, next)) {
          move(map, unit, next, cycle);
          unit = next;
          continue;
        }
        next = new Point(unit.x() - 1, unit.y() + 1);
        if (next.x() < 0) {
          return units;
        }
        if (isEmpty(map, next)) {
          move(map, unit, next, cycle);
          unit = next;
          continue;
        }
        next = new Point(unit.x() + 1, unit.y() + 1);
        if (next.x() >= map[0].length) {
          return units;
        }
        if (isEmpty(map, next)) {
          move(map, unit, next, cycle);
          unit = next;
          continue;
        }
        atRest = true;
        units++;
        if (unit.equals(SAND_SOURCE)) {
          return units;
        }
      }
    }

    return units;
  }

  private void move(int[][] map, Point unit, Point next, long update) {
    clean(map, unit);
    place(map, next);
    if (displayMode && update % 2000 == 0) {
      pause(PAUSE);
    }
  }

  private boolean isEmpty(int[][] map, Point next) {
    return map[next.y()][next.x()] == EMPTY;
  }

  private void place(int[][] map, Point unit) {
    map[unit.y()][unit.x()] = SAND;
  }

  private void clean(int[][] map, Point unit) {
    map[unit.y()][unit.x()] = EMPTY;
  }

  public record Point(int x, int y) {}

  private boolean displayMode;
  private int PIXEL = 3;
  private int PAUSE = 0;
  private JPanel panel;

  public Day14() {
    this(false);
  }

  public Day14(boolean displayMode) {
    this.displayMode = displayMode;
  }

  private void createView(int[][] map) {
    if (!displayMode) {
      return;
    }
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(map[0].length * PIXEL, map.length * PIXEL);
    frame.setLocationRelativeTo(null);
    panel =
        new JPanel() {
          private static final long serialVersionUID = 1L;

          @Override
          public void paint(Graphics g) {
            Graphics2D graphic2d = (Graphics2D) g;

            for (int y = 0; y < map.length; y++) {
              for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] == ROCK) {
                  graphic2d.setColor(Color.BLUE);
                } else if (map[y][x] == EMPTY) {
                  graphic2d.setColor(Color.BLACK);
                } else {
                  graphic2d.setColor(Color.YELLOW);
                }
                graphic2d.fillRect(x * PIXEL, y * PIXEL, PIXEL, PIXEL);
              }
            }
          }
        };
    frame.add(panel);
    frame.setVisible(true);
  }

  private void pause(int d) {
    if (displayMode) {
      panel.paint(panel.getGraphics());
      if (d > 0)
        try {
          Thread.sleep(d);
        } catch (InterruptedException e) {
        }
    }
  }
}
