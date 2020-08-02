package algorithms.strings;

import java.io.PrintWriter;
import java.util.Scanner;

public class Ex847 {
    private static final Scanner in = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);
    private static final String SPACE_SYMBOL = " ";
    private static final int MAX_SYMBOL_WORD = 20;
    private static final String NO = "NO";
    private static final String YES = "YES";

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() == s2.length() &&
                !s1.isEmpty() &&
                s1.length() < MAX_SYMBOL_WORD &&
                s1.matches("[a-z]+") &&
                s2.matches("[a-z]+")
        ) {
//            s1.chars().
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        final String[] params = in.nextLine().split(SPACE_SYMBOL);
        final String truthWord = params[0];
        final String checkedWord = params[1];

        if (isAnagram(truthWord, checkedWord)) {
            out.print(YES);
        } else {
            out.print(NO);
        }

        out.flush();
    }
}
