public class PigLatin {


    private String[] words;

    public PigLatin (String phrase) {
        words = splitSpace(phrase);
    }

    public static String[] splitSpace(String str) {
        String[] output = new String[];
        String s = " ";
        char space = s.charAt(0);
        while (str.length()>0) {
            for (int i= 0; i<str.length(); i++) {
                if (str.charAt(i) == space) {
                    output[i] = str.substring(0, i);
                    str = str.substring(i+1);
                    break;
                }
            }
        }
        return output;
    }

    public static String getConsonants(String str) {
        String[] VOWELS = {"a", "e", "i", "o", "u"};
        String output = "";
        for (int i = 0; i<str.length(); i++) {
            for (int j = 0; j<VOWELS.length; j++) {
                if (Character.toString(str.charAt(i)).equals(VOWELS[j])) {
                    return output;
                }
                output+=str.charAt(i);
            }
        }
        return str;
    }

    public void latinize(String[] words) {
        String output = "";
        for (int i = 0; i<words.length; i++) {
            String word = words[i].toLowerCase();
            String beginning = getConsonants(word);
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
        PigLatin pig = new PigLatin("Hello there ladies and gents");
        pig.latinize(pig.words);
    }

}
