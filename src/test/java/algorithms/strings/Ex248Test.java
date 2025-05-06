package algorithms.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class Ex248Test {

    @ParameterizedTest
    @CsvSource(
            value = {
//                    "cacao and coffee:kakao and kofi"
                    "ci:s",
                    "ce:s",
                    "ck:''",
                    "c:k",
                    "cck:kk",
                    "success:suksess",
            },
            delimiter = ':')
    void correct(String input, String expected) {
        Assertions.assertEquals(expected, Ex248.doEuroEnglish(input));
    }
}