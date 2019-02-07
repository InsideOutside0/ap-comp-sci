public class NumberSystemsRecursive {

    public static String decimalToBinary(int decimal) {
        if (decimal==0) return "";
        return decimalToBinary(decimal/2) + Integer.toString(decimal%2);
    }

    public static String decimalToOctal(int decimal) {
        if (decimal==0) return "";
        return decimalToOctal(decimal/8) + Integer.toString(decimal%8);
    }

    public static int decimalToBinaryI(int decimal, int exp) {
        if (decimal==0) return 0;
        return (decimal%2)*(int)(Math.pow(10,exp)) + decimalToBinaryI(decimal/2, exp+1);
    }

    public static int decimalToOctalI(int decimal, int exp)  {
        if (decimal==0) return 0;
        return (decimal%8)*(int)(Math.pow(10,exp)) + decimalToOctalI(decimal/8, exp+1);
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(105));
        System.out.println(decimalToOctal(105));
        System.out.println(decimalToBinaryI(105, 0));
        System.out.println(decimalToOctalI(105, 0));
    }

}