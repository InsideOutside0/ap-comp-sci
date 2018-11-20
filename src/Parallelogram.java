public class Parallelogram extends Polygon {
    private double base;
    private double diagonalSide;
    private double acuteAngle; // in radians, can also be a right angle

    public Parallelogram(double base, double diagonalSide, double acuteAngle) {
        super(4);
        this.base = base;
        this.diagonalSide = diagonalSide;
        this.acuteAngle = acuteAngle;
    }

    public double area() {
        return base*diagonalSide*Math.sin(acuteAngle);
    }

    public double perimeter() {
        return (2*base) + (2*diagonalSide);
    }

    public int numberOfDiagonals() {
        return 2;
    }
}
