package test.java.binarysearch;


import main.java.binarysearch.Ex267;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Ex267Test {
    @Test
    public void run() {
        // 0
        assertEquals(0, Ex267.run(0, 0, 0));

        // 1
        assertEquals(1, Ex267.run(1, 0, 1));
        assertEquals(1, Ex267.run(1, 1, 0));
        assertEquals(1, Ex267.run(1, 1, 1));

        // 2
        assertEquals(2, Ex267.run(2, 1, 0));
        assertEquals(2, Ex267.run(2, 0, 1));

        // 4
        assertEquals(4, Ex267.run(2, 0, 2));
    }
}
