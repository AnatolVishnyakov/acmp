package strings;

import java.io.PrintWriter;
import java.util.Scanner;

public class Ex297 {
    // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
    private static Integer[] map = {1, 0, 0, 0, 0, 0, 1, 0, 2, 1};

    private static int getCountCircle(char[] number) {
        int count = 0;
        for (int i = 0; i < number.length; i++) {
            int symb = Character.getNumericValue(number[i]);
            if (map[symb] != 0) {
                count += map[symb];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String number = in.nextLine();
        if (number.length() > 0 && number.length() <= 101)
            out.print(getCountCircle(number.toCharArray()));

        out.flush();
    }
}