package algorithms.strings;

import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.min;

/**
 * count[x][x] = 1      // если подстрока из одной скобки, то нужно добавить вторую
 * count[x][x + 1] = 0  // если скобки парные: [] {} () инача = 2
 * <p>
 * 1. s = s1 + s2
 * s                        s1                      s2
 * count[left][right] = min(count[left][right1] + count[left1][right]),
 * left <= right1, right1 + 1 = left1, left1 <= right
 * <p>
 * 2. Если первая и последняя скобки парные,
 * достроить до правильной скобочной последовательности
 * все что между ними
 * <p>
 * count[left][right] = min(count[left][right], count[left + 1][right - 1])
 * где left + 1 - пропуск первой скобки и right - 1 - пропуск последней скобки
 * <p>
 * Пример:
 * {(})
 * 0123
 * <p>
 * count[0][0] = 1
 * count[1][1] = 1
 * count[2][2] = 1
 * count[3][3] = 1
 * <p>
 * count[0][1] = 2
 * count[1][2] = 2
 * count[2][3] = 2
 * <p>
 * count[0][2] = min(count[1][1], count[0][0] + count[1][2], count[0][1] + count[2][2]) = 1
 */
public class Ex249 {
    public static int countNumberBrackets(String s) {
        int[][] count = new int[s.length()][s.length()];
        for (int len = 1; len <= s.length(); len++) {
            for (int left = 0; left + len - 1 < s.length(); left++) {
                int right = left + len - 1;
                if (len == 1) {
                    count[left][right] = 1;
                } else if (len == 2) {
                    if ((s.charAt(left) == '(' && s.charAt(right) == ')')
                            || (s.charAt(left) == '{' && s.charAt(right) == '}')
                            || (s.charAt(left) == '[' && s.charAt(right) == ']')) {
                        count[left][right] = 0;
                    } else {
                        count[left][right] = 2;
                    }
                } else {
                    if ((s.charAt(left) == '(' && s.charAt(right) == ')')
                            || (s.charAt(left) == '{' && s.charAt(right) == '}')
                            || (s.charAt(left) == '[' && s.charAt(right) == ']')) {
                        count[left][right] = min(count[left][right], count[left + 1][right - 1]);
                    }

                    for (int right1 = left; right1 < right; right1++) {
                        int left2 = right1 + 1;
                        count[left][right] = min(count[left][right], count[left][right1] + count[left2][right]);
                    }
                }
            }
        }

        return count[0][s.length() - 1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        final String s = in.next();
        if (!s.isEmpty()) {
            out.print(countNumberBrackets(s));
        }

        out.flush();
    }
}
