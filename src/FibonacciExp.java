/*
Sam Stahl
AP Computer Science
Fibonacci and Exponents
*/

import java.util.Scanner;

public class FibonacciExp {

    public static int fibonacci(int term) {
        // The function is mathematically recursive
        // It would be a shame if I didn't use recursion
        if (term<0) return -1;
        else if (term==0) return 0;
        else if (term==1) return 1;
        return fibonacci(term-1)+fibonacci(term-2);
    }

    public static void printFibonacci(int terms) {
        System.out.println();
        if (terms<1) System.out.println(fibonacci(terms));
        else {
            for (int i=1; i<=terms; i++) {
                System.out.println(fibonacci(i));
            }
        }
    }

    public static double exp(int base, int power) {
        if (base==0) return 0; //the function cannot return undefined if power=0 though
        else if (power==0) return 1;
        double total = base;
        boolean isNeg = false;
        if (power<0) {
            isNeg = true;
            power*=-1;
        }
        for (int i=1; i<power; i++) {
            total*=base;
        }
        if (isNeg) total=1/total;
        return total;
    }

    public static void printExp(int base, int power) {
        System.out.println();
        if (power<0) {
            System.out.println(exp(base, power));
        } else {
            for (int i = 0; i<=power; i++) {
                System.out.println(exp(base, i));
            }
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a term number in the fibonacci sequence");
        int term = sc.nextInt();
        System.out.println("Enter a number as the base of an exponent");
        int base = sc.nextInt();
        System.out.println("Enter a number as the exponent");
        int power = sc.nextInt();
        printFibonacci(term);
        printExp(base, power);
    }
}
