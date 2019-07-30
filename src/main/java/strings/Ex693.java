package main.java.strings;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Ex693 {
    private static String alphabetic = "abcdefghijklmnopqrstuvwxyz";
    private static boolean isValid(char[] chars){
        for(char ch : chars){
            if(alphabetic.indexOf(String.valueOf(ch)) == -1)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        boolean isTrue = false;
        String s = in.nextLine();
        if(s.length() > 0 && s.length() <= 100){
            String[] buf = s.split(" ");
            char[] oneString = buf[0].toLowerCase().toCharArray();
            char[] twoString = buf[1].toLowerCase().toCharArray();
            if(oneString.length == twoString.length &&
                    isValid(oneString) && isValid(twoString))
            {
                Arrays.sort(oneString);
                Arrays.sort(twoString);

                isTrue = Arrays.equals(oneString, twoString);
            }
        }

        if(isTrue){
            out.print("Yes");
        } else {
            out.print("No");
        }

        out.flush();    }
}