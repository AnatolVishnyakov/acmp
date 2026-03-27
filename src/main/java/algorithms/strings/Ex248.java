package algorithms.strings;

import java.io.PrintWriter;
import java.util.Scanner;

public class Ex248 {
    record State(StringBuilder sb, Boolean changed) {
    }

    static String year1(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            boolean isUpper = Character.isUpperCase(s.charAt(i));
            char curr = Character.toLowerCase(s.charAt(i));
            char next = i + 1 < s.length()
                    ? s.charAt(i + 1) : '0';
            if (curr == 'c') {
                switch (next) {
                    case 'i', 'e' -> {
                        if (isUpper) sb.append('S');
                        else sb.append('s');
                    }
                    case 'k' -> {
                    }
                    default -> {
                        if (isUpper) sb.append('K');
                        else sb.append('k');
                    }
                }
            } else {
                int prev = i - 1;
                if (prev >= 0 && Character.isUpperCase(s.charAt(prev)) && Character.toLowerCase(s.charAt(prev)) == 'c' && Character.toLowerCase(curr) == 'k') {
                    isUpper = true;
                }
                if (isUpper) sb.append(Character.toUpperCase(curr));
                else sb.append(curr);
            }
        }
        return sb.toString();
    }

    static State year2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && Character.isLetter(s.charAt(i)) && Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(i + 1))) {
                var c = s.charAt(i);
                if (c == 'e') {
                    sb.append('i');
                    i++;
                } else if (c == 'o') {
                    sb.append('u');
                    i++;
                } else {
                    sb.append(c);
                    if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(i + 1))) {
                        while (i + 1 < s.length()) {
                            if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(i + 1))) {
                                i++;
                            } else {
                                break;
                            }
                        }
                    }
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return new State(sb, sb.length() != s.length());
    }

    static State year3(State in) {
        var words = in.sb.toString().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            var word = words[i];
            if (!word.equalsIgnoreCase("the")) {
                if (word.length() > 1) {
                    if (word.endsWith("e")) {
                        if (i > 0) {
                            sb.append(' ');
                        }
                        sb.append(word, 0, word.length() - 1);
                        continue;
                    }
                }
            }
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(word);
        }
        return new State(sb, in.changed);
    }

    static State year4(State in) {
        var words = in.sb.toString().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            var word = words[i].replace("'", "");
            if ((word.equalsIgnoreCase("a") && !in.changed) || word.equalsIgnoreCase("an") || word.equalsIgnoreCase("the")) {
                sb.append(words[i].replace(word, ""));
                continue;
            }
            if (i > 0 && !sb.isEmpty()) {
                sb.append(' ');
            }
            sb.append(word);
        }
        return new State(sb, in.changed);
    }

    static String all(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '.':
                case ',':
                case '?':
                case '!':
                case ':':
                case '-':
                case ';':
                case '(':
                case ')':
                case '"':
                case '\'':
                    sb.append(ch);
                    continue;
                case ' ':
                    if (!sb.isEmpty() && sb.charAt(sb.length() - 1) != ' ') {
                        sb.append(ch);
                    }
                    continue;
                default:
                    var word = new StringBuilder();
                    for (int j = i; j < s.length(); j++) {
                        if (!Character.isLetterOrDigit(s.charAt(j))) {
                            break;
                        }
                        word.append(s.charAt(j));
                    }
                    String res = year4(
                            year3(
                                    year2(
                                            year1(word.toString())
                                    )
                            )
                    ).sb.toString();
                    if (!res.isBlank()) {
                        sb.append(res);
                    }
                    i += word.length() - 1;
            }
        }
        int lastIndex = sb.length() - 1;
        if (lastIndex > 0 && sb.charAt(lastIndex) == ' ') {
            sb.deleteCharAt(lastIndex);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String input = in.next();
        if (input.length() <= 200) {
            out.print(all(input));
        }

        out.flush();
    }
}
