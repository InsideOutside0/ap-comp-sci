public class ApplesBananas {

    enum Word {Eat, Apple, Banana}

    public static String vowelize(int i, Word word) {
        String[] parts;
        if (word == Word.Apple) {
            parts = new String[]{"ap", "ay-", "ee-", "i-", "oh-", "oo-"};
            return parts[i];
        }
        else if (word == Word.Banana) {
            parts = new String[]{"nanas.", "-nay-nays.", "-nee-nees.", "-nigh-nighs.", "-no-nos.", "-noo-noos."};
            return parts[i];
        }
        else if (word == Word.Eat) {
            parts = new String[]{"eat", "ate", "eat", "ite", "ote", "oot"};
            return parts[i];
        }
        return "error";
    }

    public static void repeatPrint(String str, int times) {
        for (int i = 1; i<=times; i++) System.out.println(str);
    }

    public static void lyricize() {
        // I could have done this without StringBuilders,
        // but they make things far more efficient,
        // since they are mutable unlike strings
        String base = "I like to eat, eat, eat apples and bananas.";
        StringBuilder sb = new StringBuilder(base);
        repeatPrint(base, 4);
        System.out.println();
        for (int i = 1; i<=5; i++) {

            // replace "eat"
            sb.replace(10, 13, vowelize(i, Word.Eat));
            sb.replace(15, 18, vowelize(i, Word.Eat));
            sb.replace(20, 23, vowelize(i, Word.Eat));

            // replace "apples"
            int end = 24+vowelize(i-1, Word.Apple).length();
            sb.replace(24, end, vowelize(i, Word.Apple));
            end = 24+vowelize(i, Word.Apple).length();

            // replace "bananas"
            int start=end+12; // sorry about the hard coding
            sb.delete(start, sb.length());
            sb.append(vowelize(i, Word.Banana));

            // now we print
            repeatPrint(sb.toString(), 2);
            System.out.println();
        }
        repeatPrint(base, 4);
    }

    public static void main (String[] args) {
        lyricize();
    }
}
