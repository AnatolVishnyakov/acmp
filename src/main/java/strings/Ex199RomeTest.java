package main.java.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Ex199RomeTest {
    @Test
    public void toArabicNumber() {
        assertEquals(1, Rome.toArabicNumber("I"));
        assertEquals(2, Rome.toArabicNumber("II"));
        assertEquals(3, Rome.toArabicNumber("III"));
        assertEquals(4, Rome.toArabicNumber("IV"));
        assertEquals(5, Rome.toArabicNumber("V"));
        assertEquals(6, Rome.toArabicNumber("VI"));
        assertEquals(7, Rome.toArabicNumber("VII"));
        assertEquals(8, Rome.toArabicNumber("VIII"));
        assertEquals(9, Rome.toArabicNumber("IX"));

        assertEquals(10, Rome.toArabicNumber("X"));
        assertEquals(11, Rome.toArabicNumber("XI"));
        assertEquals(12, Rome.toArabicNumber("XII"));
        assertEquals(13, Rome.toArabicNumber("XIII"));
        assertEquals(14, Rome.toArabicNumber("XIV"));
        assertEquals(15, Rome.toArabicNumber("XV"));
        assertEquals(16, Rome.toArabicNumber("XVI"));
        assertEquals(17, Rome.toArabicNumber("XVII"));
        assertEquals(18, Rome.toArabicNumber("XVIII"));
        assertEquals(19, Rome.toArabicNumber("XIX"));

        assertEquals(20, Rome.toArabicNumber("XX"));
        assertEquals(21, Rome.toArabicNumber("XXI"));
        assertEquals(22, Rome.toArabicNumber("XXII"));
        assertEquals(23, Rome.toArabicNumber("XXIII"));
        assertEquals(24, Rome.toArabicNumber("XXIV"));
        assertEquals(25, Rome.toArabicNumber("XXV"));

        assertEquals(18, Rome.toArabicNumber("XVIII"));
        assertEquals(31, Rome.toArabicNumber("XXXI"));
        assertEquals(46, Rome.toArabicNumber("XLVI"));
        assertEquals(50, Rome.toArabicNumber("L"));
        assertEquals(75, Rome.toArabicNumber("LXXV"));
        assertEquals(92, Rome.toArabicNumber("XCII"));
        assertEquals(99, Rome.toArabicNumber("IC"));
        assertEquals(100, Rome.toArabicNumber("C"));
        assertEquals(302, Rome.toArabicNumber("CCCII"));
        assertEquals(441, Rome.toArabicNumber("CDXLI"));
        assertEquals(499, Rome.toArabicNumber("ID"));
        assertEquals(500, Rome.toArabicNumber("D"));
        assertEquals(695, Rome.toArabicNumber("DCXCV"));
        assertEquals(900, Rome.toArabicNumber("CM"));
    }
}
