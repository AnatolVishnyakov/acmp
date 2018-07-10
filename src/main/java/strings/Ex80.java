package main.java.strings;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

// TODO вынести дублирующийся код
// TODO переработать цикл
// TODO разбить по методам операции получения чисел
public class Ex80 {
    private static final int NUMBER_OF_ARGUMENTS = 3;
    private static final int MAX_NUMBER = 30_000;
    private static final int MAX_STRING = 100;
    // output message
    private static final String ERROR = "ERROR";
    private static final String YES = "YES";
    private static final String NO = "NO";

    private static Integer indexString = 0;

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
        float secondArg = 0;
        float thirdArg = 0;
        float resultExpression = 0;

        try {
            if(!(expression.length() >= MAX_STRING)){
                StringBuilder sb;
                float number;
                boolean isMinus = false;
                for (int i = 0; i < NUMBER_OF_ARGUMENTS; i++) {
                    switch (i){
                        case 0:
                            if (expression.charAt(indexString) == '-') {
                                isMinus = true;
                                indexString++;
                            }

                            if (!isNumber(expression.charAt(indexString))) {
                                return ERROR;
                            }

                            sb = isMinus
                                ? new StringBuilder("-")
                                : new StringBuilder();

                            for (; indexString < expression.length() && isNumber(expression.charAt(indexString)); indexString++) {
                                sb.append(expression.charAt(indexString));
                            }

                            if (sb.length() == 0 || sb.length() > 5) {
                                return ERROR;
                            }

                            number = Float.parseFloat(sb.toString());
                            if (Math.abs(number) >= MAX_NUMBER) {
                                return ERROR;
                            }
                            firstArg = number;
                            break;

                        case 1:
                            char sign = expression.charAt(indexString++);
                            if (!isOperation(sign)) {
                                return ERROR;
                            }

                            isMinus = false;
                            char symbol = expression.charAt(indexString);
                            while (isOperation(symbol)) {
                                symbol = expression.charAt(indexString++);
                                isMinus ^= (symbol == Sign.MINUS._symbol);
                            }

                            sb = isMinus
                                ? new StringBuilder("-")
                                : new StringBuilder();

                            if(isMinus){ indexString--; }
                            for (; indexString < expression.length() && isNumber(expression.charAt(indexString)); indexString++) {
                                sb.append(expression.charAt(indexString));
                            }

                            if (sb.length() == 0 || sb.length() > 5) {
                                return ERROR;
                            }

                            number = Float.parseFloat(sb.toString());
                            if (Math.abs(number) >= MAX_NUMBER) {
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

                        case 2:
                            if (expression.charAt(indexString++) != '=') {
                                return ERROR;
                            }

                            isMinus = false;
                            if (expression.charAt(indexString) == '-') {
                                isMinus = true;
                                indexString++;
                            }

                            if (!isNumber(expression.charAt(indexString))) {
                                return ERROR;
                            }

                            sb = isMinus
                                    ? new StringBuilder("-")
                                    : new StringBuilder();

                            for (; indexString < expression.length() && isNumber(expression.charAt(indexString)); indexString++) {
                                sb.append(expression.charAt(indexString));
                            }

                            if (sb.length() == 0 || indexString != expression.length() || sb.length() > 5) {
                                return ERROR;
                            }

                            number = Float.parseFloat(sb.toString());
                            if (Math.abs(number) >= MAX_NUMBER) {
                                return ERROR;
                            }
                            thirdArg = number;
                            break;

                        default:
                            return ERROR;
                    }
                }
            }
            return resultExpression == thirdArg
                    ? YES : NO;

        } catch (Exception exc) {
            return ERROR;
        }
    }

    public static void main(String[] args) {
        Scanner in;
        PrintWriter out = null;

        try {
            in = new Scanner(new File("input.txt"));
            out = new PrintWriter(new File("output.txt"));

            String expression = in.nextLine();
            out.print(parse(expression));
            out.close();
        } catch (Exception ex) {
            assert out != null;
            out.print(ERROR);
            out.close();
        }
    }
}