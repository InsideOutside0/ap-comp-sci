public class Circle {
    private Point center;
    private double radius;

    public Circle() {
        this.center = new Point();
        this.radius = 1;
    }
    public Circle(Point p, double r) {
        this.center = new Point(p);
        this.radius = r;
    }
    public Circle(double h, double k, double r) {
        this.center = new Point(h, k);
        this.radius = r;
    }
    public Circle(Point p) {
        this.center = new Point(p);
        this.radius = 1;
    }
    public Circle(double h, double k) {
        this.center = new Point(h, k);
        this.radius = 1;
    }
    public Circle(double r) {
        this.center = new Point();
        this.radius = r;
    }

    public String toString() {
        String xVal;
        String yVal;
        if (this.center.getX() > 0) xVal = "(x - " + this.center.getX() + ")^2";
        else if (this.center.getX() < 0) xVal = "(x + " + this.center.getX()*-1 + ")^2";
        else xVal = "x^2";
        if (this.center.getY() > 0) yVal = "(y - " + this.center.getY() + ")^2";
        else if (this.center.getY() < 0) yVal = "(y + " + this.center.getY()*-1 + ")^2";
        else yVal = "y^2";
        return xVal + " + " + yVal + " = " + Math.pow(this.radius, 2);
    }

    public double circumference() {
        return 2*this.radius*Math.PI;
    }
    public double area() {
        return Math.PI*Math.pow(this.radius, 2);
    }

    public static void main(String[] args) {
        Circle c = new Circle();
        System.out.println(c);
    }

}
