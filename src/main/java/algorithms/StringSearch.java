package algorithms;

import java.util.Arrays;

public class StringSearch {
    // примитивная реализация
    public static int searchPrimitive(String pattern, String text) {
        final int M = pattern.length();
        final int N = text.length();

        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == M) {
                return i;
            }
        }
        return N;
    }

    // примитивная реализация (явное восстановление указателя)
    public static int searchAlternative(String pattern, String text) {
        int i, M = pattern.length();
        int j, N = text.length();

        for (i = 0, j = 0; i < N && j < M; i++) {
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            } else {
                i -= j;
                j = 0;
            }
        }
        if (j == M) {
            return i - M;
        }
        return N;
    }

    public static int[][] createDKA(String pattern) {
        final int M = pattern.length();
        final int R = 100;
        int[][] dfa = new int[R][M];
        dfa[pattern.charAt(0)][0] = 1;

        int X = 0;
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X];
            }
            dfa[pattern.charAt(j)][j] = j + 1;
            X = dfa[pattern.charAt(j)][X];
        }

        return dfa;
    }

    public static class KMP {
        private final int M;
        private final int R;
        private String pattern;
        private int[][] dfa;

        public KMP(String pattern) {
            this.pattern = pattern;
            M = pattern.length();
            R = 256;

            dfa = new int[R][M];
            dfa[pattern.charAt(0)][0] = 1;
            for (int X = 0, j = 1; j < M; j++) {
                for (int c = 0; c < R; c++) {
                    dfa[c][j] = dfa[c][X];
                }
                dfa[pattern.charAt(j)][j] = j + 1;
                X = dfa[pattern.charAt(j)][X];
            }
        }

        public int search(int startPosition, String text) {
            int i, j, N = text.length(), M = pattern.length();
            for (i = startPosition, j = 0; i < N && j < M; i++) {
                j = dfa[text.charAt(i)][j];
            }
            if (j == M) {
                return i - M;
            } else {
                return N;
            }
        }

        public int[] searchAll(String text) {
            int[] result = new int[text.length() / pattern.length()];
            if (pattern.length() <= text.length()) {
                int index = 0;
                int offset = search(0, text);
                if (offset != text.length()) {
                    result[index++] = offset;
                    while (offset + pattern.length() <= text.length()) {
                        offset = search(offset + 1, text);
                        if (offset != text.length()) {
                            result[index++] = offset;
                        }
                    }
                }
            }
            return result;
        }

        public void printDKA() {
            boolean isAllZero = true;
            for (int i = 0; i < R; i++, isAllZero = true) {
                for (int j = 0; j < M; j++) {
                    if (dfa[i][j] != 0) {
                        isAllZero = false;
                        break;
                    }
                }
                if (!isAllZero) {
                    System.out.println(Arrays.toString(dfa[i]));
                }
            }
            System.out.println();
        }
    }

    static class RabinKarp {
        private String pattern;
        private long patternHash;
        private int M;
        private long Q;
        private int R = 256;
        private long RM;

        public RabinKarp(String pattern) {
            this.pattern = pattern;
            this.M = pattern.length();
            this.Q = 31;
            this.RM = 1;
            for (int i = 1; i <= M - 1; i++) {
                RM = (R * RM) % Q;
            }
            this.patternHash = hash(pattern, M);
        }

        public boolean check(int i) {
            return true;
        }

        private long hash(String key, int M) {
            long h = 0;
            for (int j = 0; j < M; j++) {
                h = (R * h + key.charAt(j)) % Q;
            }
            return h;
        }

        private int search(String text) {
            int N = text.length();
            long textHash = hash(text, M);
            if (patternHash == textHash) {
                return 0;
            }
            for (int i = M; i < N; i++) {
                textHash = (textHash + Q - RM * text.charAt(i - M) % Q) % Q;
                textHash = (textHash * R + text.charAt(i)) % Q;
                if (patternHash == textHash) {
                    if (check(i - M + 1)) {
                        return i - M + 1;
                    }
                }
            }
            return N;
        }

        public int getShelf(String text) {
            for (int i = 0; i < text.length(); i++) {
                text = text.substring(1) + text.charAt(0);
                if (search(text) == 0) {
                    return i + 1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
//        System.out.println(searchPrimitive("ABRA", "ABACADABRAC"));
//        System.out.println(searchAlternative("ABRA", "ABACADABRAC"));

//        System.out.println(Arrays.deepToString(createDKA("ABABAC")));

        String pattern = "abcde";
//        KMP kmp = new KMP(pattern);
//        kmp.printDKA();
        String text = "deabc";

//        System.out.println(Arrays.toString(kmp.searchAll(text)));
//        offset = kmp.search(offset + 1, text);
//        System.out.println(offset);

        System.out.println(pattern.substring(1, pattern.length()) + pattern.charAt(0));

        RabinKarp rabinKarp = new RabinKarp(pattern);
        System.out.println(rabinKarp.search(text));
    }
}
