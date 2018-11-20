public class RegularPolygon extends Polygon {
    public double sideLength;
    public double angle;
    public double apothem;

    public RegularPolygon(int sides, double sideLength) {
        super(sides);
        this.sideLength = sideLength;
        this.angle = Math.toRadians(180*(sides-2));
        this.apothem = (sideLength/2)*Math.tan(this.angle/2);
    }

    public double area() {
        return 0.5*this.perimeter()*this.apothem;
    }

    public double perimeter() {
        return this.sideLength*this.getSides();
    }

    public int numberOfDiagonals() {
        if (this.getSides()<4) return 0;
        int sum = 0;
        int counter = 2;
        for (int i = 4; i<=this.getSides(); i++) {
            sum+=counter;
            counter++;
        }
        return sum;
    }

}
