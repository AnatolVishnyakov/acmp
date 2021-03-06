package main.java.strings;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Ex93 {
    private static final Scanner in = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);

    private static List<String> readNames() {
        int count = in.nextInt();
        List<String> dictionary = new ArrayList<>();
        do {
            String input = in.nextLine();
            if(input.length() > 0){
                dictionary.add(input);
            }
        } while(count-- != 0);

        return dictionary;
    }

    private static boolean compare(char[] correct, char[] incorrect) {
        // отработает один раз вхолостую
        boolean flag = false;
        for (int i = 0; i < correct.length; i++) {
            if(correct[i] != incorrect[i]){
                if(flag){
                    return false;
                }
                flag = true;
            }
        }
        return flag;
    }

    private static boolean isEmpty(StringBuilder stringBuilder){
        return stringBuilder.length() == 0;
    }

    private static String matcherDictionary(List<String> dictCorrect, List<String> dictIncorrect) {
        int count = 0;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < dictCorrect.size(); i++, count = 0) {
            String correctElement = dictCorrect.get(i);
            for (int j = 0; j < dictIncorrect.size(); j++) {
                String incorrectElement = dictIncorrect.get(j);

                if(correctElement.length() == incorrectElement.length()){
                    if(compare(correctElement.toCharArray(), incorrectElement.toCharArray())){
                        count++;
                    }
                }
            }
            if(!isEmpty(output)){
                output.append(" ");
            }
            output.append(count);
        }

        return output.toString();
    }

    public static void main(String[] args) {
        List<String> dictCorrect = readNames();
        List<String> dictIncorrect = readNames();

        String result = matcherDictionary(dictCorrect, dictIncorrect);
        out.print(result);
        out.flush();
    }
}
