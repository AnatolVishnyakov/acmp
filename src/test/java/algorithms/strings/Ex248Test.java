package algorithms.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <b>Входные данные</b></br>
 * Во входном файле INPUT.TXT записана одна строка текста, состоящая не более чем из 200 символов:
 * <ul>
 *     <li>
 *         английских строчных и заглавных букв, пробелов и знаков препинания</br>
 *         (точка, запятая, вопросительный и восклицательный знаки, двоеточие, тире, точка с запятой,</br>
 *         открывающаяся и закрывающаяся скобки, апострофы, кавычки)
 *     </li>
 *     <li>Заглавные буквы могут встречаться только в начале слова.</li>
 *     <li>Нигде подряд не могут стоять два пробела.</li>
 *     <li>В начале и в конце строки не может стоять пробел.</li>
 *     <li>Слова отделяются друг от друга пробелами и/или знаками препинания.</li>
 * </ul>
 *
 * <b>Выходные данные</b></br>
 * В выходной файл OUTPUT.TXT нужно выдать преобразованную строку при ограничениях:
 * <ul>
 *     <li>
 *         начинаться с заглавной буквы должны те и только те слова,
 *         которые начинались с заглавной буквы в исходном тексте;
 *     </li>
 *     <li>не должно встречаться двух пробелов подряд;</li>
 *     <li>
 *         пробелы между словами и знаками препинания должны остаться там и только там,
 *         где они были в исходной строке, в начале и в конце строки пробелов быть не должно.
 *     </li>
 * </ul>
 */
class Ex248Test {

    /**
     * <b>Год 1: Замена буквы "c"</b>
     * <ul>
     *   <li>"ci" и "ce" → "si" и "se"</li>
     *   <li>"ck" → опускается</li>
     *   <li>в остальных случаях → "k"</li>
     * </ul>
     * Все замены производятся строго слева направо.
     * Например: "success" → "suksess", "cck" → "kk".
     */
    @Test
    void year1() {
        assertEquals("si", Ex248.year1("ci").get());
        assertEquals("Si", Ex248.year1("Ci").get());
        assertEquals("-si-", Ex248.year1("-ci-").get());
        assertEquals(" si ", Ex248.year1(" ci ").get());

        assertEquals("se", Ex248.year1("ce").get());
        assertEquals("Se", Ex248.year1("Ce").get());
        assertEquals("-se-", Ex248.year1("-ce-").get());
        assertEquals(" se ", Ex248.year1(" ce ").get());

        assertEquals("k", Ex248.year1("ck").get());
        assertEquals("K", Ex248.year1("Ck").get());
        assertEquals(" k ", Ex248.year1(" ck ").get());

        assertEquals("k", Ex248.year1("c").get());
        assertEquals("K", Ex248.year1("C").get());
        assertEquals(" k ", Ex248.year1(" c ").get());
        assertEquals("kk", Ex248.year1("cck").get());
        assertEquals("suksess", Ex248.year1("success").get());
        assertEquals("kksi", Ex248.year1("ccci").get());
        assertEquals("Kksi", Ex248.year1("Ccci").get());
        assertEquals("kkse", Ex248.year1("ccce").get());
        assertEquals("Kkse", Ex248.year1("Ccce").get());
        assertEquals("kkkkkk", Ex248.year1("cccccc").get());
        assertEquals("Kkkkkk", Ex248.year1("Cccccc").get());
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
//    @Test
//    void year2() {
//        assertEquals("i", Ex248.year2("ee").sb().toString());
//        assertEquals("u", Ex248.year2("oo").sb().toString());
//        assertEquals("u", Ex248.year2("uu").sb().toString());
//        assertEquals("v", Ex248.year2("vv").sb().toString());
//        assertEquals("Uo", Ex248.year2("Ooo").sb().toString());
//        assertEquals("A", Ex248.year2("Aaaa").sb().toString());
//        assertEquals("U", Ex248.year2("Oooo").sb().toString());
//        assertEquals("Ie", Ex248.year2("Eeeee").sb().toString());
//    }

    /**
     * <b>Год 3: Удаление "e" в конце слова</b><br>
     * Буква "e" опускается в конце слова, если она не единственная буква в слове.
     *
     */
//    @Test
//    void year3() {
//        assertEquals("ololosh", Ex248.year3(new Ex248.WordInProcess(new StringBuilder("ololoshe"), false, false)).sb().toString());
//        assertEquals("e", Ex248.year3(new Ex248.WordInProcess(new StringBuilder("e"), false, false)).sb().toString());
//        assertEquals("e ololo", Ex248.year3(new Ex248.WordInProcess(new StringBuilder("e ololo"), false, false)).sb().toString());
//        assertEquals("", Ex248.year3(new Ex248.WordInProcess(new StringBuilder(""), false, false)).sb().toString());
//        assertEquals("e", Ex248.year3(new Ex248.WordInProcess(new StringBuilder("e "), false, false)).sb().toString());
//        assertEquals("th", Ex248.year3(new Ex248.WordInProcess(new StringBuilder("the"), false, false)).sb().toString());
//    }

    /**
     * <b>Год 4: Удаление артиклей</b><br>
     * Удаляются артикли "a", "an" и "the", если они являются отдельными словами.
     * Например: "the table" → "tabl", "aaaaa" → "a" (остается, так как изначально не было артиклем).
     */
//    @Test
//    void year4() {
//        assertEquals("", Ex248.year4(new Ex248.WordInProcess(new StringBuilder("a"), false, false)).sb().toString());
//        assertEquals("''", Ex248.year4(new Ex248.WordInProcess(new StringBuilder("'A'"), false, false)).sb().toString());
//        assertEquals("table", Ex248.year4(new Ex248.WordInProcess(new StringBuilder("a table"), false, false)).sb().toString());
//        assertEquals("table", Ex248.year4(new Ex248.WordInProcess(new StringBuilder("table a"), false, false)).sb().toString());
//        assertEquals("", Ex248.year4(new Ex248.WordInProcess(new StringBuilder("an"), false, false)).sb().toString());
//        assertEquals("table", Ex248.year4(new Ex248.WordInProcess(new StringBuilder("an table"), false, false)).sb().toString());
//        assertEquals("table", Ex248.year4(new Ex248.WordInProcess(new StringBuilder("table an"), false, false)).sb().toString());
//        assertEquals("", Ex248.year4(new Ex248.WordInProcess(new StringBuilder("th"), true, true)).sb().toString());
//        assertEquals("table", Ex248.year4(new Ex248.WordInProcess(new StringBuilder("th table"), true, true)).sb().toString());
//        assertEquals("table", Ex248.year4(new Ex248.WordInProcess(new StringBuilder("table th"), true, true)).sb().toString());
//        assertEquals("", Ex248.year4(new Ex248.WordInProcess(new StringBuilder("th th th"), true, true)).sb().toString());
//        assertEquals("", Ex248.year4(new Ex248.WordInProcess(new StringBuilder("a a a"), false, false)).sb().toString());
//        assertEquals("", Ex248.year4(new Ex248.WordInProcess(new StringBuilder("an an an"), false, false)).sb().toString());
//        assertEquals("", Ex248.year4(new Ex248.WordInProcess(new StringBuilder("   "), false, false)).sb().toString());
//    }

    @Test
    void all() {
        assertEquals("A", Ex248.all("Aaaaaa"));
        assertEquals("kakao and kofi", Ex248.all("cacao and coffee"));
        assertEquals("Sinderela! Wher Is Dres???", Ex248.all("Cinderella! Where Is The Dress???"));
        assertEquals("'' is leter", Ex248.all("'A' is a letter"));
        assertEquals("sukses", Ex248.all("success"));
        assertEquals("", Ex248.all("A the an"));

        assertEquals("!!!Helo!!!--\"word\"", Ex248.all("!!!Hello!!!A-the-\"word\""));
        assertEquals("A then k", Ex248.all("Aaaa then the ckckck"));
        assertEquals("\"\"-", Ex248.all("\"A\"-the an"));
        assertEquals("Papa Keks", Ex248.all("Papa Ckeks"));
        assertEquals("Kakao And Kofi", Ex248.all("Cacao And Coffee"));

        assertEquals("'e'e'", Ex248.all("'e'e'"));
        assertEquals("\"e\"e\"", Ex248.all("\"e\"e\""));
        assertEquals("!e!e!", Ex248.all("!e!e!"));
        assertEquals(".e.e.", Ex248.all(".e.e."));
        assertEquals(",e,e,", Ex248.all(",e,e,"));

        assertEquals("", Ex248.all("the the the"));
        assertEquals("", Ex248.all("a a a"));
        assertEquals("", Ex248.all("an an an"));

        assertEquals("", Ex248.all("   "));
        assertEquals("' '", Ex248.all("'   '"));
        assertEquals("' '", Ex248.all("'  '"));

        assertEquals("ololoshka", Ex248.all(" ololoshka "));

        // Артикль в начале строки — после удаления пробел оказывается в начале
        assertEquals("kat", Ex248.all("a cat"));
        assertEquals("kat", Ex248.all("an cat"));
        assertEquals("kat", Ex248.all("the cat"));

        // Артикль в конце строки — после удаления пробел оказывается в конце
        assertEquals("kat", Ex248.all("cat a"));
        assertEquals("kat", Ex248.all("cat an"));
        assertEquals("kat", Ex248.all("cat the"));

        // Артикль в середине — после удаления образуется двойной пробел
        assertEquals("kat dog", Ex248.all("cat the dog"));
        assertEquals("kat dog", Ex248.all("cat a dog"));
        assertEquals("kat dog", Ex248.all("cat an dog"));

        // Несколько артиклей подряд (разделённые знаками препинания)
        assertEquals(",", Ex248.all("a,the"));
        assertEquals("-", Ex248.all("the-a"));
        assertEquals(".", Ex248.all("an.the"));
        assertEquals("!!", Ex248.all("!the!"));

        // Артикли со знаками препинания — знак препинания как разделитель слов
        assertEquals(",kat", Ex248.all("the,cat"));
        assertEquals("kat,", Ex248.all("cat,a"));
        assertEquals(",kat,", Ex248.all("a,cat,the"));

        // Все слова — артикли (результат пустой)
        assertEquals("", Ex248.all("a"));
        assertEquals("", Ex248.all("a the an"));
        assertEquals(",,", Ex248.all("a,the,an"));

        // Артикль между знаками препинания
        assertEquals("helo,,world", Ex248.all("hello,the,world"));
        assertEquals("helo--world", Ex248.all("hello-a-world"));

        // etc.
        assertEquals("an", Ex248.all("anne"));
        assertEquals("An", Ex248.all("Ann"));
    }

    @Test
    void foo() {
//        assertEquals("!helo , , , world!", Ex248.all("A !hello a, An, The, world! A"));
        assertEquals("x,y", Ex248.all("x a,y"));
        assertEquals("helo.", Ex248.all("hello the."));
        assertEquals("word!", Ex248.all("word a!"));
        assertEquals(",,", Ex248.all(", a,"));
        assertEquals("kat,dog", Ex248.all("cat the,dog"));

        assertEquals("an", Ex248.all("anne"));
        assertEquals("An", Ex248.all("Ann"));
        assertEquals("th", Ex248.all("th"));
        assertEquals("", Ex248.all(" "));
        assertEquals("th", Ex248.all("thh"));
        assertEquals("Th", Ex248.all("Thh"));
    }
}