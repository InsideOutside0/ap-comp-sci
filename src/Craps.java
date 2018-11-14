public class Craps {
    private PairOfDice[][] pairs;

    public Craps() {
        pairs = new PairOfDice[6][6];
        for (int i = 0; i<6; i++) for (int j = 0; j<6; j++) pairs[i][j] = new PairOfDice(i+1, j+1);
    }

    public PairOfDice rollDice() { return pairs[(int)(Math.random()*6)][(int)(Math.random()*6)]; }

    public int comeOutRoll() {
        int sum = (int)(this.rollDice().getSum());
        System.out.println("You rolled a " + sum);
        if (sum == 7 || sum == 11) return 1;
        else if (sum == 2 || sum == 3 || sum ==12) return 0;
        else {
            System.out.println("Your point is " + sum + ". Roll again.");
            return sum;
        }
    }

    public void rollForPoint() {
        int roll = this.comeOutRoll();
        if (roll == 1) System.out.println("Congratulations! YOU WON!!");
        else if (roll == 0) System.out.println("Bummer. YOU LOST!!");
        else {
            int reroll = (int)this.rollDice().getSum();
            System.out.println("New roll is a " + reroll + ".");
            while (reroll !=7 && reroll != roll) {
                reroll = (int)this.rollDice().getSum();
                System.out.println("New roll is a " + reroll + ".");
            }
            if (reroll == roll) System.out.println("Congratulations! YOU WON!!");
            else System.out.println("Bummer. YOU LOST!!");
        }
    }

    public void playRound() {
        this.rollForPoint();
    }

    public static void main(String[] args) {
        Craps c = new Craps();
        c.playRound();
    }
}
