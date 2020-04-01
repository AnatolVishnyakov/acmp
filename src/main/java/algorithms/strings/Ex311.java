package main.java.strings;

import java.io.PrintWriter;
import java.util.Scanner;

public class Ex311 {
    private static final int MAX_BOUND = 200;
    private static final int MIN_BOUND = 0;
    private static Scanner in = new Scanner(System.in);
    private static PrintWriter out = new PrintWriter(System.out);

    private static int factorial(int number) {
        if(number == 0){
            return 1;
        }
        return number * factorial(number - 1);
    }

    private static int getSumFactorial(int number){
        int sum = 0;
        while (number > MIN_BOUND){
            sum += factorial(number);
            number--;
        }
        return sum;
    }

    public static void main(String[] args) {
        int N = in.nextInt();

        if(N > MIN_BOUND && N <= MAX_BOUND){
            out.println(getSumFactorial(N));
        }

        out.flush();
    }
}
