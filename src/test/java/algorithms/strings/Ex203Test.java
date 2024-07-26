package algorithms.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex203Test {
    private Ex203.ShiftIdentifier shiftIdentifier = new Ex203.ShiftIdentifier();

    public static Iterable<Object[]> testDataSuccess() {
        return Arrays.asList(new Object[][]{
                {"a", "a", 0},
                {"aaaaaaaaaaaa", "aaaaaaaaaaaa", 0},
                {"BBBBaAAAAAAA", "BBBBaAAAAAAA", 0},
                {"abbebeeaokeb", "abbebeeaokeb", 0},
                {"abcde", "deabc", 2},
                {"aaaaabbbbb", "bbbbbaaaaa", 5},
                {"aaaaaaaaaab", "aaaaabaaaaa", 6},
                {"abbebeeaokeb", "bbebeeaokeba", 11},
                {"abbebeeaokeb", "babbebeeaoke", 1},
                {"AaaA", "aAAa", 2},
                {"abababab", "babababa", 1}
        });
    }

    @ParameterizedTest(name = "[{index}]: {0} -> {1} = {2}")
    @MethodSource("testDataSuccess")
    public void testSuccess(String pattern, String text, int expected) {
        assertEquals(expected, shiftIdentifier.shelfRight(pattern, text));
    }

    public static Iterable<Object[]> testDataFailed() {
        return Arrays.asList(new Object[][]{
                {"a", "b", -1},
                {"abc", "bcd", -1},
                {"aa", "ab", -1},
                {"zxcvzxcvza", "zxcvzxcvaz", -1}
        });
    }

    @ParameterizedTest(name = "[{index}]: {0} -> {1} = {2}")
    @MethodSource("testDataFailed")
    public void testNegative(String pattern, String text, int expected) {
        assertEquals(expected, shiftIdentifier.shelfRight(pattern, text));
    }

    public static Iterable<Object[]> testDataIsValid() {
        return Arrays.asList(new Object[][]{
                {"", "", false},
                {"aa", "abc", false},
                {"abc", "bcd", true},
                {"", "abc", false},
                {"abc123", "abc123", false}
        });
    }

    @ParameterizedTest(name = "[{index}]: {0} -> {1} = {2}")
    @MethodSource("testDataIsValid")
    public void isValid(String pattern, String text, boolean expected) {
        assertEquals(expected, shiftIdentifier.isValid(text, pattern));
    }
}
