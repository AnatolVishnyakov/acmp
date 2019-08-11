package main.java.strings;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Ex682 {
    private static LinkedList<Character> sumN(int N) {
        switch (N) {
            case 1:
                return new LinkedList<>(Arrays.asList('4', '5'));
            case 2:
                return new LinkedList<>(Arrays.asList('4', '9', '0', '5'));
            case 3:
                return new LinkedList<>(Arrays.asList('4', '9', '4', '5', '5', '0'));
            case 4:
                return new LinkedList<>(Arrays.asList('4', '9', '4', '9', '5', '5', '0', '0'));
            default:
                LinkedList<Character> result = new LinkedList<>(Arrays.asList('4', '9', '4', '9', '5', '5', '0', '0'));
                int index = 6;
                for (int i = 0; i < N - 4; i++) {
                    result.add(3, '9');
                    index++;
                    result.add(index++, '0');
                }
                return result;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int N = in.nextInt();

        if (N >= 1 && N <= 100) {
            LinkedList<Character> result = sumN(N);
            for (int i = 0; i < result.size(); i++)
                out.print(result.get(i));

        }
        out.flush();
    }
}
