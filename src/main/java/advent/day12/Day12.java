package advent.day12;

import com.google.common.collect.Streams;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day12 {

  private static final int[][] movements = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

  public int solveStep1(BufferedReader br) throws IOException {
    List<String> map = parseMap(br);
    int[] start = locatePosition(map, "S").get(0);
    return explore(map, start);
  }

  public int solveStep2(BufferedReader br) throws IOException {
    List<String> map = parseMap(br);
    return locatePosition(map, "a").stream()
        .map(start -> explore(map, start))
        .sorted()
        .findFirst()
        .get();
  }

  public record Point(int y, int x) {}

  private int explore(List<String> map, int[] start) {
    int loop = 0;
    Set<Point> toExplore = new HashSet<>(List.of(new Point(start[0], start[1])));
    Set<Point> explored = new HashSet<>();
    boolean found = false;
    while (!found && toExplore.size() > 0) {
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
}
