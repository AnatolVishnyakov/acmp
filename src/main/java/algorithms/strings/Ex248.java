package algorithms.strings;

import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;

public class Ex248 {
    static String year1(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'c') {
                if (i + 1 < s.length()) {
                    char next = s.charAt(i + 1);
                    if (next == 'i' || next == 'e') {
                        sb.append('s');
                        i++;
                    } else if (next == 'k') {
                        i++;
                    } else {
                        sb.append('k');
                    }
                } else {
                    sb.append('k');
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
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (c == 'e') {
                var prev = i - 1;
                if (prev >= 0 && s.charAt(prev) != ' ') {
                    i++;
                    continue;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == ' ') {
                    i++;
                    continue;
                }
                sb.append(c);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static String year4(String s) {
        var words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            var word = words[i];
            if (Objects.equals(word, "a") || Objects.equals(word, "an") || Objects.equals(word, "the")) {
                continue;
            }
            sb.append(word);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String input = in.next();
        out.print(
                year4(year3(year2(year1(input))))
        );

        out.flush();
    }
}
