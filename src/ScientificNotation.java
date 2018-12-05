import java.util.ArrayList;
public class ScientificNotation {

    private ArrayList<String> digits = new ArrayList<String>();
    private int exponent;

    public ScientificNotation(double num) {
        //initializes digits ArrayList to list all the digits in num, excluding the decimal point
        String numString = Double.toString(num); //converts a double into a String
        for(int k = 0; k < numString.length(); k++) {
            digits.add(numString.substring(k, k+1));
        }
        digits.remove(digits.indexOf("."));
        this.exponent = getExp(numString);
    }

    public static boolean hasDecimal (String n) {
        if (n.substring(n.length()-1).equals(".")) return true;
        for (int i = 0; i<n.length(); i++) if (n.substring(i, i+1).equals(".")) return true;
        return false;
    }

    public static int getExp(String n) {
        if (!hasDecimal(n)) return n.length()-1;

        else if (n.substring(1, 2).equals(".")) {
            for (int i = 0; i<n.length(); i++)
                if (!n.substring(i, i+1).equals(".") && !n.substring(i, i+1).equals("0") && i<n.length()-1) return (i-1)*-1;
        } else {
            for (int i = 0; i < n.length(); i++)
                if (n.substring(i, i + 1).equals(".")) return i - 1;
        }
        return 0;
    }

    public ArrayList<String> getDigits() {
        return digits;
    }

    public String toSciNot(int sigFigs) {
        if (sigFigs<=0) throw new IllegalArgumentException("sigfigs must be larger than 0");
        String output = digits.remove(0);
        if (!output.equals("0")) sigFigs--;
        if (sigFigs>0) {
            output+=".";
            while (sigFigs > 0 && digits.size() > 0) {
                output += digits.remove(0);
                sigFigs--;
            }
            if (sigFigs > 0) for (int i = 0; i < sigFigs; i++) output += "0";
        }
        if (this.exponent != 0) output+=" x 10";
        if (this.exponent != 1 && this.exponent !=-1 && this.exponent !=0) output+="^" + this.exponent;
        return output;
    }

    public static void main (String[] args) {
        ScientificNotation s = new ScientificNotation(0.023);
        System.out.println(s.toSciNot(3));
    }
}