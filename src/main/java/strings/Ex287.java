package main.java.strings;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex287 {
    private static final Set<String> strings = new HashSet<String>();

    private static void countWords(String inStr, int n, int m){
        for(int i = 0; i < n; i++){
            if(i + m <= n){
                strings.add(inStr.substring(i, i + m));
            }
        }
    }
    private static boolean isValid(int num){
        return (num >= 1 && num <= 100);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt(), m = in.nextInt();
        if(isValid(n) && isValid(m)){
            String inStr = in.next();
            if(inStr.length() > 0) {
                countWords(inStr, n, m);
                out.print(strings.size());
            }
        }

        out.flush();
    }
}