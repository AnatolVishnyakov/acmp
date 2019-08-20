package main.java.strings;

import java.io.PrintWriter;
import java.util.Scanner;

public class Ex327 {
    public static boolean isHappy(int NUMBER){
        int sum1 = 0, sum2 = 0;
        for(int i = 0; i < 6; i++, NUMBER /= 10){
            if(i < 3)
                sum1 += NUMBER % 10;
            else
                sum2 += NUMBER % 10;
        }
        if(sum1 == sum2)
            return true;
        return false;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int MAX = in.nextInt();
        for(int i = 0; i < MAX; i++) {
            int NUMBER = in.nextInt();
            if (isHappy(NUMBER + 1) || isHappy(NUMBER - 1))
                out.println("Yes");
            else
                out.println("No");
        }

        out.flush();
    }
}
