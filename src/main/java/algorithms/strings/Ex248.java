package algorithms.strings;

import java.io.PrintWriter;
import java.util.Scanner;

public class Ex248 {
    static String year1(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            var isUpper = Character.isUpperCase(c);
            if (c == 'c' || c == 'C') {
                if (i + 1 < s.length()) {
                    char next = s.charAt(i + 1);
                    if (next == 'i' || next == 'e') {
                        if (isUpper) sb.append('S'); else sb.append('s');
                    } else if (next == 'k') {
                        i++;
                    } else {
                        if (isUpper) sb.append('K'); else sb.append('k');
                    }
                } else {
                    if (isUpper) sb.append('K'); else sb.append('k');
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static String year2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && Character.isLetter(s.charAt(i)) && Character.isLetter(s.charAt(i + 1)) && s.charAt(i) == s.charAt(i + 1)) {
                var c = s.charAt(i);
                if (c == 'e') {
                    sb.append('i');
                } else if (c == 'o') {
                    sb.append('u');
                } else {
                    sb.append(c);
                }
                i++;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    static String year3(String s) {
        var words = s.split(" ");
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
        return sb.toString();
    }

    static String year4(String s) {
        var words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            var word = words[i].replace("'", "");
            if (word.equalsIgnoreCase("a") || word.equalsIgnoreCase("an") || word.equalsIgnoreCase("the")) {
                sb.append(words[i].replace(word, ""));
                continue;
            }
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(word);
        }
        return sb.toString();
    }

    static String all(String s) {
        return year4(year3(year2(year1(s))));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String input = in.next();
        if (input.length() < 200) {
            out.print(all(input));
        }

        out.flush();
    }
}
