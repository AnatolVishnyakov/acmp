package algorithms.strings;

import org.junit.jupiter.api.Test;

import static algorithms.strings.Ex847.isAnagram;
import static org.junit.jupiter.api.Assertions.*;

class Ex847Test {
    @Test
    public void correct() {
        assertTrue(isAnagram("post", "stop"));
        assertTrue(isAnagram("anna", "anna"));
        assertTrue(isAnagram("aaa", "aaa"));
    }

    @Test
    public void incorrect() {
        assertFalse(isAnagram("post", "pots"));
        assertFalse(isAnagram("aabb", "aabb"));
        assertFalse(isAnagram("abcd", "efgh"));
        assertFalse(isAnagram("abc", "ab"));
        assertFalse(isAnagram("Abc", "cbA"));
        assertFalse(isAnagram("abcdjfkskfkdkdkdkdkd", "abcdjfkskfkdkdkdkdkd"));
        assertFalse(isAnagram("", ""));
    }
}