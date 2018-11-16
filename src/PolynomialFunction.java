public class PolynomialFunction {
    private double[] coefficientArray;
    private int[] expArray;
    private double constant;
    private boolean knownC = true;

    public PolynomialFunction(double[] coefs, double c) {
        this.constant = c;
        this.coefficientArray = new double[coefs.length];
        this.expArray = new int[coefs.length];
        for (int i = 0; i<coefs.length; i++) {
            this.coefficientArray[i] = coefs[i];
            this.expArray[i] = this.expArray.length - i;
        }
    }

    public PolynomialFunction(double[] coefs) {
        this.knownC = false;
        this.coefficientArray = new double[coefs.length];
        this.expArray = new int[coefs.length];
        for (int i = 0; i<coefs.length; i++) {
            this.coefficientArray[i] = coefs[i];
            this.expArray[i] = this.expArray.length - i;
        }
    }

    public static String handleSign(double n, boolean rev) {
        if (n==0) return "";
        else if ((n>0 && !rev) || (n<0 && rev)) return "+ " + Double.toString(n);
        else return "- " + Double.toString(n*-1);
    }

    public static String handleExp(int n) {
        if (n==1) return "";
        else return "^" + Integer.toString(n);
    }

    public static String handleConstant(double n, boolean c) {
        if (!c) return "+ C"; // don't forget the cheese
        else if (n==0) return "";
        else return handleSign(n, false);
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < this.coefficientArray.length; i++) {
            if (i==0) output += this.coefficientArray[i] + "x" + handleExp(this.expArray[i]) + " ";
            else output += handleSign(this.coefficientArray[i], false) + "x" + handleExp(this.expArray[i]) + " ";
        }
        output += handleConstant(this.constant, this.knownC);
        return output;
    }

    public double evaluate(double x) {
        double o = 0;
        for (int i = 0; i<this.coefficientArray.length; i++) o += this.coefficientArray[i]*Math.pow(x, expArray[i]);
        o += this.constant;
        return o;
    }

    public PolynomialFunction findDerivative() {
        double[] c = new double[this.coefficientArray.length - 1];
        double constant =  this.coefficientArray[coefficientArray.length-1];
        for (int i = 0; i<c.length; i++) c[i] = this.coefficientArray[i] * this.expArray[i];
        return new PolynomialFunction(c, constant);
    }

    public PolynomialFunction findIntegral() {
        double[] c = new double[this.coefficientArray.length + 1];
        for (int i = 0; i<this.coefficientArray.length; i++) c[i] = this.coefficientArray[i] / (this.expArray[i] + 1);
        c[c.length-1] = this.constant;
        return new PolynomialFunction(c);
    }

    public static void main(String args[]) {
        double[] coefs = {2, -3, 4};
        PolynomialFunction f = new PolynomialFunction(coefs, 2);
        System.out.println(f);
        System.out.println(f.evaluate(4));
        System.out.println(f.findIntegral());
        System.out.println(f.findDerivative());
        System.out.println(f.findDerivative().findIntegral());
    }

}
