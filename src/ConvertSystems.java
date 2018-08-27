/*
Sam Stahl
intDataType
*/

import java.util.HashMap;
import java.util.Scanner;

public class ConvertSystems {

    public static void hexValuesToMap(HashMap<Integer, String> map) {
        // Fills the HashMap with Keys (10-15) and their
        // corresponding letters (a-f)
        map.put(10, "a");
        map.put(11, "b");
        map.put(12, "c");
        map.put(13, "d");
        map.put(14, "e");
        map.put(15, "f");
    }

    public static int getKeyFromValue(HashMap<Integer, String> map, String value) {
        // Iterates through each entry in the HashMap to find the right key
        for (int num : map.keySet()) {
            if (map.get(num).equals(value)) {
                return num;
            }
        }
        return -1;
    }

    public static Boolean checkValidity(String num, int base) {
        HashMap<Integer, String> map = new HashMap<>();
        hexValuesToMap(map);
        for (int i = 0; i<num.length(); i++) {
            int n; // will be the int version of the current digit
            char c = num.charAt(i);
            if (Character.isAlphabetic(c)) {
                try { n = Integer.parseInt(map.get(c)); } // check if the letter is in the map
                catch (Exception ex) { return false; }
            } else n = Integer.parseInt(String.valueOf(c));
            if (n>=base) return false;
        }
        return true;
    }

    public static String fromDecimal(int num, int base) {
        if (base > 16) return "Base too large."; // This function technically works for all bases 2-15
        String s = "";
        HashMap<Integer, String> map = new HashMap<>();
        hexValuesToMap(map);
        int temp = base; // base is used later so it should not be changed
        int placeValues = 1; // get a count of place values in a number
        while (temp <= num) { // loop until we run out of place values
            temp *= base;
            placeValues++;
        }
        int digit;
        for (int i = placeValues-1; i>=0; i--) {
            digit = num / (int) Math.pow(base, i); // get the place value
            num -= digit*Math.pow(base, i); //remove that place value from the number
            if (digit >= 10) {
                s+=map.get(digit); // for 10-15
            } else {
                s+=digit;
            }
        }
        return s;
    }

    public static int toDecimal(String s, int base) {
        int result=0;
        int exp = s.length()-1;
        HashMap<Integer, String> map = new HashMap<>();
        hexValuesToMap(map);
        for (int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c)) { // for hex values
                c=Character.toLowerCase(c); // the map does not use upper case
                result+=getKeyFromValue(map, String.valueOf(c))*Math.pow(base, exp);
            } else {
                result+=Integer.parseInt(String.valueOf(c))*Math.pow(base, exp);
            }
            exp--; // the loop increments upwards, but the exponent must decrease with each place value
        }
        return result;
    }

    public static void convert(String num, int base) {
        if (!checkValidity(num, base)) {
            System.out.println("Not a valid number for this base");
            return;
        }
        int dec;
        switch (base) {
            case 2:
                dec = toDecimal(num, 2);
                System.out.println("Octal: " + fromDecimal(dec, 8));
                System.out.println("Decimal: " + dec);
                System.out.println("Hex: " +fromDecimal(dec, 16));
                break;
            case 8:
                dec = toDecimal(num, 8);
                System.out.println("Binary: " + fromDecimal(dec, 2));
                System.out.println("Decimal: " + dec);
                System.out.println("Hex: " +fromDecimal(dec, 16));
                break;
            case 10:
                dec = Integer.parseInt(num);
                System.out.println("Binary: " + fromDecimal(dec, 2));
                System.out.println("Octal: " + fromDecimal(dec, 8));
                System.out.println("Hex: " +fromDecimal(dec, 16));
                break;
            case 16:
                dec = toDecimal(num, 16);
                System.out.println("Binary: " + fromDecimal(dec, 2));
                System.out.println("Decimal: " + dec);
                System.out.println("Octal: " + fromDecimal(dec, 8));
                break;
            default:
                System.out.println("Not a valid base.");
                break;
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        String num = sc.nextLine();
        System.out.println("What base is this?");
        System.out.println("2, 8, 10, or 16?");
        int base = sc.nextInt();
        convert(num, base);
    }

}
