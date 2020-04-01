package main.java.strings;

import java.io.PrintWriter;
import java.util.Scanner;

public class Ex950 {
    private static final int INPUT_RESTRICTION = 255;
    private static Scanner in = new Scanner(System.in);
    private static PrintWriter out = new PrintWriter(System.out);
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    private static String handle(String string) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == '1'){
                sb.append(alphabet.charAt(0));
            } else {
                int j = 0;
                while(string.charAt(i + j) == '0') j++;
                if(j <= string.length() && string.charAt(i + j) == '1'){
                    sb.append(alphabet.charAt(j));
                }
                i = i + j;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String string = in.nextLine();

        if(string.length() <= INPUT_RESTRICTION){
            out.print(handle(string));
            out.flush();
        }
    }
}