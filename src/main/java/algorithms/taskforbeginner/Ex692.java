package algorithms.taskforbeginner;

import java.io.PrintWriter;
import java.util.Scanner;

public class Ex692 {
    private static final Scanner in = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) {
        final int value = in.nextInt();
        if (Integer.bitCount(value) == 1) {
            out.print(YES);
        } else {
            out.print(NO);
        }
        out.flush();
    }
}
