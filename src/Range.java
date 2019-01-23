public class Range implements NumberGroup {

    private int[] range;

    public Range(int min, int max) {
        range = new int[max-min+1];
        for (int i=0; i<range.length; i++) {
            range[i]=min;
            min++;
        }
    }

    public boolean contains(int check) {
        for (int n : range) if (n==check) return true;
        return false;
    }

}
