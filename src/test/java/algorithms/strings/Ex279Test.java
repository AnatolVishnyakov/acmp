package algorithms.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Ex279Test {
    private Ex279 ex279 = new Ex279();

    @ParameterizedTest
    @CsvSource(
            value = {
                    "{)):-1",
                    "(]]:-1",
                    "(((((:-1"
            },
            delimiter = ':'
    )
    void incorrect(String input, int expected) {
        Assertions.assertEquals(expected, ex279.check(input));
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    ":0",
                    "[]:0",
                    "():0",
                    "(())[]:0",
                    "[]():0",
                    "[()]:0",
                    "[][][][][][]:0",
                    "()()()()()():0",

                    "((]]]:-1",
                    "(]:1",
                    "[):1",

                    "[(]):2",
                    "([)]:2",
            },
            delimiter = ':'
    )
    void correct(String input, int expected) {
        Assertions.assertEquals(expected, ex279.check(input));
    }


}