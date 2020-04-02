package algorithms.strings;

import java.io.PrintWriter;
import java.util.Scanner;

public class Ex204 {
    public static class StringHandler {
        private static final int MAX_LENGTH = 50_000;
        private String text;
        private final int M;
        private final int R;
        private int[][] dfa;

        public StringHandler(String text) {
            this.text = text;
            M = text.length();
            R = 256;

            dfa = new int[R][M];
            dfa[text.charAt(0)][0] = 1;
            for (int X = 0, j = 1; j < M; j++) {
                for (int c = 0; c < R; c++) {
                    dfa[c][j] = dfa[c][X];
                }
                dfa[text.charAt(j)][j] = j + 1;
                X = dfa[text.charAt(j)][X];
            }
        }

        public boolean isValidString() {
            return text.length() <= MAX_LENGTH
                    && text.matches("[a-zA-Z]+");
        }

        public int process() {
            int count = 0;
            boolean isAllZero = true;
            for (int i = 0; i < R; i++, isAllZero = true) {
                for (int j = 0; j < M; j++) {
                    if (dfa[i][j] != 0) {
                        isAllZero = false;
                        break;
                    }
                }
                if (!isAllZero) {
                    count++;
                }
            }

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
