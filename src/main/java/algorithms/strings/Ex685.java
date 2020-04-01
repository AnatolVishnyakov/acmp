package main.java.strings;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex685 {
    private static ArrayList<Integer> A = new ArrayList<>();
    private static ArrayList<Integer> B = new ArrayList<>();

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        for(int i = 1; i <= 3; i++)
            A.add(in.nextInt());

        for(int i = 1; i <= 3; i++)
            B.add(in.nextInt());

        Collections.sort(A);
        Collections.sort(B);

        Integer result = A.get(0) * B.get(0) +
                A.get(1) * B.get(1) +
                A.get(2) * B.get(2);
        out.print(result);

        out.flush();
    }
}
