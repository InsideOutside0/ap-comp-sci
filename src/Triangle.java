public class Triangle extends Polygon {
    private double[] sides;
    private double[] angles; // in radians

    public Triangle(double[] sides, double[] angles) {
        super(3);
        for (int i = 0; i<3; i++) this.sides[i] = sides[i];
        for (int i = 0; i<3; i++) this.angles[i] = angles[i];
        // sides[i] is opposite of angles[i]
    }

    public double area() {
        return 0.5*sides[0]*sides[1]*Math.sin(angles[2]);
    }

    public double perimeter() {
        double sum = 0;
        for (double side : sides) sum+=side;
        return sum;
    }

    public int numberOfDiagonals() {
        return 0;
    }
}
