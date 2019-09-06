package strings;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Work on 06.05.2017.
 */
public class Ex574 {
    private static String isAnnogramma(String s1, String s2) {
        if(s1.length() != s2.length())
            return "NO";

        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);

        char[] c2 = s2.toCharArray();
        Arrays.sort(c2);

        s1 = String.valueOf(c1);
        s2 = String.valueOf(c2);

        if(s1.intern() == s2.intern())
            return "YES";

        return "NO";
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        out.print(isAnnogramma(in.next(), in.next()));

        out.flush();
    }
}