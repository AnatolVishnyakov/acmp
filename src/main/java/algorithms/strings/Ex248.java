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
                case 'A':
                case 'a': {
                    if (i - 1 >= 0) {
                        if (isNotSymbol(getSymbol(sb, i - 1)) && isNotSymbol(getSymbol(sb, i + 1))) {
                            sb.deleteCharAt(i);
                            if (getSymbol(sb, i) == ' ') {
                                sb.deleteCharAt(i);
                            }
                            i--;
                        }
                        if (getSymbol(sb, i + 1) == 'n' && isNotSymbol(getSymbol(sb, i + 2))) {
                            sb.deleteCharAt(i);
                            sb.deleteCharAt(i);
                            i -= 2;
                        }
                    } else {
                        if (i + 1 < sb.length()) {
                            char nextChar = sb.charAt(i + 1);
                            if (nextChar == sb.charAt(i) || 'a' == nextChar) {
                                sb.deleteCharAt(i + 1);
                                i--;
                            }
//                            if (getSymbol(sb, i + 1) == ' ') {
//                                sb.deleteCharAt(i);
//                                i--;
//                            }
                        }
                    }
                    continue;
                }
                case 'C':
                case 'c': {
                    if (i + 1 < sb.length()) {
                        char nextChar = sb.charAt(i + 1);
                        if (nextChar == 'i' || nextChar == 'e') {
                            sb.setCharAt(i, getOrConvertCase(sb.charAt(i), 's'));
                            continue;
                        } else if (nextChar == 'k') {
                            sb.deleteCharAt(i);
                            i -= 2;
                            continue;
                        }
                    }
                    sb.setCharAt(i, getOrConvertCase(sb.charAt(i), 'k'));
                    continue;
                }
                case 'E':
                case 'e': {
                    if (i + 1 < sb.length()) {
                        char nextChar = sb.charAt(i + 1);
                        if (nextChar == 'e') {
                            sb.setCharAt(i, getOrConvertCase(sb.charAt(i), 'i'));
                            sb.deleteCharAt(i + 1);
                            i--;
                            continue;
                        }
                        if (nextChar == ' ') {
                            sb.deleteCharAt(i);
                            i--;
                            continue;
                        }
                        continue;
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(i);
                        i--;
                    }
                    continue;
                }
                case 'O':
                case 'o': {
                    if (i + 1 < sb.length()) {
                        char nextChar = sb.charAt(i + 1);
                        if (nextChar == 'o') {
                            sb.setCharAt(i, getOrConvertCase(sb.charAt(i), 'u'));
                            sb.deleteCharAt(i + 1);
                            i--;
                            continue;
                        }
                    }
                }
                case 'T':
                case 't': {
                    if ((getSymbol(sb, i + 1) == 'h' && isNotSymbol(getSymbol(sb, i + 2)))) {
                        sb.deleteCharAt(i);
                        sb.deleteCharAt(i);
                        if (getSymbol(sb, i) == ' ') {
                            sb.deleteCharAt(i);
                        }
                        i--;
                        continue;
                    }
                    if (getSymbol(sb, i + 1) == 'h' && getSymbol(sb, i + 2) == 'e' && isNotSymbol(getSymbol(sb, i + 3))) {
                        sb.deleteCharAt(i);
                        sb.deleteCharAt(i);
                        sb.deleteCharAt(i);
                        if (getSymbol(sb, i) == ' ') {
                            sb.deleteCharAt(i);
                        }
                        i--;
                        continue;
                    }
                }
                default:
                    if (!(sb.charAt(i) >= 'a' && sb.charAt(i) <= 'z') && !(sb.charAt(i) >= 'A' && sb.charAt(i) <= 'Z')) {
                        continue;
                    }
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

    private static char getOrConvertCase(char current, char ch) {
        if (current >= 'A' && current <= 'Z') {
            int ind = ch - 'a';
            return (char) ('A' + ind);
        }
        return ch;
    }

    private static char getSymbol(StringBuilder sb, int index) {
        if (index >= sb.length()) {
            return '0';
        }
        return sb.charAt(index);
    }

    private static boolean isNotSymbol(char c) {
        return !(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z');
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        out.print(doEuroEnglish(in.next()));

        out.flush();
    }
}
