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
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            String res = textReformat(new StringBuilder(word));
            if (res != null && !res.isEmpty() && !res.equals(" ")) {
                sb.append(res);
                sb.append(" ");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        if (sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }

    private static String textReformat(StringBuilder word) {
        String w = word.toString();
        if (w.equalsIgnoreCase("a") ||
                w.equalsIgnoreCase("an") ||
                w.equalsIgnoreCase("the")
        ) {
            return null;
        }
        for (int i = 0; i < word.length(); i++) {
            switch (word.charAt(i)) {
                case 'A':
                case 'a': {
                    if (i - 1 >= 0) {
                        if (isNotSymbol(getSymbol(word, i - 1)) && isNotSymbol(getSymbol(word, i + 1))) {
                            word.deleteCharAt(i);
                            if (getSymbol(word, i) == ' ') {
                                word.deleteCharAt(i);
                            }
                            i--;
                        }
                        if (getSymbol(word, i + 1) == 'n' && isNotSymbol(getSymbol(word, i + 2))) {
                            word.deleteCharAt(i);
                            word.deleteCharAt(i);
                            i -= 2;
                        }
                    } else {
                        if (i + 1 < word.length()) {
                            char nextChar = word.charAt(i + 1);
                            if (nextChar == word.charAt(i) || 'a' == nextChar) {
                                word.deleteCharAt(i + 1);
                                i--;
                            }
                        }
                    }
                    continue;
                }
                case 'C':
                case 'c': {
                    if (i + 1 < word.length()) {
                        char nextChar = word.charAt(i + 1);
                        if (nextChar == 'i' || nextChar == 'e') {
                            word.setCharAt(i, getOrConvertCase(word.charAt(i), 's'));
                            continue;
                        } else if (nextChar == 'k') {
                            word.deleteCharAt(i);
                            i--;
                            continue;
                        }
                    }
                    word.setCharAt(i, getOrConvertCase(word.charAt(i), 'k'));
                    continue;
                }
                case 'E':
                case 'e': {
                    if (i + 1 < word.length()) {
                        char nextChar = word.charAt(i + 1);
                        if (nextChar == 'e') {
                            word.setCharAt(i, getOrConvertCase(word.charAt(i), 'i'));
                            word.deleteCharAt(i + 1);
                            i--;
                            continue;
                        }
                        if (nextChar == ' ') {
                            word.deleteCharAt(i);
                            i--;
                            continue;
                        }
                        continue;
                    }
                    if (word.length() > 1) {
                        word.deleteCharAt(i);
                        i--;
                    }
                    continue;
                }
                case 'O':
                case 'o': {
                    if (i + 1 < word.length()) {
                        char nextChar = word.charAt(i + 1);
                        if (nextChar == 'o') {
                            word.setCharAt(i, getOrConvertCase(word.charAt(i), 'u'));
                            word.deleteCharAt(i + 1);
                            i--;
                            continue;
                        }
                    }
                }
                case 'T':
                case 't': {
                    if ((getSymbol(word, i + 1) == 'h' && isNotSymbol(getSymbol(word, i + 2)))) {
                        word.deleteCharAt(i);
                        word.deleteCharAt(i);
                        if (getSymbol(word, i) == ' ') {
                            word.deleteCharAt(i);
                        }
                        i--;
                        continue;
                    }
                    if (getSymbol(word, i + 1) == 'h' && getSymbol(word, i + 2) == 'e' && isNotSymbol(getSymbol(word, i + 3))) {
                        word.deleteCharAt(i);
                        word.deleteCharAt(i);
                        word.deleteCharAt(i);
                        if (getSymbol(word, i) == ' ') {
                            word.deleteCharAt(i);
                        }
                        i--;
                        continue;
                    }
                }
                default:
                    if (!(word.charAt(i) >= 'a' && word.charAt(i) <= 'z') && !(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')) {
                        continue;
                    }
                    if (i + 1 < word.length()) {
                        char nextChar = word.charAt(i + 1);
                        if (nextChar == word.charAt(i)) {
                            word.deleteCharAt(i);
                            i--;
                        }
                    }
            }
        }
        return word.toString();
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
