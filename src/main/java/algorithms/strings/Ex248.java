package algorithms.strings;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * <p>
 * <b>Год 1: Замена буквы "c"</b>
 * <ul>
 *   <li>"ci" и "ce" → "s"</li>
 *   <li>"ck" → опускается</li>
 *   <li>в остальных случаях → "k"</li>
 * </ul>
 * Все замены производятся строго слева направо.
 * Например: "success" → "suksess", "cck" → "kk".
 * <p>
 * <b>Год 2: Удаление удвоенных букв</b>
 * <ul>
 *   <li>"ee" → "i"</li>
 *   <li>"oo" → "u"</li>
 *   <li>остальные удвоенные → одна буква</li>
 * </ul>
 * Замены выполняются строго слева направо.
 * Например: "ooo" → "uo", "oou" → "u", "iee" → "i".
 * <p>
 * <b>Год 3: Удаление "e" в конце слова</b><br>
 * Буква "e" опускается в конце слова, если она не единственная буква в слове.
 * <p>
 * <b>Год 4: Удаление артиклей</b><br>
 * Удаляются артикли "a", "an" и "the", если они являются отдельными словами.
 * Например: "the table" → "tabl", "aaaaa" → "a" (остается, так как изначально не было артиклем).
 */
public class Ex248 {
    static String replaceFor1Year(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            var firstSymbolMatch = getSymbByPos(s, i) == 'c';
            var secondSymbolMatch = getSymbByPos(s, i + 1) == 'i' ||
                                    getSymbByPos(s, i + 1) == 'e';
            if (firstSymbolMatch && secondSymbolMatch) {
                sb.append('s');
                i++;
            } else if (firstSymbolMatch && getSymbByPos(s, i + 1) == 'k') {
                i++;
            } else {
                sb.append('k');
            }
        }
        return sb.toString();
    }

    private static char getSymbByPos(String s, int i) {
        if (s.length() <= i) {
            return '0';
        }
        return s.charAt(i);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String input = in.next();
        out.print(replaceFor1Year(input));

        out.flush();
    }
}
