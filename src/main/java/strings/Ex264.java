package strings;

import java.io.PrintWriter;
import java.util.Scanner;

public class Ex264 {
    public static int getMaxPeriodOt(Scanner in, int N) {
        int countDay = 0, MAX_DAY = 0;

        for (int i = 0; i < N; i++) {
            int value = in.nextInt();

            if (value > 0)
                countDay++;
            else {
                if (countDay > MAX_DAY)
                    MAX_DAY = countDay;
                countDay = 0;
            }
        }

        if (countDay > MAX_DAY)
            return countDay;

        return MAX_DAY;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int N = in.nextInt();

        if (N >= 1 && N <= 100)
            out.print(getMaxPeriodOt(in, N));

        out.flush();
    }
}