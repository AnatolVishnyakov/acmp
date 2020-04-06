package algorithms.strings;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex236 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String polynomial =
//                "-2+2-3*4+4+100*8-2*x"
                "-2+x^1-3*x^2+x^2+100*x^3-2*x";
//                in.nextLine();
        int x = 0;
//                in.nextInt();

        if (x <= 100 && polynomial.length() <= 80) {
            // -2+x^1-3*x^2+x^2+100*x^3-2*x
            polynomial = polynomial.replace("x", String.valueOf(x));

            Pattern pattern = Pattern.compile("\\d\\^(?<k>\\d)");
            Matcher matcher = pattern.matcher(polynomial);
            while (matcher.find()) {
                String group = matcher.group();
                int k = Integer.parseInt(matcher.group("k"));
                double pow = Math.pow(x, k);
                polynomial = polynomial.replace(group, String.valueOf((int) pow));
            }
            System.out.println(polynomial);

            pattern = Pattern.compile("(?<a>\\d)\\*(?<b>\\d)");
            matcher = pattern.matcher(polynomial);
            while (matcher.find()) {
                String group = matcher.group();
                int a = Integer.parseInt(matcher.group("a"));
                int b = Integer.parseInt(matcher.group("b"));
                int result = a * b;
                polynomial = polynomial.replace(group, String.valueOf(result));
            }
            System.out.println(polynomial);

            pattern = Pattern.compile("(?<number>(-)?\\d+)");
            matcher = pattern.matcher(polynomial);
            int result = 0;
            while (matcher.find()) {
                result += Integer.parseInt(matcher.group("number"));
            }
            out.println(result);
        }

        out.flush();
    }
}
