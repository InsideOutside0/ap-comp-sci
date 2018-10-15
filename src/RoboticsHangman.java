import java.util.Scanner;
import java.util.Random;

public class RoboticsHangman {

    public static String generateWord(String[] words) {
        Random r = new Random();
        int randInt = r.nextInt(words.length);
        return words[randInt];
    }

    public static void hangman(String word) {
        int deathCount = 10;
        boolean[] bools = new boolean[word.length()];
        for (int i = 0; i<word.length(); i++) {
            bools[i] = false;
        }
        String wordNew = word.toLowerCase();
        Scanner sc = new Scanner(System.in);
        int numGuessed = 0;
        while(numGuessed!=word.length() && deathCount>0) {
            int numGuessedInitial = numGuessed;
            for (int i = 0; i<word.length(); i++) {
                if (!bools[i]) System.out.print(" _ ");
                else System.out.print(word.charAt(i));
            }
            System.out.println();
            System.out.println("Guesses left: " + deathCount);
            System.out.println("Guess a letter you commie");
            char ch = sc.nextLine().toLowerCase().charAt(0);
            for (int i = 0; i<word.length(); i++) {
                if (ch == wordNew.charAt(i)) {
                    bools[i] = true;
                    numGuessed++;
                }
            }
            if (numGuessedInitial==numGuessed) {
                System.out.println("WRONG");
                deathCount--;
            }

        }
        if (deathCount==0) System.out.println("you lose, you loser");
        else {
            System.out.println(word);
            System.out.println("you won, you piece of crap");
        }
    }

    public static void main(String[] args) {
        String[] words = {"Hello", "Big McThankies From Mr McSpankies"};
        String word = generateWord(words);
        hangman(word);
    }

}
