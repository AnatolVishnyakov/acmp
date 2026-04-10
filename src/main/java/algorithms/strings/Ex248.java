package algorithms.strings;

import java.io.PrintWriter;
import java.util.EnumSet;
import java.util.Scanner;

public class Ex248 {
    enum WordFlag {
        CHANGED,
        REMOVED_K,
        NEED_UPPER_CASE,
        REMOVED_DUPLICATE,
        REMOVED_E,
    }

    record WordInProcess(StringBuilder sb, EnumSet<WordFlag> flags) {
        public String get() {
            return sb.toString();
        }
    }

    static WordInProcess year1(String s) {
        StringBuilder sb = new StringBuilder();
        var flags = EnumSet.noneOf(WordFlag.class);
        if (s.isBlank()) {
            return new WordInProcess(new StringBuilder(0), flags);
        }
        boolean isUpperCaseFirstSymbol = Character.isUpperCase(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            char curr = Character.toLowerCase(s.charAt(i));
            char next = i + 1 < s.length()
                    ? s.charAt(i + 1) : '0';
            if (curr == 'c') {
                switch (next) {
                    case 'i', 'e' -> {
                        if (i == 0 && isUpperCaseFirstSymbol) sb.append('S');
                        else sb.append('s');
                    }
                    case 'k' -> {
                        flags.add(WordFlag.CHANGED);
                        flags.add(WordFlag.REMOVED_K);
                        if (i == 0 && Character.isUpperCase(s.charAt(0))) {
                            flags.add(WordFlag.NEED_UPPER_CASE);
                        }
                    }
                    default -> {
                        if (i == 0 && isUpperCaseFirstSymbol) sb.append('K');
                        else sb.append('k');
                    }
                }
            } else {
                if (flags.contains(WordFlag.NEED_UPPER_CASE)) {
                    sb.append(Character.toUpperCase(curr));
                    flags.remove(WordFlag.NEED_UPPER_CASE);
                } else {
                    if (i == 0 && Character.isUpperCase(s.charAt(0))) {
                        sb.append(Character.toUpperCase(curr));
                    } else {
                        sb.append(curr);
                    }
                }
            }
        }
        return new WordInProcess(sb, EnumSet.noneOf(WordFlag.class));
    }

    static WordInProcess year2(WordInProcess word) {
        var s = word.sb.toString();
        var flags = EnumSet.noneOf(WordFlag.class);
        boolean isUpper = Character.isUpperCase(s.charAt(0));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isDuplicate(s, i, i + 1)) {
                flags.add(WordFlag.REMOVED_DUPLICATE);
                flags.add(WordFlag.CHANGED);
                var c = Character.toLowerCase(s.charAt(i));
                if (c == 'e') {
                    if (i == 0 && isUpper) sb.append('I');
                    else sb.append('i');
                } else if (c == 'o') {
                    if (i == 0 && isUpper) sb.append('U');
                    else sb.append('u');
                } else {
                    if (i == 0 && isUpper) sb.append(Character.toUpperCase(c));
                    else sb.append(c);
                }
                i++;
            } else {
                sb.append(s.charAt(i));
            }
        }
        if (flags.contains(WordFlag.REMOVED_DUPLICATE)) {
            if (sb.toString().equalsIgnoreCase("a")) {
                return new WordInProcess(sb, flags);
            }
            var res = year2(new WordInProcess(sb, flags));
            return new WordInProcess(res.sb, flags);
        }
        return new WordInProcess(sb, flags);
    }

    private static boolean isDuplicate(String s, int curr, int next) {
        return next < s.length() &&
               Character.isLetter(s.charAt(curr)) &&
               Character.toLowerCase(s.charAt(curr)) == Character.toLowerCase(s.charAt(next));
    }

    static WordInProcess year3(WordInProcess in) {
        var words = in.sb.toString().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            var word = words[i];
            if (word.length() > 1) {
                if (word.endsWith("e")) {
                    if (i > 0) {
                        sb.append(' ');
                    }
                    sb.append(word, 0, word.length() - 1);
                    in.flags.add(WordFlag.REMOVED_E);
                    in.flags.add(WordFlag.CHANGED);
                    continue;
                }
            }
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(word);
        }
        return new WordInProcess(sb, in.flags);
    }

    static WordInProcess year4(WordInProcess in) {
        var words = in.sb.toString().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            var word = words[i].replace("'", "");
            if ((word.equalsIgnoreCase("a") && !in.flags.contains(WordFlag.CHANGED)) ||
                (word.equalsIgnoreCase("an") && !in.flags.contains(WordFlag.CHANGED)) ||
                (word.equalsIgnoreCase("th") && in.flags.contains(WordFlag.REMOVED_E))
            ) {
                sb.append(words[i].replace(word, ""));
                continue;
            }
            if (i > 0 && !sb.isEmpty()) {
                sb.append(' ');
            }
            sb.append(word);
        }
        return new WordInProcess(sb, in.flags);
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
                    } else {
                        if (sb.length() - 1 > 0 && sb.charAt(sb.length() - 1) == ' ') {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                    }
                    i += word.length() - 1;
            }
        }
        int lastIndex = sb.length() - 1;
        if (lastIndex > 0 && sb.charAt(lastIndex) == ' ') {
            sb.deleteCharAt(lastIndex);
        }
        if (!sb.isEmpty()) {
            if (sb.charAt(0) == ' ') {
                sb.deleteCharAt(0);
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            if (i + 1 < sb.length()) {
                if (sb.charAt(i) == ' ' && sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.deleteCharAt(i);
                    i--;
                }
            }
        }

        if (sb.length() - 1 > 0) {
            if (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String input = in.nextLine();
        if (input.length() <= 200) {
            out.print(all(input));
        }

        out.flush();
    }
}
