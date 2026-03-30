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

    // Ooo -> Uo
    // Oooo -> Uu -> U
    // Eee -> Ie
    // Eeee -> Ii -> I
    // Eeeee -> Ieee -> Iie -> Ie
    static State year2(String s) {
        StringBuilder sb = new StringBuilder();
        boolean replaced = false;
        for (int i = 0; i < s.length(); i++) {
            if (isDuplicate(s, i, i + 1)) {
                replaced = true;
                boolean isUpper = Character.isUpperCase(s.charAt(i));
                var c = Character.toLowerCase(s.charAt(i));
                if (c == 'e') {
                    if (isUpper) sb.append('I');
                    else sb.append('i');
                } else if (c == 'o') {
                    if (isUpper) sb.append('U');
                    else sb.append('u');
                } else {
                    if (isUpper) sb.append(Character.toUpperCase(c));
                    else sb.append(c);
                }
                i++;
            } else {
                sb.append(s.charAt(i));
            }
        }
        if (replaced) {
            if (sb.toString().equalsIgnoreCase("a")) {
                return new State(sb, sb.length() != s.length());
            }
            return year2(sb.toString());
        }
        return new State(sb, sb.length() != s.length());
    }

    private static boolean isDuplicate(String s, int curr, int next) {
        return next < s.length() &&
               Character.isLetter(s.charAt(curr)) &&
               Character.toLowerCase(s.charAt(curr)) == Character.toLowerCase(s.charAt(next));
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
