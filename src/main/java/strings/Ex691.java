package main.java.strings;

import java.io.PrintWriter;
import java.util.Scanner;


public class Ex691 {
    private static Scanner in = new Scanner(System.in);
    private static PrintWriter out = new PrintWriter(System.out);
    private static final String ENG = "ABCEHKMOPTXY";
    private static final String RUS = "АВСЕНКМОРТХУ";

    private static boolean isValid(String regNum){
        if(regNum.length() == 6){
            char[] chars = regNum.toCharArray();
            for(int i = 0; i < chars.length; i++){
                String ch = String.valueOf(chars[i]);
                if(i == 0 || i == 4 || i == 5){
                    if(ENG.indexOf(ch) == -1 && RUS.indexOf(ch) == -1)
                        return false;
                } else if(i > 0 && i < 4) {
                    if(!(ch.toCharArray()[0] >= '0' && ch.toCharArray()[0] <= '9'))
                        return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int N = in.nextInt();
        for(int i = 0; i < N; i++){
            String regNum = in.next();
            if(isValid(regNum)){
                out.println("Yes");
            } else {
                out.println("No");
            }
        }
        out.flush();
    }
}
