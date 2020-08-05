package algorithms.strings;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Ex204 {
    public static class StringHandler {
        private static final int MAX_LENGTH = 50_000;
        private String text;

        public StringHandler(String text) {
            this.text = text;
        }

        private static int[] prefixFunction(String text) {
            int n = text.length();
            int[] pi = new int[n];
            for (int i = 1; i < n; ++i) {
                int j = pi[i - 1];
                while ((j > 0) && (text.charAt(i) != text.charAt(j)))
                    j = pi[j - 1];

                if (text.charAt(i) == text.charAt(j))
                    ++j;

                pi[i] = j;
            }

            return pi;
        }

        public boolean isValidString() {
            return text.length() <= MAX_LENGTH
                    && text.matches("[a-zA-Z]+");
        }

        public int process() {
            String t = text;
            int[] weight = prefixFunction(t);
            System.out.println(
                    Arrays.toString(t.toString().toCharArray()).replace(",", "")
                            + "\n" + Arrays.toString(weight).replace(",", "") + "\n");

            int count = (int) Arrays.stream(weight)
                    .filter(value -> value == 0)
                    .count();
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String stroka = in.next();
        StringHandler handler = new StringHandler(stroka);
        if (handler.isValidString()) {
            out.print(handler.process());
        }

        out.flush();
    }
}
