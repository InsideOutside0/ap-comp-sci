import java.util.ArrayList;

public class StringArrayList {

    private ArrayList<String> letters = new ArrayList<>();
    private String upper;

    public StringArrayList(String s) {
        //Precondition: sentence is a multi-word String
        //Initialize the ArrayList letters with the letters of
        //sentence.  Exclude spaces and other punctuation.
        //letters.contains(" ") will tell you if a space exists in the ArrayList
        //letters.indexOf(" ") will tell you which index the space is at
        this.upper = s.toUpperCase();
        for (int i = 0; i<s.length(); i++) {
            char ch = upper.charAt(i);
            if (Character.isAlphabetic(ch) && !letters.contains(Character.toString(ch))) letters.add(Character.toString(ch));
        }

    }

    public String removeVowels() {
        String output = "";
        String[] vowels = {"A", "E", "I", "O", "U"};
        boolean isVowel;
        for (String s : letters) {
            isVowel = false;
            for (int i = 0; i<vowels.length; i++) if (s.equals(vowels[i])) isVowel = true;
            if (!isVowel) output+=s;
        }
        return output;
    }

    public void rowsOfThree() {
        //prints out the letters in multiple rows of 3
        int len = letters.size();
        while (len>0) {
            for (int i = 1; i<=3; i++) {
                if (len<=0) return;
                System.out.print(letters.get(0) + " ");
                letters.remove(0);
                len--;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        StringArrayList s = new StringArrayList("I'm already Tracer");
        System.out.println(s.removeVowels());
        s.rowsOfThree();
    }

}