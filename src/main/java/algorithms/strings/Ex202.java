package algorithms.strings;

import java.io.PrintWriter;
import java.util.Scanner;

public class Ex202 {
    public static int[] prefix_function(String stroka){
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

    public static String getResult(String str, String subStr){
        int[] weight = prefix_function(subStr + "@" + str);

        StringBuilder sb = new StringBuilder();
        int index = subStr.length();
        for(int i = 0; i < weight.length; i++)
            if(subStr.length() == weight[i])
                sb.append(i - index - subStr.length() + " ");

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        out.print(getResult(in.next(), in.next()));

        out.flush();
    }
}