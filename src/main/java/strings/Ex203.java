package main.java.strings;

import java.io.PrintWriter;
import java.util.Scanner;


public class Ex203 {
    private static final int NEGATIVE_OPTION = -1;

    private static String shelfRight(String pattern) {
        final int N = pattern.length();
        StringBuilder buffer = new StringBuilder();
        buffer.append(pattern.charAt(N-1));
        buffer.append(pattern, 0, N-1);
        return buffer.toString();
    }

    private static boolean isValid(String value) {
        return value.length() > 0 && value.length() <= 10_000;
    }

    private static int check(String source, String pattern) {
        for(int i = 0; i < pattern.length(); i++) {
            if(source.hashCode() == pattern.hashCode()){
                return i;
            }
            source = shelfRight(source);
        }
        return NEGATIVE_OPTION;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String source = in.next();
        String pattern = in.next();

        if(source.length() == pattern.length() && isValid(source)){
            out.print(check(source, pattern));
        }

        out.flush();
    }
}
