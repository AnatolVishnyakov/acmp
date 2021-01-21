package algorithms.strings;

import java.io.PrintWriter;
import java.util.*;

/**
 * count[x][x] = 1      // если подстрока из одной скобки, то нужно добавить вторую
 * count[x][x + 1] = 0  // если скобки парные: [] {} () инача = 2
 *
 * 1. s = s1 + s2
 *          s                        s1                      s2
 * count[left][right] = min(count[left][right1] + count[left1][right]),
 *      left <= right1, right1 + 1 = left1, left1 <= right
 *
 * 2. Если первая и последняя скобки парные,
 * достроить до правильной скобочной последовательности
 * все что между ними
 *
 * count[left][right] = min(count[left][right], count[left + 1][right - 1])
 * где left + 1 - пропуск первой скобки и right - 1 - пропуск последней скобки
 *
 * Пример:
 * {(})
 * 0123
 *
 * count[0][0] = 1
 * count[1][1] = 1
 * count[2][2] = 1
 * count[3][3] = 1
 *
 * count[0][1] = 2
 * count[1][2] = 2
 * count[2][3] = 2
 *
 * count[0][2] = min(count[1][1], count[0][0] + count[1][2], count[0][1] + count[2][2]) = 1
 * */
public class Ex249 {

    enum BracketsMapper {
        CIRCLE('(', ')'),
        SQUARE('[', ']'),
        BRACE('{', '}');

        private final char openBracket;
        private final char closeBracket;

        BracketsMapper(char openBracket, char closeBracket) {
            this.openBracket = openBracket;
            this.closeBracket = closeBracket;
        }

        public static boolean equals(char open, char close) {
            return Arrays.stream(values())
                    .anyMatch(bracket -> bracket.openBracket == open && bracket.closeBracket == close);
        }
    }

    public static int countNumberBrackets(String s) {
        int counter = 0;
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            if (symbol == '{' || symbol == '(' || symbol == '[') {
                deque.push(symbol);
            } else {
                if (deque.size() > 0 && BracketsMapper.equals(deque.getFirst(), symbol)) {
                    deque.pop();
                } else {
                    counter++;
                }
            }
        }
        return counter + deque.size();
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
