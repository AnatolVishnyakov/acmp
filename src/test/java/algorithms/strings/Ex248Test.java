package algorithms.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex248Test {

    /**
     * <b>Год 1: Замена буквы "c"</b>
     * <ul>
     *   <li>"ci" и "ce" → "s"</li>
     *   <li>"ck" → опускается</li>
     *   <li>в остальных случаях → "k"</li>
     * </ul>
     * Все замены производятся строго слева направо.
     * Например: "success" → "suksess", "cck" → "kk".
     */
    @Test
    void year1() {
        assertEquals("si", Ex248.year1("ci"));
        assertEquals("se", Ex248.year1("ce"));
        assertEquals("", Ex248.year1("ck"));
        assertEquals("k", Ex248.year1("c"));
        assertEquals("kk", Ex248.year1("cck"));
        assertEquals("suksess", Ex248.year1("success"));
    }

    /**
     * <b>Год 2: Удаление удвоенных букв</b>
     * <ul>
     *   <li>"ee" → "i"</li>
     *   <li>"oo" → "u"</li>
     *   <li>остальные удвоенные → одна буква</li>
     * </ul>
     * Замены выполняются строго слева направо.
     * Например: "ooo" → "uo", "oou" → "u", "iee" → "i".
     */
    @Test
    void year2() {
        assertEquals("i", Ex248.year2("ee"));
        assertEquals("u", Ex248.year2("oo"));
        assertEquals("u", Ex248.year2("uu"));
        assertEquals("v", Ex248.year2("vv"));
    }

    /**
     * <b>Год 3: Удаление "e" в конце слова</b><br>
     * Буква "e" опускается в конце слова, если она не единственная буква в слове.
     *
     */
    @Test
    void year3() {
        assertEquals("ololosh", Ex248.year3("ololoshe"));
        assertEquals("e", Ex248.year3("e"));
        assertEquals("e ololo", Ex248.year3("e ololo"));
        assertEquals("", Ex248.year3(""));
        assertEquals("e", Ex248.year3("e "));
    }

    /**
     * <b>Год 4: Удаление артиклей</b><br>
     * Удаляются артикли "a", "an" и "the", если они являются отдельными словами.
     * Например: "the table" → "tabl", "aaaaa" → "a" (остается, так как изначально не было артиклем).
     */
    @Test
    void year4() {
        assertEquals("", Ex248.year4("a"));
        assertEquals("", Ex248.year4("an"));
        assertEquals("", Ex248.year4("the"));
        assertEquals("table", Ex248.year4("the table"));
    }

    @Test
    void all() {
        assertEquals("kakao and kofi", Ex248.all("cacao and coffee"));
        assertEquals("Sinderela! Wher Is Dres???", Ex248.all("Cinderella! Where Is The Dress???"));
//        assertEquals("'' is leter", Ex248.all("'A' is a letter"));
//        assertEquals("!!!Helo!!!--\"word\"", Ex248.all("!!!Hello!!!A-the-\"word\""));
//        assertEquals("A then k", Ex248.all("Aaaa then the ckckck"));
//        assertEquals("\"\"-", Ex248.all("\"A\"-the an"));
        assertEquals("", Ex248.all("A the an"));
        assertEquals("sukses", Ex248.all("success"));
    }
}