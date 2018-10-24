public class MegaMillions {
    int[] comboPool = new int[70];
    int[] megaPool = new int[25];
    int[] ticket = new int[6];
    int[] winningNumbers = new int[6];

    public void fillArrays() {
        for (int i = 0; i<70; i++) comboPool[i] = i+1;
        for (int i = 0; i<25; i++) megaPool[i] = i+1;
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

    public static int arrMin(int[] arr) {
        int current = Integer.MAX_VALUE;
        for (int i = 0; i<arr.length; i++) if (arr[i] < current) current = arr[i];
        return current;
    }

    public int[] winningNumbers() {
        int[] output = new int[6];
        for (int i = 0; i<5; i++) {
            boolean neverUsed = false;
            while (!neverUsed) { // Check for identical numbers
                neverUsed = true;
                int rand = (int) (Math.random() * 70);
                for (int j = 0; j<i; j++) {
                    if (rand == output[j]) {
                        rand = (int) (Math.random() * 70);
                        neverUsed = false;
                    }
                }
                output[i] = comboPool[rand];
            }
        }
        output[5] = megaPool[(int)(Math.random()*25)];
        return output;
    }

    public MegaMillions(int[] ticket) {
        fillArrays();
        winningNumbers = winningNumbers();
        int[] newTicket = new int[5];
        for (int i = 0; i<5; i++) newTicket[i] = ticket[i];
        int[] ascTicket = ascendingOrder(newTicket);
        for (int i = 0; i<5; i++) this.ticket[i] = ascTicket[i];
        this.ticket[5] = ticket[5];
    }

    public int[] matchingNumbers() {
        int count = 0;
        boolean[] correct = new boolean[6];
        for (int i = 0; i<5; i++) correct[i] = false;
        for (int i = 0; i<5; i++) {
            for (int j = 0; j<5; j++) {
                if (ticket[i] == winningNumbers[j]) {
                    count++;
                    correct[i] = true;
                }
            }
        }
        if (this.ticket[5] == this.winningNumbers[5]) {
            count++;
            correct[5] = true;
        }
        int[] output = new int[count];
        int current = 0;
        for (int i=0; i<5; i++) {
            if (correct[i]) {
                output[current] = ticket[i];
                current++;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[] ticket = {2, 69, 23, 52, 4, 19};
        MegaMillions m = new MegaMillions(ticket);
        System.out.print("Ticket: ");
        for (int i = 0; i<6; i++) System.out.print(m.ticket[i] + " ");
        System.out.println();
        int[] matchingNums = m.matchingNumbers();
        System.out.print("Winning: ");
        for (int i = 0; i<6; i++) System.out.print(m.winningNumbers[i] + " ");
        System.out.println();
        System.out.print("Matching: ");
        for (int i = 0; i<matchingNums.length; i++) System.out.print(matchingNums[i] + " ");
    }
}
