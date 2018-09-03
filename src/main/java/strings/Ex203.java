package main.java.strings;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class Ex203 {
    private static final int NEGATIVE_OPTION = -1;

    private static int[] prefix_function(String stroka){
        int n = stroka.length();
        int[] pi = new int[n];
        for (int i = 1; i < n; ++i)
        {
            int j = pi[i-1];
            while ((j > 0) && (stroka.charAt(i) != stroka.charAt(j)))
                j = pi[j-1];

            if (stroka.charAt(i) == stroka.charAt(j))
                ++j;

            pi[i] = j;
        }

        return pi;
    }

    private static int getShelf(String str, String subStr){
        int[] weight = prefix_function(subStr + "@" + str);
        return Arrays.stream(weight).max().getAsInt();
    }

    private static String shelfRight(String pattern, int shelfCount) {
        final int N = pattern.length();
        StringBuilder buffer = new StringBuilder();
        buffer.append(pattern, N-shelfCount, N);
        buffer.append(pattern, 0, N-shelfCount);
        return buffer.toString();
    }

    private static boolean isValid(String value) {
        return value.matches("[a-zA-Z]+\\.?")
                && value.length() > 0 && value.length() <= 10_000;
    }

    private static int handler(String source, String pattern) {
        int shelfCount = getShelf(source, pattern);
        source = shelfRight(source, shelfCount);

        if(source.hashCode() == pattern.hashCode()){
            return shelfCount;
        }

        return NEGATIVE_OPTION;
    }

    private static int check(String source, String pattern){
        if(source.length() == pattern.length() && isValid(pattern) &&
                source.hashCode() == pattern.hashCode()){
            return 0;
        }
        return handler(source, pattern);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String source = in.next();
        String pattern = in.next();

        out.print(check(source, pattern));

        out.flush();
    }
}
