package algorithms.sortandsequence;

import java.io.PrintWriter;
import java.util.Scanner;

public class Ex17 {
    private static final Scanner in = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);

    static class Pair {
        private int[] pi;
        private int matchLength;

        public Pair(int[] pi, int matchLength) {
            this.pi = pi;
            this.matchLength = matchLength;
        }

        public int[] getPi() {
            return pi;
        }

        public int getMatchLength() {
            return matchLength;
        }
    }

    public static Pair prefixFunction(int[] values) {
        final int n = values.length;
        int[] pi = new int[n];
        int j = 0;
        for (int i = 1; i < n; ++i) {
            j = pi[i - 1];
            while ((j > 0) && (values[i] != values[j])) {
                j = pi[j - 1];
            }

            if (values[i] == values[j]) {
                ++j;
            }

            pi[i] = j;
        }

        return new Pair(pi, j);
    }

    public static int findMinCountSegment(int[] values) {
        final Pair pair = prefixFunction(values);
        final int[] weight = pair.getPi();
        final int n = values.length;
        int len = pair.getMatchLength();

        while (true) {
            int period = n - len;
            if ((n - 1) % period == 0) {
                return period;
            }
//            assert len > 1;
            len = weight[len];
        }
    }

    public static void main(String[] args) {
        final int n = in.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = in.nextInt();
        }

        if (values[0] == values[n - 1]) {
            out.print(findMinCountSegment(values));
        }

        out.flush();
    }
}
