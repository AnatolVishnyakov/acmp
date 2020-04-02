package algorithms.strings;

import java.io.PrintWriter;
import java.util.Scanner;

public class Ex203 {
    private static ShiftIdentifier shiftIdentifier = new ShiftIdentifier();

    public static class ShiftIdentifier {
        private static final int NEGATIVE_OPTION = -1;
        private static final int DEFAULT_OPTION = 0;
        private static final String ALPHABET = "[a-zA-Z]+";

        public int shelfRight(String text, String pattern) {
            if (text.hashCode() == pattern.hashCode()) {
                return DEFAULT_OPTION;
            } else {
                int i;
                StringBuilder buffer = new StringBuilder(text);
                int N = pattern.length();
                for (i = 1; i <= N; i++) {
                    buffer.insert(0, buffer.charAt(N - 1));
                    buffer.deleteCharAt(N);
                    if (buffer.toString().hashCode() == pattern.hashCode()) {
                        return i;
                    }
                }
            }
            return NEGATIVE_OPTION;
        }

        public boolean isValid(String text, String pattern) {
            return text.length() == pattern.length() &&
                    text.matches(ALPHABET) &&
                    pattern.matches(ALPHABET) &&
                    text.length() > 0 && text.length() <= 10_000;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String text = in.next();
        String pattern = in.next();

        if (shiftIdentifier.isValid(text, pattern)) {
            out.print(shiftIdentifier.shelfRight(text, pattern));
        }

        out.flush();
    }
}