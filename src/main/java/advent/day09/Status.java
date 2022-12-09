package advent.day09;

import java.util.Set;

public record Status(Knot head, Set<Point> visited) {

  public Knot tail() {
    Knot p = head;
    while (p.next() != null) {
      p = p.next();
    }
    return p;
  }
}
