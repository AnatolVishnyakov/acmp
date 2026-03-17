package algorithms.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <p>
 * Европейская комиссия планирует принять решение о том, что официальным языком Евросоюза станет английский.
 * Был также разработан план упрощения английской письменности, который планируется реализовать за четыре года.
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
class Ex248Test {

    @Test
    void year1() {
        assertEquals("s", Ex248.replaceFor1Year("ci"));
        assertEquals("s", Ex248.replaceFor1Year("ce"));
        assertEquals("", Ex248.replaceFor1Year("ck"));
        assertEquals("k", Ex248.replaceFor1Year("c"));
    }
}