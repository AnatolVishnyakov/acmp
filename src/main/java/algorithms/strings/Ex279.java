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
                    if (queue.peekLast() == '{') {
                        queue.pollLast();
                    }
                    continue;
                case ']':
                    if (queue.isEmpty()) return false;
                    if (queue.peekLast() == '[') {
                        queue.pollLast();
                    }
                    continue;
                case ')': {
                    if (queue.isEmpty()) return false;
                    if (queue.peekLast() == '(') {
                        queue.pollLast();
                    }
                    continue;
                }

            }
        }
        return queue.isEmpty();
    }

    public static void main(String[] args) {

    }
}
