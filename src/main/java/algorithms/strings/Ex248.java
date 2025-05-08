package algorithms.strings;

//Напишите программу, которая будет переводить классический английский текст на Eвроинглиш.

// Входные данные
//
// Во входном файле INPUT.TXT записана одна строка текста,
// состоящая не более чем из 200 символов: английских строчных и заглавных букв,
// пробелов и знаков препинания (в тексте могут встречаться: точка, запятая,
// вопросительный и восклицательный знаки, двоеточие, тире, точка с запятой,
// открывающаяся и закрывающаяся скобки, апострофы, кавычки). Заглавные буквы могут
// встречаться только в начале слова. Нигде подряд не могут стоять два пробела.
// В начале и в конце строки не может стоять пробел. Слова отделяются друг от друга
// пробелами и/или знаками препинания.

import java.io.PrintWriter;
import java.util.Scanner;

// Выходные данные
//
// В выходной файл OUTPUT.TXT нужно выдать преобразованную строку при ограничениях:
//
//    начинаться с заглавной буквы должны те и только те слова, которые начинались с заглавной буквы в исходном тексте;
//    не должно встречаться двух пробелов подряд;
//    пробелы между словами и знаками препинания должны остаться там и только там, где они были в исходной строке, в начале и в конце строки пробелов быть не должно.
public class Ex248 {

    public static String doEuroEnglish(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            switch (sb.charAt(i)) {
                case 'C':
                case 'c': {
                    if (i + 1 < sb.length()) {
                        char nextChar = sb.charAt(i + 1);
                        if (nextChar == 'i' || nextChar == 'e') {
                            sb.setCharAt(i, (char) getCorrectCase(sb.charAt(i), i));
                            continue;
                        } else if (nextChar == 'k') {
                            sb.deleteCharAt(i);
                            continue;
                        }
                    }
                    sb.setCharAt(i, 'k');
                    continue;
                }
                case 'e': {
                    if (i + 1 < sb.length()) {
                        char nextChar = sb.charAt(i + 1);
                        if (nextChar == 'e') {
                            sb.setCharAt(i, 'i');
                            sb.deleteCharAt(i + 1);
                            i--;
                            continue;
                        }
                        if (nextChar == ' ') {
                            sb.deleteCharAt(i);
                            continue;
                        }
                        continue;
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(i);
                    }
                    continue;
                }
                case 'o': {
                    if (i + 1 < sb.length()) {
                        char nextChar = sb.charAt(i + 1);
                        if (nextChar == 'o') {
                            sb.setCharAt(i, 'u');
                            sb.deleteCharAt(i + 1);
                            i--;
                            continue;
                        }
                    }
                }
                default:
                    if (i + 1 < sb.length()) {
                        char nextChar = sb.charAt(i + 1);
                        if (nextChar == sb.charAt(i)) {
                            sb.deleteCharAt(i);
                            i--;
                        }
                    }
            }
        }
        return sb.toString();
    }

    private static int getCorrectCase(char symb, int i) {
        return (int) symb + ((int) 's' - (int) 'a') - 2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        out.print(doEuroEnglish(in.next()));

        out.flush();
    }
}
