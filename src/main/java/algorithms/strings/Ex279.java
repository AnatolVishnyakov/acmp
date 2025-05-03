package algorithms.strings;

import java.util.LinkedList;

public class Ex279 {

    LinkedList<Character> queue = new LinkedList<Character>();

    public boolean check(String s) {
        int magicAttempts = 1;

        if (s.isEmpty()) return true;
        for (Character ch : s.toCharArray()) {
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    queue.add(ch);
                    continue;
                case '}':
                    if (queue.isEmpty()) return false;
                    if (queue.peekLast() == '{' || magicAttempts == 1) {
                        queue.pollLast();
                        magicAttempts--;
                    }
                    continue;
                case ']':
                    if (queue.isEmpty()) return false;
                    if (queue.peekLast() == '[' || magicAttempts == 1) {
                        queue.pollLast();
                        magicAttempts--;
                    }
                    continue;
                case ')': {
                    if (queue.isEmpty()) return false;
                    if (queue.peekLast() == '(' || magicAttempts == 1) {
                        queue.pollLast();
                        magicAttempts--;
                    }
                    continue;
                }
                default:
                    return false;
            }
        }
        return queue.isEmpty();
    }

    public static void main(String[] args) {

    }
}
