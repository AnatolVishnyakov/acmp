package algorithms.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Ex248Test {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "ci:si",
                    "ce:se",
                    "ck:k",
                    "c:k",
                    "cck:kk",
                    "success:suksess",
            },
            delimiter = ':')
    void correct(String input, String expected) {
        Assertions.assertEquals(expected, Ex248.doEuroEnglish(input));
    }
}