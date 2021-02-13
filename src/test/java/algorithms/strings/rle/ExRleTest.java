package algorithms.strings.rle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExRleTest {
    @Test
    void rle() {
        assertEquals("AB2C3D4E5F6G7Z17", ExRle.rle("ABBCCCDDDDEEEEEFFFFFFGGGGGGGZZZZZZZZZZZZZZZZZ"));
        assertEquals("A", ExRle.rle("A"));
        assertEquals("A3", ExRle.rle("AAA"));
        assertThrows(IllegalArgumentException.class, () -> ExRle.rle(""), "Input string is empty");
    }
}