package algorithms.strings;

import java.io.PrintWriter;
import java.util.Scanner;

public class Ex539 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int N = in.nextInt();
        if (N == 1)
            out.print(0);
        else if (N >= 0 && N <= 1000) {
            if (N % 2 == 0)
                out.print(N / 2);
            else
                out.print(N);
        }

        out.flush();
    }
}