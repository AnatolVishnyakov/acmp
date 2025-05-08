package algorithms.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Ex248Test {

    // Первоочередной задачей будет избавление от буквы c,
    // которая в сочетаниях сi и сe будет изменяться на s,
    // в сочетании ck — опускаться, а в остальных случаях заменяться на k.
    // При этом все замены будут производиться в строгом порядке слева направо.
    // То есть, например, в слове success сначала первая из двух букв c заменится на k,
    // а затем вторая — на s, то есть получится suksess. А слово cck превратится в kk.
    @ParameterizedTest
    @CsvSource(
            value = {
                    "ci:si",
                    "ce:se",
                    "ck:k",
                    "c:k",
                    "cck:kk",
                    "success:sukses",
            },
            delimiter = ':')
    void correct01(String input, String expected) {
        Assertions.assertEquals(expected, Ex248.doEuroEnglish(input));
    }

    // На второй год из английских слов изымут все удвоенные буквы: ee изменят на i, oo - на u,
    // a в остальных комбинациях будут просто писать одну букву вместо двух одинаковых.
    // Такие замены также будут делать строго в порядке слева направо.
    // Так, слово ooo превратится в uo, а oou — просто в u (в нем сначала oo заменится на u, а затем uu — на u),
    // слово iee превратится в i (в нем сначала ee заменится на i, а затем ii — на i).
    @ParameterizedTest
    @CsvSource(
            value = {
                    "ee:i",
                    "oo:u",
                    "ooo:uo",
                    "oou:u",
                    "eea:ia",
            },
            delimiter = ':')
    void correct021(String input, String expected) {
        Assertions.assertEquals(expected, Ex248.doEuroEnglish(input));
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "aa:a",
                    "bb:b",
                    "dd:d",
                    "ff:f",
                    "gg:g",
                    "hh:h",
                    "ii:i",
                    "jj:j",
                    "kk:k",
                    "ll:l",
                    "mm:m",
                    "nn:n",
                    "pp:p",
                    "qq:q",
                    "rr:r",
                    "ss:s",
                    "tt:t",
                    "uu:u",
                    "vv:v",
                    "ww:w",
                    "xx:x",
                    "yy:y",
                    "zz:z",
            },
            delimiter = ':')
    void correct022(String input, String expected) {
        Assertions.assertEquals(expected, Ex248.doEuroEnglish(input));
    }
}