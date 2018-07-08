package main.java;

import java.io.PrintWriter;
import java.util.Scanner;

public class Ex80 {
    private static final Scanner in = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);

    private static final int NUMBER_OF_ARGUMENTS = 3;
    private static final int MAX_NUMBER = 30_000;
    private static final int MAX_STRING = 100;
    private static final String ERROR = "ERROR";
    private static final String YES = "YES";
    private static final String NO = "NO";

    enum Sign {
        MINUS('-'), PLUS('+'), MULTIPLY('*'), DIVIDE('/');

        final char _symbol;
        Sign(char symbol){
            this._symbol = symbol;
        }

        static boolean contains(char operationSymbol) {
            Sign[] signs = values();
            for (int i = 0; i < signs.length; i++) {
                if(signs[i]._symbol == operationSymbol){
                    return true;
                }
            }
            return false;
        }
    }

    private static boolean isNumber(char symbol) {
        return symbol >= '0' && symbol <= '9';
    }

    private static boolean isOperation(char operationSymbol) {
        return Sign.contains(operationSymbol);
    }

    public static String parse(String expression) {
        float firstArg = 0;
        float secondArg;
        float thirdArg = 0;
        float resultExpression = 0;

        try {
            if(!(expression.length() > MAX_STRING)){
                int indexString = 0;
                for (int i = 0; i < NUMBER_OF_ARGUMENTS; i++) {
                    switch (i){
                        // первое число (со знаком минус)
                        case 0: {
                            // начинается со знака минус
                            boolean isMinus = false;
                            if (expression.charAt(indexString) == '-') {
                                isMinus = true;
                                indexString++;
                            }
                            // является числом
                            if (!isNumber(expression.charAt(indexString))) {
                                return ERROR;
                            }

                            StringBuilder sb = isMinus
                                    ? new StringBuilder("-")
                                    : new StringBuilder();

                            for (; indexString < expression.length() && isNumber(expression.charAt(indexString)); indexString++) {
                                sb.append(expression.charAt(indexString));
                            }

                            if (sb.length() == 0 || sb.length() > 5) {
                                return ERROR;
                            }

                            int number = Integer.parseInt(sb.toString());
                            if (Math.abs(number) > MAX_NUMBER) {
                                return ERROR;
                            }
                            firstArg = number;
                            break;
                        }
                        case 1: {
                            char sign = expression.charAt(indexString++);
                            if (!isOperation(sign)) {
                                return ERROR;
                            }

                            boolean isMinus = false;
                            char symbol = expression.charAt(indexString);
                            while (isOperation(symbol)) {
                                symbol = expression.charAt(indexString++);
                                isMinus ^= (symbol == Sign.MINUS._symbol);
                            }

                            StringBuilder sb = isMinus
                                    ? new StringBuilder("-")
                                    : new StringBuilder();

                            if(isMinus){ indexString--; }
                            for (; indexString < expression.length() && isNumber(expression.charAt(indexString)); indexString++) {
                                sb.append(expression.charAt(indexString));
                            }

                            if (sb.length() == 0 || sb.length() > 5) {
                                return ERROR;
                            }

                            int number = Integer.parseInt(sb.toString());
                            if (Math.abs(number) > MAX_NUMBER) {
                                return ERROR;
                            }

                            secondArg = number;

                            switch (sign) {
                                case '+':
                                    resultExpression = firstArg + secondArg;
                                    break;
                                case '-':
                                    resultExpression = firstArg - secondArg;
                                    break;
                                case '*':
                                    resultExpression = firstArg * secondArg;
                                    break;
                                case '/':
                                    resultExpression = firstArg / secondArg;
                                    break;
                            }
                            break;
                        }
                        case 2: {
                            if (expression.charAt(indexString++) != '=') {
                                return ERROR;
                            }

                            // начинается со знака минус
                            boolean isMinus = false;
                            if (expression.charAt(indexString) == '-') {
                                isMinus = true;
                                indexString++;
                            }

                            if (!isNumber(expression.charAt(indexString))) {
                                return ERROR;
                            }

                            StringBuilder sb = isMinus
                                    ? new StringBuilder("-")
                                    : new StringBuilder();

                            for (; indexString < expression.length() && isNumber(expression.charAt(indexString)); indexString++) {
                                sb.append(expression.charAt(indexString));
                            }

                            if (sb.length() == 0 || indexString != expression.length() || sb.length() > 5) {
                                return ERROR;
                            }
                            int number = Integer.parseInt(sb.toString());
                            if (Math.abs(number) > MAX_NUMBER) {
                                return ERROR;
                            }
                            thirdArg = number;
                            break;
                        }
                        default:
                            return ERROR;
                    }
                }
            }
            return resultExpression == thirdArg
                    ? YES : NO;
        } catch (StringIndexOutOfBoundsException exc) {
            return ERROR;
        }
    }

    public static void main(String[] args) {
        String expression = in.nextLine();
        out.print(parse(expression));
        out.flush();
    }
}
