package main.java.strings;

import java.io.PrintWriter;
import java.util.*;

public class Ex204 {
    private static final int MAX_LENGTH = 50_000;

    private static boolean isValid(String stroka){
        return stroka.length() <= MAX_LENGTH
                && stroka.matches("[a-zA-Z]+\\.?");
    }

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

    private static int getMinimalSubString(String stroka){
        int[] weight = prefix_function(stroka);

        int count = 0;
        while(weight[count] == 0){
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String stroka = in.next();
        if(isValid(stroka)){
            out.print(getMinimalSubString(stroka)-1);
        }

        out.flush();
    }
}
