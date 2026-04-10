package algorithms.strings;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.EnumSet;

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
    @ParameterizedTest
    @CsvSource(
            value = {
                    "ci -> si",
                    "Ci -> Si",
                    "-ci- -> -si-",
                    " ci  ->  si ",
                    "ce -> se",
                    "Ce -> Se",
                    "-ce- -> -se-",
                    " ce  ->  se ",
                    "ck -> k",
                    "Ck -> K",
                    " ck  ->  k ",
                    "c -> k",
                    "C -> K",
                    " c  ->  k ",
                    "cck -> kk",
                    "success -> suksess",
                    "ccci -> kksi",
                    "Ccci -> Kksi",
                    "ccce -> kkse",
                    "Ccce -> Kkse",
                    "cccccc -> kkkkkk",
                    "Cccccc -> Kkkkkk",

                    "ca -> ka",
                    "co -> ko",
                    "cu -> ku",
                    "cat -> kat",
                    "car -> kar",
                    "cup -> kup",

                    "ace -> ase",
                    "ice -> ise",
                    "race -> rase",
                    "peace -> pease",
                    "dance -> danse",

                    "cc -> kk",
                    "Cc -> Kk",
                    "ccc -> kkk",
                    "cci -> ksi",
                    "Cci -> Ksi",
                    "cce -> kse",

                    "ckck -> kk",
                    "ckc -> kk",
                    "cka -> ka",
                    "cke -> ke",
                    "cki -> ki",
                    "ack -> ak",
                    "ick -> ik",
                    "back -> bak",
                    "kick -> kik",
                    "clock -> klok",
                    "Clock -> Klok",

                    "cacao -> kakao",
                    "coca -> koka",
                    "circle -> sirkle",
                    "Circle -> Sirkle",
                    "accept -> aksept",
                    "accuse -> akkuse",
                    "soccer -> sokser",
                    "occur -> okkur",

                    "hello -> hello",
                    "world -> world",
                    "a -> a",

                    "cece -> sese",
                    "Cece -> Sese",
                    "cici -> sisi",
                    "ckce -> kse",
                    "ceck -> sek",
                    "' ' -> ''",
                    "'' -> ''",
            },
            delimiterString = "->"
    )
    void year1(String in, String expectedResult) {
        String actualResult = Ex248.year1(in).get();
        assertEquals(expectedResult, actualResult);
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
    @ParameterizedTest
    @CsvSource(
            value = {
// Базовые удвоения ee и oo
                    "ee -> i",
                    "oo -> u",
                    "Ee -> I",
                    "Oo -> U",

                    // Остальные удвоения → одна буква
                    "aa -> a",
                    "bb -> b",
                    "cc -> c",
                    "dd -> d",
                    "ff -> f",
                    "gg -> g",
                    "hh -> h",
                    "ii -> i",
                    "ll -> l",
                    "mm -> m",
                    "nn -> n",
                    "pp -> p",
                    "rr -> r",
                    "ss -> s",
                    "tt -> t",
                    "uu -> u",
                    "vv -> v",
                    "zz -> z",

                    // Заглавные
                    "Aa -> A",
                    "Bb -> B",
                    "Ll -> L",
                    "Ss -> S",

                    // Тройные (слева направо)
                    "ooo -> uo",
                    "eee -> ie",
                    "aaa -> a",
                    "lll -> l",
                    "sss -> s",

                    // Четверные и более
                    "Aaaa -> A",
                    "Oooo -> U",
                    "Eeeee -> Ie",
                    "oooo -> u",
                    "eeee -> i",
                    "aaaaa -> a",
                    "llll -> l",

                    // Цепочки из условия
                    "oou -> u",
                    "iee -> i",
                    "eei -> i",
                    "ooi -> ui",
                    "uoo -> u",

                    // Смешанные удвоения
                    "aabb -> ab",
                    "eeff -> if",
                    "ooll -> ul",
                    "llss -> ls",
                    "sstt -> st",

                    // Слова
                    "hello -> helo",
                    "book -> buk",
                    "look -> luk",
                    "feel -> fil",
                    "good -> gud",
                    "food -> fud",
                    "room -> rum",
                    "tree -> tri",
                    "free -> fri",
                    "green -> grin",
                    "sleep -> slip",
                    "keep -> kip",
                    "need -> nid",
                    "speed -> spid",
                    "football -> futbal",
                    "balloon -> balun",

                    // Без удвоений (не меняется)
                    "abc -> abc",
                    "test -> test",
                    "word -> word",
                    "a -> a",

                    // Несколько пар в слове
                    "beekeeper -> bikiper",
                    "roommate -> rumate",

                    // Пустая строка
                    "' '->' '",
            },
            delimiterString = "->"
    )
    void year2(String in, String expectedResult) {
        StringBuilder sb = new StringBuilder(in);
        EnumSet<Ex248.WordFlag> flags = EnumSet.noneOf(Ex248.WordFlag.class);

        Ex248.WordInProcess wordInProcess = new Ex248.WordInProcess(sb, flags);
        var actualResult = Ex248.year2(wordInProcess).get();

        assertEquals(expectedResult, actualResult);
    }

    /**
     * <b>Год 3: Удаление "e" в конце слова</b><br>
     * Буква "e" опускается в конце слова, если она не единственная буква в слове.
     *
     */
    @ParameterizedTest
    @CsvSource(
            value = {
                    // Базовые случаи — удаление e в конце
                    "ololoshe -> ololosh",
                    "the -> th",
                    "table -> tabl",
                    "name -> nam",
                    "home -> hom",
                    "time -> tim",
                    "made -> mad",
                    "take -> tak",
                    "come -> com",
                    "give -> giv",
                    "live -> liv",

                    // Заглавные в начале
                    "The -> Th",
                    "Table -> Tabl",
                    "Name -> Nam",
                    "Home -> Hom",

                    // e — единственная буква (НЕ удаляется)
                    "e -> e",
                    "E -> E",

                    // Не заканчивается на e (не меняется)
                    "cat -> cat",
                    "dog -> dog",
                    "th -> th",
                    "an -> an",
                    "word -> word",
                    "test -> test",

                    // Несколько слов
                    "e ololo -> e ololo",
                    "the cat -> th cat",
                    "table name -> tabl nam",
                    "give me -> giv m",
                    "home alone -> hom alon",
                    "e e e -> e e e",
                    "the the the -> th th th",

                    // Короткие слова с e
                    "me -> m",
                    "we -> w",
                    "he -> h",
                    "be -> b",
                    "re -> r",
                    "Me -> M",
                    "We -> W",

                    // Пустая строка и пробелы
                    "''->''",
                    "e  -> e",
                    "'  ' -> ''",

                    // Слова без букв (только e в конце после преобразований)
                    "ee -> e",

                    // Двойное e в конце (но это уже после year2, так что маловероятно)
                    "ilee -> ile",

                    // Смешанные случаи
                    "a e i -> a e i",
                    "the a an -> th a an",
                    "cake pie -> cak pi",
            },
            delimiterString = "->"
    )
    void year3(String in, String expectedResult) {
        StringBuilder sb = new StringBuilder(in);
        EnumSet<Ex248.WordFlag> flags = EnumSet.noneOf(Ex248.WordFlag.class);

        Ex248.WordInProcess wordInProcess = new Ex248.WordInProcess(sb, flags);
        var actualResult = Ex248.year3(wordInProcess).get();

        assertEquals(expectedResult, actualResult);
    }

    /**
     * <b>Год 4: Удаление артиклей</b><br>
     * Удаляются артикли "a", "an" и "the", если они являются отдельными словами.
     * Например: "the table" → "tabl", "aaaaa" → "a" (остается, так как изначально не было артиклем).
     */
    @ParameterizedTest
    @CsvSource(
            value = {
                    "a -> '' -> false",
                    "A -> '' -> false",
                    "a a a -> '' -> false",
                    "A a a -> '' -> false",
                    "a table -> table -> false",
                    "table a -> table -> false",
                    "an -> '' -> false",
                    "An -> '' -> false",
                    "an an an -> '' -> false",
                    "An an an -> '' -> false",
                    "an table -> table -> false",
                    "table an -> table -> false",
                    "th -> '' -> true",
                    "Th -> '' -> true",
                    "th th th -> '' -> true",
                    "Th th th -> '' -> true",
                    "th table -> table -> true",
                    "table th -> table -> true",
                    "'     ' -> '' -> false",
            },
            delimiterString = "->"
    )
    void year4(String in, String expectedResult, boolean changed) {
        StringBuilder sb = new StringBuilder(in);
        EnumSet<Ex248.WordFlag> flags = changed
                ? EnumSet.of(Ex248.WordFlag.REMOVED_E)
                : EnumSet.noneOf(Ex248.WordFlag.class);

        Ex248.WordInProcess wordInProcess = new Ex248.WordInProcess(sb, flags);
        var actualResult = Ex248.year4(wordInProcess).get();

        assertEquals(expectedResult, actualResult);
    }

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