/*
Sam Stahl
AP Computer Science
Change Giver/Maker
 */

public class ChangeMaker {

    public static String singularize(String s) {
        StringBuilder sb = new StringBuilder(s);
        int length = sb.length();
        sb = sb.deleteCharAt(length-3);
        s = sb.toString();
        return s;
    }

    public static String makeChange(double price, double payment) {
        if (payment<price) return "Pay the full price, please.";
        else if (payment==price) return "Exact change! Thank you very much!";
        else {
            int centPrice = (int)(price*100);
            int centPayment = (int)(payment*100);
            int difference = centPayment - centPrice;
            int[] values = {10000, 5000, 2000, 1000, 500, 100, 50, 25, 10, 5, 1};
            String[] types = {" $100 bills, ", " $50 bills, ", " $20 bills, ", " $10 bills, ", " $5 bills, ", " $1 bills, ",
                                " half dollars, ", " quarters, ", " dimes, ", " nickels, ", " one cent coins. "};
            String result = "Your change is: ";
            for (int i=0; i<values.length; i++) {
                if (difference>=values[i]) {
                    int change = difference/values[i];
                    difference-=change*values[i];
                    String input = types[i];
                    if (change==1 ) input = singularize(input);
                    result+=change+input;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(makeChange(20.00, 25.14));
    }
}
