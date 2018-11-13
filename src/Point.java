public class Point extends Pair {

    public Point () {
        super();
    }
    public Point (double x, double y) {
        super(x, y);
    }
    public Point (Pair p) {
        super(p.getA(), p.getB());
    }
    public Point (Point p) {
        super(p.getA(), p.getB());
    }

    public double getX() {
        return this.getA();
    }
    public double getY() {
        return this.getB();
    }

    public static double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
    }

    public static void main(String[] args) {
        Point p = new Point(2, 3);
        System.out.println(p);
    }
}
