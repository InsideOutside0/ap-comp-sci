public class PolygonTester {

    public static double radians(double d) {
        return Math.toRadians(d);
    }

    public static void testTrapezoid() {
        double[] bases = {2, 10};
        double[] verticals = {3, 7};
        Trapezoid tr = new Trapezoid(bases, verticals, radians(60));
        System.out.println("TRAPEZOID");
        System.out.println("Sides: " + tr.getSides());
        System.out.println("Area: " + tr.area());
        System.out.println("Perimeter: " + tr.perimeter());
        System.out.println("Diagonals: " + tr.numberOfDiagonals());
        System.out.println();
    }

    public static void testTriangle() {
        double[] sides = {4, 10, 7};
        Triangle tr = new Triangle(sides);
        System.out.println("TRIANGLE");
        System.out.println("Sides: " + tr.getSides());
        System.out.println("Area: " + tr.area());
        System.out.println("Perimeter: " + tr.perimeter());
        System.out.println("Diagonals: " + tr.numberOfDiagonals());
        System.out.println();
    }

    public static void testParallelogram() {
        Parallelogram p = new Parallelogram(2, 5, radians(60));
        System.out.println("PARALLELOGRAM");
        System.out.println("Sides: " + p.getSides());
        System.out.println("Area: " + p.area());
        System.out.println("Perimeter: " + p.perimeter());
        System.out.println("Diagonals: " + p.numberOfDiagonals());
        System.out.println();
    }

    public static void testRegularPolygon(int numSides) {
        RegularPolygon p = new RegularPolygon(numSides, 5);
        System.out.println("REGULAR POLYGON");
        System.out.println("Sides: " + p.getSides());
        System.out.println("Area: " + p.area());
        System.out.println("Perimeter: " + p.perimeter());
        System.out.println("Diagonals: " + p.numberOfDiagonals());
        System.out.println();
    }

    public static void main(String args[]) {
        testTrapezoid();
        testTriangle();
        testParallelogram();
        testRegularPolygon(6);
    }

}
