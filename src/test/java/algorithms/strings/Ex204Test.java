package algorithms.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class Ex204Test {
    public static Iterable<Object[]> testDataSuccess() {
        return Arrays.asList(new Object[][]{
                {"a", 1},
                {"aaaaaaaaaaaa", 1},
                {"abababab", 2},
                {"abababa", 2},
                {"abc", 3},
                {"abca", 3},
                {"abcad", 4},
                {"BBBBaAAAAAAA", 3},
                {"abbebeeaokeb", 5},
//                {"deabc", 5},
//                {"bbbbbaaaaa", 10},
//                {"aaaaabaaaaa", 3},
//                {"bbebeeaokeba", 11},
//                {"babbebeeaoke", 1},
//                {"aAAa", 4},
//                {"babababa", 2},
        });
    }

    @ParameterizedTest(name = "[{index}]: {0} -> {1}")
    @MethodSource("testDataSuccess")
    public void testSuccess(String text, int expected) {
        Ex204.StringHandler handler = new Ex204.StringHandler(text);
        assertEquals(expected, handler.process());
    }

    public static Iterable<Object[]> testDataIsValid() {
        return Arrays.asList(new Object[][]{
                {"", false},
                {"AAAbbbb", true},
                {"AAAAффффф", false},
                {String.join("", Collections.nCopies(50_001, "A")), false},
                {String.join("", Collections.nCopies(50_000, "A")), true}
        });
    }

    @ParameterizedTest(name = "[{index}]: {0} -> {1}")
    @MethodSource("testDataIsValid")
    public void testIsValidString(String text, boolean expected) {
        Ex204.StringHandler handler = new Ex204.StringHandler(text);
        assertEquals(expected, handler.isValidString());
    }
}
