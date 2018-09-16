package main.java.strings;

import java.io.File;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Work on 15.10.2017.
 */
public class Ex641 {
    private static String deleteSymbol(String number){
        BigInteger maxArrya = null;
        String result = null;

        for(int i = number.length()-1; i >= 0; i--){
            String buffer = new StringBuilder(number).deleteCharAt(i).toString().trim();
            BigInteger value = new BigInteger(buffer);
            if(maxArrya == null){
                maxArrya = value;
                result = buffer;
            } else if(value.compareTo(maxArrya) > 0) {
                maxArrya = value;
                result = buffer;
            }
        }
        return result;
    }

    public static String getHappyTicket(String number){
        String maxNumber = deleteSymbol(deleteSymbol(number));
        return (maxNumber.length() != 0)
            ? maxNumber : null;
    }

    private static boolean isValid(String number) {
        if(number.length() == 250){
            for (int i = 0; i < number.length(); i++) {
                if(!(i == 0 && number.charAt(i) == '1') ||
                    !(i > 0 && number.charAt(i) == '0')){
                    return false;
                }
            }
        }
        return number.length() >= 3 && number.length() < 250;
    }

    public static void main(String[] args) {
        Scanner in;
        PrintWriter out = null;

        try {
            in = new Scanner(new File("input.txt"));
            out = new PrintWriter(new File("output.txt"));

            String number = in.nextLine().trim();
            if(isValid(number)){
                String maxNumber = getHappyTicket(number);
                if(maxNumber != null){
                    out.print(maxNumber.replaceFirst("^0+(?!$)", "").trim());
                }
            }
            out.close();
        } catch (Exception ex) {
            assert out != null;
            out.print("");
            out.close();
        }
    }
}
