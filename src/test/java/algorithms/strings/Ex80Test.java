package test.java.strings;

import main.java.strings.Ex80;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex80Test {
    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final String ERROR = "ERROR";

    @Test
    public void testEqualsTrue(){
        // Число | операция (более 1 раза) | число | знак равенства (более одного раза) | число
        // (один знак минус) Число | операция (более 1 раза) | число | знак равенства (более одного раза) | число
        assertEquals(YES, Ex80.parse("2+3=5"));
        assertEquals(YES, Ex80.parse("3*7=21"));
        assertEquals(YES, Ex80.parse("2-1=1"));
        assertEquals(YES, Ex80.parse("4/2=2"));

        assertEquals(YES, Ex80.parse("-2+-2=-4"));
        assertEquals(YES, Ex80.parse("-2*-2=4"));
        assertEquals(YES, Ex80.parse("-2/-2=1"));
        assertEquals(YES, Ex80.parse("-2--2=0"));

        assertEquals(YES, Ex80.parse("-0+1=1"));
        assertEquals(YES, Ex80.parse("-01+1=0"));
        assertEquals(YES, Ex80.parse("-01*1=-1"));
        assertEquals(YES, Ex80.parse("-01/1=-1"));
        assertEquals(YES, Ex80.parse("-01-1=-2"));

        assertEquals(YES, Ex80.parse("-5+-7=-12"));
        assertEquals(YES, Ex80.parse("04+04=08"));
        assertEquals(YES, Ex80.parse("-3-2=-5"));
        assertEquals(YES, Ex80.parse("3*-5=-15"));
        assertEquals(YES, Ex80.parse("4*-0=0"));
        assertEquals(YES, Ex80.parse("-0*2=0"));
        assertEquals(YES, Ex80.parse("-12--7=-5"));
        assertEquals(YES, Ex80.parse("2*-5=-10"));

        String firstNumber = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000001";
        String secondNumber = "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000001";
        String thirdNumber = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000002";
        assertEquals(YES, Ex80.parse(firstNumber + "+" + secondNumber + "=" + thirdNumber));
    }

    @Test
    public void testEqualsFalse(){
        assertEquals(NO, Ex80.parse("-5--7=-12"));
        assertEquals(NO, Ex80.parse("6/5=1"));
        assertEquals(NO, Ex80.parse("123+-3=126"));
        assertEquals(NO, Ex80.parse("123/0=1"));
        assertEquals(NO, Ex80.parse("0/0=0"));
        assertEquals(NO, Ex80.parse("-4875*-998=-3742"));
        assertEquals(NO, Ex80.parse("23*7=421"));
    }

    @Test
    public void testEqualsError(){
        assertEquals(ERROR, Ex80.parse("+2+3=5"));
        assertEquals(ERROR, Ex80.parse("*2+3=5"));
        assertEquals(ERROR, Ex80.parse("/2+3=5"));
        assertEquals(ERROR, Ex80.parse("-/2+3=5"));
        assertEquals(ERROR, Ex80.parse("2 + 3 = 5"));
        assertEquals(ERROR, Ex80.parse("4+4 = 8"));
        assertEquals(ERROR, Ex80.parse("4+4=8.0"));
        assertEquals(ERROR, Ex80.parse("-1-1=-1-1"));
        assertEquals(ERROR, Ex80.parse("132+3="));
        assertEquals(ERROR, Ex80.parse("1-1-1=2"));
        assertEquals(ERROR, Ex80.parse("+3f+3+sg=3"));
        assertEquals(ERROR, Ex80.parse("3/2+3/2=3"));
        assertEquals(ERROR, Ex80.parse("2=3-1"));
        assertEquals(ERROR, Ex80.parse("1+3=2+2"));
        assertEquals(ERROR, Ex80.parse("1+1+1+1+1+1+1+1+1+1=10"));
        assertEquals(ERROR, Ex80.parse("(2*2)=4"));
        assertEquals(ERROR, Ex80.parse("10^2+10^2=200"));
        assertEquals(ERROR, Ex80.parse("2+3*7=23"));
        assertEquals(ERROR, Ex80.parse("2*=3"));
        assertEquals(ERROR, Ex80.parse("173"));
        assertEquals(ERROR, Ex80.parse("2+2=a"));
        assertEquals(ERROR, Ex80.parse("--2-2=0"));
        assertEquals(ERROR, Ex80.parse("two plus three is five"));
        assertEquals(ERROR, Ex80.parse("2+3="));
        assertEquals(ERROR, Ex80.parse("2+3"));
        assertEquals(ERROR, Ex80.parse("2+"));
        assertEquals(ERROR, Ex80.parse("-2"));
        assertEquals(ERROR, Ex80.parse("-2--1= "));
        assertEquals(ERROR, Ex80.parse("9999999999+9999999999=9999999999"));
        assertEquals(ERROR, Ex80.parse("-999999999999999999999999999"));
        assertEquals(ERROR, Ex80.parse("-999999999999999999999999999+1===============================999999"));
        assertEquals(ERROR, Ex80.parse("2=2"));
    }
}
