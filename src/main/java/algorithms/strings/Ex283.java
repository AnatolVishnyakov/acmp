package main.java.strings;

import java.io.PrintWriter;
import java.util.Scanner;

public class Ex283 {
    private static boolean isUpper(char symbol){
        return (symbol >= 'A' && symbol <= 'Z');
    }
    private static boolean isLower(char symbol){
        return (symbol >= 'a' && symbol <= 'z');
    }
    static String handleString(String str){
        if(str.length() > 100_000){
            return "No";
        }
        for (int i = 0; i < str.length(); i++) {
            if(isUpper(str.charAt(i++))){
                int countSymb = 0;
                while(i + countSymb < str.length() && isLower(str.charAt(i + countSymb))){
                    countSymb++;

                    if(countSymb > 3)
                        return "No";
                }
                if(countSymb == 0) return "No";

                i += countSymb - 1;
            } else
                return "No";
        }

        return "Yes";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        out.print(handleString(in.next()));

        out.flush();
    }
}