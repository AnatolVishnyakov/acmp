package algorithms;

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

    public static void main(String[] args) {
        System.out.println(searchPrimitive("ABRA", "ABACADABRAC"));
        System.out.println(searchAlternative("ABRA", "ABACADABRAC"));
    }
}
