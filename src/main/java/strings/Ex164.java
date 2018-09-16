package main.java.strings;

import java.io.PrintWriter;
import java.util.Scanner;

class Ticket {
    private static String sum(String number, int indexElementA, int indexElementB){
        int a = Character.getNumericValue(number.charAt(indexElementA));
        int b = Character.getNumericValue(number.charAt(indexElementB));
        return String.valueOf(a + b);
    }

    private static String sumLeft(String number) {
        return sum(number, 0, 1) + number.substring(2, number.length());
    }

    private static String sumRight(String number) {
        int indexElementA = number.length() - 1;
        int indexElementB = indexElementA - 1;
        return number.substring(0, indexElementB) + sum(number, indexElementA, indexElementB);
    }

    private static boolean check(String number) {
        if(number.length() == 1 || number.length() == 0){
            return false;
        }
        if(number.length() == 2){
            // итого: осталось два элемента
            return number.charAt(0) == number.charAt(1);
        }

        if(check(sumRight(new String(number)))){
            return true;
        }
        if(check(sumLeft(new String(number)))){
            return true;
        }
        return false;
    }

    public static boolean isHappy(String number) {
        return check(number);
    }
}

public class Ex164 {
    private static final Scanner in = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static boolean isHappyTicket(String number){
        return Ticket.isHappy(number);
    }

    public static boolean isValid(String number){
        return number.length() >= 1 && number.length() <= 100;
    }

    public static void main(String[] args) {
        String input = in.nextLine().replaceAll("0", "");
        if (isValid(input) && isHappyTicket(input)) {
            out.print(YES);
        } else {
            out.print(NO);
        }

        out.flush();
    }
}
