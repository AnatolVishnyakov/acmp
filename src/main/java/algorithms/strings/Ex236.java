package algorithms.strings;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex236 {
    static class EquationSolver {
        private String polynomial;
        private final int x;

        public EquationSolver(String polynomial, int x) {
            this.polynomial = polynomial;
            this.x = x;
        }

        public boolean isValid() {
            return x <= 100 && polynomial.length() <= 80;
        }

        public String pow() {
            Pattern pattern = Pattern.compile("(?<x>\\d+)\\^(?<k>\\d+)");
            Matcher matcher = pattern.matcher(polynomial);
            while (matcher.find()) {
                String group = matcher.group();
                int k = Integer.parseInt(matcher.group("k"));
                int x = Integer.parseInt(matcher.group("x"));
//                double pow = Math.pow(x, k);
                for (int i = 0; i < k; i++) {
                    x *= x;
                }
                polynomial = polynomial.replace(group, String.valueOf(x));
            }
            return polynomial;
        }

        public String multiply() {
            Pattern pattern = Pattern.compile("(?<a>\\d+)\\*(?<b>\\d+)");
            Matcher matcher = pattern.matcher(polynomial);
            while (matcher.find()) {
                String group = matcher.group();
                int a = Integer.parseInt(matcher.group("a"));
                int b = Integer.parseInt(matcher.group("b"));
                int result = a * b;
                polynomial = polynomial.replace(group, String.valueOf(result));
            }
            return polynomial;
        }

        private int sum() {
            Pattern pattern = Pattern.compile("(?<number>(-)?\\d+)");
            Matcher matcher = pattern.matcher(polynomial);
            int result = 0;
            while (matcher.find()) {
                result += Integer.parseInt(matcher.group("number"));
            }
            return result;
        }

        private int calculate() {
            polynomial = polynomial.replace("x", String.valueOf(x));
            polynomial = pow();
            polynomial = multiply();
            return sum();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String polynomial = in.nextLine();
        int x = in.nextInt();

        EquationSolver equationSolver = new EquationSolver(polynomial, x);
        if (equationSolver.isValid()) {
            int result = equationSolver.calculate();
            out.println(result);
        }

        out.flush();
    }
}
