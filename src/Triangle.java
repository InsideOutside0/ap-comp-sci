public class Triangle extends Polygon {
    private double[] sides;

    public Triangle(double[] sides) {
        super(3);
        this.sides = sides;
    }

    public double area() {
        double semiPerm = this.semiPerimeter();
        double quantity = semiPerm;
        for (double side : this.sides) quantity*=(semiPerm - side);
        return Math.sqrt(quantity);
    }

    public double perimeter() {
        double sum = 0;
        for (double side : this.sides) sum+=side;
        return sum;
    }

    public double semiPerimeter() {
        double sum = 0;
        for (double side : this.sides) sum+=side;
        return sum/2;
    }

    public int numberOfDiagonals() {
        return 0;
    }
}
