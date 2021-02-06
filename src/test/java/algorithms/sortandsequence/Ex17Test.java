package algorithms.sortandsequence;

import org.junit.jupiter.api.Test;

import static algorithms.sortandsequence.Ex17.findMinCountSegment;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex17Test {
    @Test
    public void testFindMinCountSegment() {
        assertEquals(6, findMinCountSegment(new int[]{5, 3, 1, 3, 5, 2, 5, 3, 1, 3, 5, 2, 5}));
        assertEquals(1, findMinCountSegment(new int[]{1, 1, 1, 1}));
        assertEquals(3, findMinCountSegment(new int[]{1, 2, 3, 1}));
        assertEquals(3, findMinCountSegment(new int[]{4, 1, 1, 2, 1}));
    }
}