package main.java.strings;

import java.io.PrintWriter;
import java.util.Scanner;

public class Ex164 {
    private static final Scanner in = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);

    private static final String ZERO = "0";
    private static final String EMPTY_PATTERN = "";

    private static final String YES = "YES";
    private static final String NO = "NO";

    private static int[] prepareNumber(String s){
        s = s.replaceAll(ZERO, EMPTY_PATTERN);
        int[] numbers = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            numbers[i] = Character.getNumericValue(s.charAt(i));
        }
        return numbers;
    }

    private static boolean isHappyTicket(String input) {
        int left = 0, right = 0;
        int[] numbers = prepareNumber(input);
        int N = numbers.length;
        for (int i = 0; i < N; i++) {
            if(left > 9 || right > 9){
                String buffer = String.valueOf(left);
                buffer += input.substring(i, N-i);
                buffer += String.valueOf(right);
                return isHappyTicket(buffer);
            }
            if(left == 0) {
                left += numbers[i];
                right += numbers[N - i - 1];
                continue;
            }
            if(left == right && i >= N / 2){
                return true;
            }
            if(left > right && left + numbers[i] < 10){
                right += numbers[N-i];
            } else if(left < right && right + numbers[N-i] < 10) {
                left += numbers[i];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String input = in.nextLine();
        if(isHappyTicket(input)){
            out.print(YES);
        } else {
            out.print(NO);
        }

        out.flush();
    }
}
