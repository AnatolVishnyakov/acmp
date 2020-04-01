package algorithms.strings;

import java.io.PrintWriter;
import java.util.Scanner;

class Tuple {
    public String string;
    public int count;

    Tuple(String s, int i) {
        string = s;
        count = i;
    }
}

public class Ex95 {
    // 1 2 3 4 5 6 7 8 9
    public static Tuple getValue(String s, int count) {
        if (s.length() == 1)
            return new Tuple(s, count);

        int value = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (value == 0)
                value = Integer.parseInt(Character.toString(s.charAt(i))) + Integer.parseInt(Character.toString(s.charAt(i + 1)));
            else
                value += Integer.parseInt(Character.toString(s.charAt(i + 1)));
        }

        return getValue(Integer.toString(value), count + 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String number = in.next();
        if (number.length() <= 10 * 1000) {
            Tuple t = getValue(number, 0);

            out.print(t.string + " " + t.count);
        }

        out.flush();
    }
}
