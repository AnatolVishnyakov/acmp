package main.java.binarysearch;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static boolean isValidNumberOfCopy(int value) {
        return value != 0 && value != 1;
    }

    private static int print(int speedXerox, AtomicInteger currentSpeed) {
        if (currentSpeed.get() == speedXerox) {
            currentSpeed.set(1);
            return 1;
        }
        currentSpeed.incrementAndGet();
        return 0;
    }

    public static int run(int n, int x, int y) {
        if (isValidNumberOfCopy(n)) {
            int numberOfCopyDocument = 1; // сделали копию
            AtomicInteger firstXerox =  new AtomicInteger(1);
            AtomicInteger secondXerox = new AtomicInteger(1);
            final int minSpeed = (x < y) ? x : y;
            final int maxSpeed = (x > y) ? x : y;

            int time;
            for (time = 2; ; time++) {
                if (minSpeed != 0) {
                    numberOfCopyDocument += print(minSpeed, firstXerox);
                    if (numberOfCopyDocument == n) {
                        break;
                    }
                }
                if (maxSpeed != 0) {
                    numberOfCopyDocument += print(maxSpeed, secondXerox);
                    if (numberOfCopyDocument == n) {
                        break;
                    }
                }
            }

            return time;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(8 / 3);
        Scanner reader = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        int n = reader.nextInt();
        int x = reader.nextInt();
        int y = reader.nextInt();

        int result = run(n, x, y);
        writer.println(result);

        writer.flush();
    }
}