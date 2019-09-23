package strings;

import java.io.PrintWriter;
import java.util.Scanner;

public class Ex233 {
    private static int heightBus = 437;

    public static boolean checkHeight(int height) {
        if (height <= heightBus)
            return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int N = in.nextInt();
        boolean flag = true;
        if (N >= 1 && N <= 1000) {
            for (int i = 0; i < N; i++) {
                int height = in.nextInt();
                if (height <= 10_000)
                    if (!checkHeight(height)) {
                        out.print("Crash " + (i + 1));
                        flag = false;
                        break;
                    }
            }
            if (flag)
                out.print("No crash");
        }

        out.flush();
    }
}