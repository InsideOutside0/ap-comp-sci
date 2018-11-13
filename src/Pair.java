public class Pair {
   private double a;
   private double b;

    public Pair (double a, double b) {
        this.a = a;
        this.b = b;
    }
    public Pair() {
        this.a = 0;
        this.b = 0;
    }
    public Pair (Pair p) {
        this.a = p.getA();
        this.b = p.getB();
    }

    public double getA() {
        return this.a;
    }
    public double getB() {
        return this.b;
    }

    public String toString() {
        return "(" + this.a + ", " + this.b + ")";
    }
}
