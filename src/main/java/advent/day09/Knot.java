package advent.day09;

public class Knot {
  private Point point;
  private Knot next;

  public Knot(Point point) {
    this(point, null);
  }

  public Knot(Point point, Knot next) {
    this.point = point;
    this.next = next;
  }

  public Knot next() {
    return next;
  }

  public Point getPoint() {
    return point;
  }

  public void setPoint(Point point) {
    this.point = point;
  }

  @Override
  public String toString() {
    return "Knot [point=" + point + "]";
  }
}
