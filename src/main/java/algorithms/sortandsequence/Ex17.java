package algorithms.sortandsequence;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Ex17 {
    private static final Scanner in = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);

    public static int[] prefixFunction(String str){
        final int n = str.length();
        int[] pi = new int[n];
        for (int i = 1; i < n; ++i)
        {
            int j = pi[i-1];
            while ((j > 0) && (str.charAt(i) != str.charAt(j))) {
                j = pi[j - 1];
            }

            if (str.charAt(i) == str.charAt(j)) {
                ++j;
            }

            pi[i] = j;
        }

        return pi;
    }

    public static void main(String[] args) {
        final int n = 13; // in.nextInt();
        final String s = "5 3 1 3 5 2 5 3 1 3 5 2 5"; // in.nextLine();

        System.out.println(Arrays.toString(prefixFunction("5313525313525")));
        System.out.println(Arrays.toString(prefixFunction("41121@41121")));
//        out.print();

        out.flush();
    }
}
