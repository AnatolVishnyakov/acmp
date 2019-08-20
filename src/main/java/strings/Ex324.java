package main.java.strings;

import java.io.PrintWriter;
import java.util.Scanner;

public class Ex324 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String numStr = in.next();

        int numInt = Integer.parseInt(numStr);
        if (numInt >= 1000 && numInt <= 9999) {
            if (numStr.charAt(0) == numStr.charAt(3) && numStr.charAt(1) == numStr.charAt(2))
                out.print("YES");
            else
                out.print("NO");
        }

        out.flush();
    }
}
