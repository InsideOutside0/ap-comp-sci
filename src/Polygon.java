public abstract class Polygon {
    private int numSides;

    public Polygon(int sides) {
        numSides = sides;
    }

    public int getSides() {
        return numSides;
    }

    public int sumOfAngles() {
        return (numSides - 2)*180;
    }

    public abstract double area();

    public abstract double perimeter();

    public abstract int numberOfDiagonals();
}
