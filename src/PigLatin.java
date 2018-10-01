/*
    Sam Stahl
    AP Computer Science
    PigLatinn
 */

import java.util.ArrayList;

public class PigLatin {

    // This better work for you because both the regex and my function failed to split spaces properly

    private String[] words;

    public PigLatin (String phrase) {
        words = splitSpace(phrase);
    }

    public static String[] splitSpace(String str) {
        ArrayList<String> output = new ArrayList<>();
        while (str.length()>0) {
            System.out.println(str.length());
            for (int i = 0; i < str.length(); i++) {
                System.out.println(i);
                System.out.println(str.charAt(i));
                if (Character.isWhitespace(str.charAt(i))) { // despite there being obvious whitespace it DOESN'T WORK
                    output.add(str.substring(0, i));
                    str = str.substring(i + 1);
                    break;
                } else {
                    output.add(str);
                    str = "";
                }
            }
         }
        String[] outputArray = output.toArray(new String[output.size()]);
        return outputArray;
    }

    public static String getConsonants(String str) {
        String[] VOWELS = {"a", "e", "i", "o", "u"};
        String output = "";
        for (int i = 0; i<str.length(); i++) {
            for (String s : VOWELS) {
                if (Character.toString(str.charAt(i)).equals(s)) return output;
            }
            output+=str.charAt(i);
        }
        return str;
    }

    public void latinize(String[] words) {
        String output = "";
        for (int i = 0; i<words.length; i++) {
            String word = words[i].toLowerCase();
            String beginning = getConsonants(word);
            System.out.println(beginning);
            if (beginning.length() == 0) {
                output += word + "way ";
            } else {
                StringBuilder sb = new StringBuilder(word);
                sb.delete(0, beginning.length());
                sb.append(beginning + "ay");
                output += sb.toString() + " ";
            }
        }
        System.out.println(output);
    }

    public static void main (String[] args) {
        PigLatin pig = new PigLatin("egg is good");
        pig.latinize(pig.words);
    }

}
