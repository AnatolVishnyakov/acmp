package test.java.binarysearch;


import main.java.binarysearch.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void run() {
        // 0
        assertEquals(0, Main.run(0, 0, 0));

        // 1
        assertEquals(1, Main.run(1, 0, 1));
        assertEquals(1, Main.run(1, 1, 0));
        assertEquals(1, Main.run(1, 1, 1));

        // 2
        assertEquals(2, Main.run(2, 1, 0));
        assertEquals(2, Main.run(2, 0, 1));

        // 4
        assertEquals(19, Main.run(8, 8, 3));
//        assertEquals(8, Main.run(6, 2, 2));
    }
}
