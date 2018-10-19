/*
Sam Stahl
AP Computer Science
ArrayStatistics
 */
public class ArrayStats {

    public static int arrMin(int[] arr) {
        int current = Integer.MAX_VALUE;
        for (int i = 0; i<arr.length; i++) if (arr[i] < current) current = arr[i];
        return current;
    }

    public static int arrMax(int[] arr) {
        int current = Integer.MIN_VALUE;
        for (int i = 0; i<arr.length; i++) if (arr[i] > current) current = arr[i];
        return current;
    }

    public static double average(int[] arr) {
        double sum = 0;
        for (int i = 0; i<arr.length; i++)  sum+=arr[i];
        return sum/arr.length;
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i<arr.length; i++) sum+=arr[i];
        return sum;
    }

    public static int getIndexByValue(int value, int[] arr) {
        for (int i = 0; i<arr.length; i++) if (arr[i] == value) return i;
        return -1;
    }

    public static int[] ascendingOrder(int[] arr) {
        int copy[] = new int[arr.length];
        for (int i = 0; i<arr.length; i++) copy[i] = arr[i];
        int[] newArr = new int[copy.length];
        for (int i = 0; i<copy.length; i++) {
            newArr[i] = arrMin(copy);
            copy[getIndexByValue(newArr[i], copy)] = Integer.MAX_VALUE;
        }
        return newArr;
    }

    public static int[] descendingOrder(int[] arr) {
        int copy[] = new int[arr.length];
        for (int i = 0; i<arr.length; i++) copy[i] = arr[i];
        int[] newArr = new int[arr.length];
        for (int i = 0; i<copy.length; i++) {
            newArr[i] = arrMax(copy);
            copy[getIndexByValue(newArr[i], copy)] = Integer.MIN_VALUE;
        }
        return newArr;
    }

    public static double median(int[] arr) {
        double median;
        int[] newArr = ascendingOrder(arr);
        if (newArr.length % 2 == 0) median = (newArr[newArr.length / 2] + newArr[newArr.length / 2 - 1]) / 2;
        else median = newArr[newArr.length / 2];
        return median;
    }

    public static void main (String[] args) {
        int[] test = {6, 3, 2, 89, 56, 987};
        System.out.println(average(test));
        System.out.println(sum(test));
        System.out.println(median(test));
        System.out.println();
        int [] test2 = ascendingOrder(test);
        int[] test3 = descendingOrder(test);
        for (int i = 0; i<test.length; i++) System.out.println(test2[i]);
        System.out.println();
        for (int i = 0; i<test.length; i++) System.out.println(test3[i]);
    }

}
