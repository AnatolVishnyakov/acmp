package algorithms.strings;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Ex279 {

    private static final int MAX_LENGTH = 100_000;
    private static final LinkedList<Character> queue = new LinkedList<>();

    public static int check(String s) {
        int magicAttempts = 0;
        if (s == null || s.isEmpty()) {
            return magicAttempts;
        }

        for (Character ch : s.toCharArray()) {
            switch (ch) {
                case '[':
                case '(':
                    queue.add(ch);
                    continue;
                case ']':
                    if (queue.isEmpty()) return -1;
                    if (queue.pollLast() != '[') {
                        magicAttempts++;
                    }
                    continue;
                case ')': {
                    if (queue.isEmpty()) return -1;
                    if (queue.pollLast() != '(') {
                        magicAttempts++;
                    }
                    continue;
                }
                default:
                    return -1;
            }
        }
        if (!queue.isEmpty()) {
            return -1;
        }
        return magicAttempts;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String s = in.next();
        if (s.length() <= MAX_LENGTH) {
            out.print(check(s));
        }

        out.flush();
    }
}
