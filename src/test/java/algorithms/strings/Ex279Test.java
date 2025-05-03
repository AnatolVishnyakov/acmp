package algorithms.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class Ex279Test {
    private Ex279 ex279 = new Ex279();

    @ParameterizedTest
    @ValueSource(strings = {
            "",
            "[]",
            "()",
            "[]()",
            "[()]",
            "[][][][][][]",
            "()()()()()()",
            "(]",
            "[)",
            "([)]"
    })
    void correct(String input) {
//        Assertions.assertTrue(ex279.check(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "{))",
            "(]]"
    })
    void incorrect(String input) {
//        Assertions.assertFalse(ex279.check(input));
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "(())[]:0",
                    "[(]):2",
                    "((]]]:-1",
                    ":0",
                    "[]:0",
                    "():0",
                    "[]():0",
                    "[()]:0",
                    "[][][][][][]:0",
                    "()()()()()():0",
                    "(]:1",
                    "[):1",
                    "([)]:2",
            },
            delimiter = ':'
    )
    void correct(String input, int expected) {
        Assertions.assertEquals(expected, ex279.check(input));
    }


}