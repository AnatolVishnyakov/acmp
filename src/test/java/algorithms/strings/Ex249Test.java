package algorithms.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex249Test {
    @Test
    void countNumberBrackets() {
        assertEquals(2, Ex249.countNumberBrackets("{(})"));
        assertEquals(0, Ex249.countNumberBrackets("([{}])"));
        assertEquals(0, Ex249.countNumberBrackets("((())(()))"));

        assertEquals(2, Ex249.countNumberBrackets("][]["));
        assertEquals(2, Ex249.countNumberBrackets("([[[)]]]"));
    }
}