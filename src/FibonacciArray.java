public class FibonacciArray {

    public static int fibonacci(int term) {
        if (term<0) return -1;
        else if (term==0) return 0;
        else if (term==1) return 1;
        return fibonacci(term-1)+fibonacci(term-2);
    }

    public static int[] fibArray(int term) {
        int[] output = new int[term];
        for (int i = 0; i<output.length; i++) {
            output[i] = fibonacci(i+1);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] array = fibArray(5);
        for (int i = 0; i<array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
