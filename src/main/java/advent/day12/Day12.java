package advent.day12;

import com.google.common.collect.Streams;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Day12 {

  private static final int[][] movements = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

  public int solveStep1(BufferedReader br) throws IOException {
    List<String> map = parseMap(br);
    int[] start = locatePosition(map, "S").get(0);
    Set<Point> explored = new HashSet<>();
    // this stuff is just for the visualisation: skipped for displayMode=false
    createView(map.size(), map.get(0).length(), map, explored);
    int result = explore(map, start, explored);
    // the pause is just for the visualisation: skipped for displayMode=false
    pause(10_000);
    return result;
  }

  public int solveStep2(BufferedReader br) throws IOException {
    List<String> map = parseMap(br);
    return locatePosition(map, "a").stream()
        .map(start -> explore(map, start, new HashSet<>()))
        .sorted()
        .findFirst()
        .get();
  }

  public record Point(int y, int x) {}

  private int explore(List<String> map, int[] start, Set<Point> explored) {
    int loop = 0;
    Set<Point> toExplore = new HashSet<>(List.of(new Point(start[0], start[1])));
    boolean found = false;
    while (!found && toExplore.size() > 0) {
      // the pause is just for the visualisation: skipped for displayMode=false
      pause(100);
      loop++;
      Set<Point> toExploreNext = new HashSet<>();
      for (Point point : toExplore) {
        explored.add(point);
        for (int[] step : movements) {
          Point next = new Point(point.y() + step[0], point.x() + step[1]);
          if (canMove(map, point, next) && !explored.contains(next)) {
            if (charAt(map, next) == 'E') {
              return loop;
            }
            toExploreNext.add(next);
          }
        }
      }
      toExplore = toExploreNext;
    }
    return -1;
  }

  private char charAt(List<String> map, Point p) {
    return map.get(p.y).charAt(p.x());
  }

  public List<String> parseMap(BufferedReader br) throws IOException {
    List<String> map = new ArrayList<>();
    for (String line = br.readLine(); line != null; line = br.readLine()) {
      map.add(line);
    }
    return map;
  }

  public List<int[]> locatePosition(List<String> map, String mark) {
    return Streams.mapWithIndex(
            map.stream(), (string, y) -> new int[] {(int) y, string.indexOf(mark)})
        .filter(pair -> pair[1] >= 0)
        .toList();
  }

  public boolean canMove(List<String> map, Point start, Point next) {
    if (next.x() < 0
        || next.y() < 0
        || map.size() <= next.y()
        || map.get(next.y()).length() <= next.x()) {
      return false;
    }
    char s = map.get(start.y()).charAt(start.x());
    char e = map.get(next.y()).charAt(next.x());
    if (s == 'S') {
      s = 'a';
    }
    if (e == 'E') {
      e = 'z';
    }
    return e - s <= 1;
  }

  // quick&dirty stuff for the visualisation

  boolean displayMode;
  private static int PIXEL = 10;
  private JPanel panel;
  private static final Map<Character, Integer> colorMap = new HashMap<>();

  static {
    int r = 0x0;
    int g = 0xff;
    int b = 0x0;
    for (char c = 'a'; c <= 'z'; c++) {
      colorMap.put(c, r * 256 * 256 + g * 256 + b);
      r += 9;
      g -= 9;
    }
  }

  public Day12() {
    this(false);
  }

  public Day12(boolean displayMode) {
    this.displayMode = displayMode;
  }

  private void createView(int h, int w, List<String> map, Set<Point> explored) {
    if (!displayMode) {
      return;
    }
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(w * PIXEL, h * PIXEL);
    frame.setLocationRelativeTo(null);
    panel =
        new JPanel() {
          private static final long serialVersionUID = 1L;

          @Override
          public void paint(Graphics g) {
            Graphics2D graphic2d = (Graphics2D) g;

            for (int y = 0; y < map.size(); y++) {
              String line = map.get(y);
              for (int x = 0; x < line.length(); x++) {
                Point p = new Point(y, x);
                Integer rgb = colorMap.get(charAt(map, p));
                if (rgb == null) {
                  rgb = 0;
                }
                graphic2d.setColor(explored.contains(p) ? new Color(rgb) : Color.WHITE);
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
      try {
        Thread.sleep(d);
      } catch (InterruptedException e) {
      }
    }
  }
}
