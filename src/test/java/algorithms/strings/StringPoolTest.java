package algorithms.strings;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("String Pool эксперименты")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StringPoolTest {
    // -XX:+PrintFlagsFinal
    // -XX:+PrintStringTableStatistics

    @Test
    @Order(1)
    @DisplayName("[Не равны] Два одинаковых строковых объекта")
    public void testB() {
        assertNotSame(new String("one"), new String("one"));
    }

    @Test
    @Order(2)
    @DisplayName("[Не равны] Строка и объект строка")
    public void testC() {
        assertNotSame("one", new String("one"));
    }

    @Test
    @Order(3)
    @DisplayName("[Не равны] Интернированная строка и объект строка")
    public void testE() {
        assertNotSame("one".intern(), new String("one"));
    }

    @Test
    @Order(4)
    @DisplayName("[Не равны] Строка и конкатенированная объект строка")
    public void testI(){
        assertNotSame("one", "o" + new String("ne"));
    }

    @Test
    @DisplayName("[Равны] Две одинаковые строки")
    public void testA() {
        assertSame("one", "one");
    }

    @Test
    @DisplayName("[Равны] Интернированная строка и строка")
    public void testD() {
        assertSame("one".intern(), "one");
    }

    @Test
    @DisplayName("[Равны] Интернированная строка и интернированная строка")
    public void testF() {
        assertSame("one".intern(), "one".intern());
    }

    @Test
    @DisplayName("[Равны] Интернированная строка и интернированная объект строка")
    public void testG() {
        assertSame("one".intern(), new String("one").intern());
    }

    @Test
    @DisplayName("[Равны] Строка и конкатенированная строка")
    public void testH() {
        assertSame("one", "o" + "n" + "e");
    }
}
