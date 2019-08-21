package main.java.strings;

import java.io.PrintWriter;
import java.util.Scanner;

public class Ex597 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int N = 1_000_000_000;

        int R1 = in.nextInt();
        int R2 = in.nextInt();
        int R3 = in.nextInt();

        if(R1 >= 0 && R1 <= N)
            if(R2 >= 0 && R2 <= N)
                if(R3 >= 0 && R3 <= N){
                    if(R2 + R3 <= R1)
                        out.print("YES");
                    else
                        out.print("NO");
                }

        out.flush();
    }
}
