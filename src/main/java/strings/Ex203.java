package main.java.strings;

import java.io.PrintWriter;
import java.util.Scanner;


public class Ex203 {
    private static final int NEGATIVE_OPTION = -1;
    private static final int DEFAULT_OPTION = 0;

    private static char[] getShelfRigth(char[] string) {
        char symb = string[string.length-1];
        for (int i = string.length-1; i > 0; i--) {
            string[i] = string[i-1];
        }
        string[0] = symb;
        return string;
    }

    private static boolean isValid(String value) {
        return value.matches("[a-zA-Z]+\\.?")
                && value.length() > 0 && value.length() <= 10_000;
    }

    private static int check(String source, String pattern){
        if(!isValid(source)){
            return NEGATIVE_OPTION;
        }

        if(source.hashCode() == pattern.hashCode()){
            return DEFAULT_OPTION;
        } else if(source.length() == 1) {
            return NEGATIVE_OPTION;
        }

        char[] _source = source.toCharArray();
        for (int i = 1; i <= _source.length; i++) {
            _source = getShelfRigth(_source);
            if(String.valueOf(_source).hashCode() == pattern.hashCode()){
                return i;
            }
        }

        return NEGATIVE_OPTION;
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
