package algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Ex199Test {

    @Test
    public void toArabicNumber() {
        assertEquals(1, Ex199.toArabicNumber("I"));
        assertEquals(2, Ex199.toArabicNumber("II"));
        assertEquals(3, Ex199.toArabicNumber("III"));
        assertEquals(4, Ex199.toArabicNumber("IV"));
        assertEquals(5, Ex199.toArabicNumber("V"));
        assertEquals(6, Ex199.toArabicNumber("VI"));
        assertEquals(7, Ex199.toArabicNumber("VII"));
        assertEquals(8, Ex199.toArabicNumber("VIII"));
        assertEquals(9, Ex199.toArabicNumber("IX"));

        assertEquals(10, Ex199.toArabicNumber("X"));
        assertEquals(11, Ex199.toArabicNumber("XI"));
        assertEquals(12, Ex199.toArabicNumber("XII"));
        assertEquals(13, Ex199.toArabicNumber("XIII"));
        assertEquals(14, Ex199.toArabicNumber("XIV"));
        assertEquals(15, Ex199.toArabicNumber("XV"));
        assertEquals(16, Ex199.toArabicNumber("XVI"));
        assertEquals(17, Ex199.toArabicNumber("XVII"));
        assertEquals(18, Ex199.toArabicNumber("XVIII"));
        assertEquals(19, Ex199.toArabicNumber("XIX"));

        assertEquals(20, Ex199.toArabicNumber("XX"));
        assertEquals(21, Ex199.toArabicNumber("XXI"));
        assertEquals(22, Ex199.toArabicNumber("XXII"));
        assertEquals(23, Ex199.toArabicNumber("XXIII"));
        assertEquals(24, Ex199.toArabicNumber("XXIV"));
        assertEquals(25, Ex199.toArabicNumber("XXV"));

        assertEquals(18, Ex199.toArabicNumber("XVIII"));
        assertEquals(31, Ex199.toArabicNumber("XXXI"));
        assertEquals(46, Ex199.toArabicNumber("XLVI"));
        assertEquals(50, Ex199.toArabicNumber("L"));
        assertEquals(75, Ex199.toArabicNumber("LXXV"));
        assertEquals(92, Ex199.toArabicNumber("XCII"));
        assertEquals(99, Ex199.toArabicNumber("IC"));
        assertEquals(100, Ex199.toArabicNumber("C"));
        assertEquals(302, Ex199.toArabicNumber("CCCII"));
        assertEquals(441, Ex199.toArabicNumber("CDXLI"));
        assertEquals(499, Ex199.toArabicNumber("ID"));
        assertEquals(500, Ex199.toArabicNumber("D"));
        assertEquals(695, Ex199.toArabicNumber("DCXCV"));
        assertEquals(900, Ex199.toArabicNumber("CM"));
        assertEquals(999, Ex199.toArabicNumber("IM"));
        assertEquals(1000, Ex199.toArabicNumber("M"));
    }

    @Test
    public void toRomeNumber() {
        assertEquals("I", Ex199.toRomeNumber(1));
        assertEquals("II", Ex199.toRomeNumber(2));
        assertEquals("III", Ex199.toRomeNumber(3));
        assertEquals("IV", Ex199.toRomeNumber(4));
        assertEquals("V", Ex199.toRomeNumber(5));
        assertEquals("VI", Ex199.toRomeNumber(6));
        assertEquals("VII", Ex199.toRomeNumber(7));
        assertEquals("VIII", Ex199.toRomeNumber(8));
        assertEquals("IX", Ex199.toRomeNumber(9));

        assertEquals("X", Ex199.toRomeNumber(10));
        assertEquals("XI", Ex199.toRomeNumber(11));
        assertEquals("XII", Ex199.toRomeNumber(12));
        assertEquals("XIII", Ex199.toRomeNumber(13));
        assertEquals("XIV", Ex199.toRomeNumber(14));
        assertEquals("XV", Ex199.toRomeNumber(15));
        assertEquals("XVI", Ex199.toRomeNumber(16));
        assertEquals("XVII", Ex199.toRomeNumber(17));
        assertEquals("XVIII", Ex199.toRomeNumber(18));
        assertEquals("XIX", Ex199.toRomeNumber(19));

        assertEquals("XX", Ex199.toRomeNumber(20));
        assertEquals("XXI", Ex199.toRomeNumber(21));
        assertEquals("XXII", Ex199.toRomeNumber(22));
        assertEquals("XXIII", Ex199.toRomeNumber(23));
        assertEquals("XXIV", Ex199.toRomeNumber(24));
        assertEquals("XXV", Ex199.toRomeNumber(25));

        assertEquals("XVIII", Ex199.toRomeNumber(18));
        assertEquals("XXXI", Ex199.toRomeNumber(31));
        assertEquals("XLVI", Ex199.toRomeNumber(46));
        assertEquals("L", Ex199.toRomeNumber(50));
        assertEquals("LXXV", Ex199.toRomeNumber(75));
        assertEquals("XCII", Ex199.toRomeNumber(92));
        assertEquals("IC", Ex199.toRomeNumber(99));
        assertEquals("C", Ex199.toRomeNumber(100));
        assertEquals("CCCII", Ex199.toRomeNumber(302));
        assertEquals("CDXLI", Ex199.toRomeNumber(441));
        assertEquals("ID", Ex199.toRomeNumber(499));
        assertEquals("D", Ex199.toRomeNumber(500));
        assertEquals("DCXCV", Ex199.toRomeNumber(695));
        assertEquals("CM", Ex199.toRomeNumber(900));
        assertEquals("M", Ex199.toRomeNumber(1000));
    }

    @Test
    public void reduceFraction() {
        assertEquals("I/II", Ex199.reduceFraction("II/IV"));
        assertEquals("III", Ex199.reduceFraction("XXIV/VIII"));
        assertEquals("ERROR", Ex199.reduceFraction("12/16"));
    }
}
