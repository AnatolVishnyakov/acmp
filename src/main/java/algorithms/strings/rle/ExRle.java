package algorithms.strings.rle;

public class ExRle {
    public static String rle(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("Input string is empty");
        }

        final StringBuilder builder = new StringBuilder();

        int count = 1;
        int i = 1;
        for (; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                count++;
                continue;
            }

            builder.append(s.charAt(i - 1));
            if (count > 1) {
                builder.append(count);
                count = 1;
            }
        }

        builder.append(s.charAt(i - 1));
        if (count > 1) {
            builder.append(count);
        }

        return builder.toString();
    }

    public static int[] kmp(String s) {
        final int n = s.length();
        int[] pi = new int[n];
        int j = 0;
        for (int i = 1; i < n; i++) {
            j = pi[i - 1];
            while ((j > 0) && (s.charAt(i) != s.charAt(j))) {
                j = pi[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                ++j;
            }

            pi[i] = j;
        }

        return pi;
    }

    public static int[] prefixFunction(String s) {
        final char[] a = s.toCharArray();
        final int n = a.length;

        int len = 0;
        int[] pi = new int[n + 1];
        for (int i = 1; i < n; i++) {
            while (true) {
                if (a[len] == a[i]) {
                    len++;
                    break;
                }
                if (len == 0) {
                    break;
                }
                len = pi[len];
            }
            pi[i + 1] = len;
        }

        return pi;
    }

    public static void main(String[] args) {
        final String s = "abababab";
        final int n = s.length();


        int[] result = prefixFunction(s);
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }

        System.out.println();
        result = kmp(s);
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
