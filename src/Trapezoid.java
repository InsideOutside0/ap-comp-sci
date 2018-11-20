public class Trapezoid extends Polygon {
    private double[] bases;
    private double[] verticals;
    private double[] angles; // in radians, [0] is the left acute, [1] is the right one

    public Trapezoid(double[] bases, double[] verticals, double[] angles) {
        super(4);
        this.bases = bases;
        this.verticals = verticals;
        this.angles = angles;
    }

    public double area() {
        return ((bases[0]+bases[1])/2)*(verticals[0]*Math.sin(angles[0]));
    }
    public double perimeter() {
        return bases[0] + bases[1] + verticals[0] + verticals[1];
    }

    public int numberOfDiagonals() {
        return 2;
    }
}
