public class Trapezoid extends Polygon {
    private double[] bases;
    private double[] verticals;
    private double angle; // in radians, bottom left angle

    public Trapezoid(double[] bases, double[] verticals, double angle) {
        super(4);
        this.bases = bases;
        this.verticals = verticals;
        this.angle = angle;
    }

    public double area() {
        return ((bases[0]+bases[1])/2)*(verticals[0]*Math.sin(angle));
    }
    public double perimeter() {
        return bases[0] + bases[1] + verticals[0] + verticals[1];
    }

    public int numberOfDiagonals() {
        return 2;
    }
}
