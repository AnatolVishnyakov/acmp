package test.java;

import main.java.Ex80;
import org.junit.Assert;
import org.junit.Test;

public class Ex80Test {
    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final String ERROR = "ERROR";

    @Test
    public void testEqualsTrue(){
        // Число | операция (более 1 раза) | число | знак равенства (более одного раза) | число
        // (один знак минус) Число | операция (более 1 раза) | число | знак равенства (более одного раза) | число
        Assert.assertEquals(YES, Ex80.parse("2+3=5"));
        Assert.assertEquals(YES, Ex80.parse("3*7=21"));
        Assert.assertEquals(YES, Ex80.parse("2-1=1"));
        Assert.assertEquals(YES, Ex80.parse("4/2=2"));

        Assert.assertEquals(YES, Ex80.parse("-2+-2=-4"));
        Assert.assertEquals(YES, Ex80.parse("-2*-2=4"));
        Assert.assertEquals(YES, Ex80.parse("-2/-2=1"));
        Assert.assertEquals(YES, Ex80.parse("-2--2=0"));

        Assert.assertEquals(YES, Ex80.parse("-0+1=1"));
        Assert.assertEquals(YES, Ex80.parse("-01+1=0"));
        Assert.assertEquals(YES, Ex80.parse("-01*1=-1"));
        Assert.assertEquals(YES, Ex80.parse("-01/1=-1"));
        Assert.assertEquals(YES, Ex80.parse("-01-1=-2"));

        Assert.assertEquals(YES, Ex80.parse("-5+-7=-12"));
        Assert.assertEquals(YES, Ex80.parse("04+04=08"));
        Assert.assertEquals(YES, Ex80.parse("-3-2=-5"));
        Assert.assertEquals(YES, Ex80.parse("3*-5=-15"));
        Assert.assertEquals(YES, Ex80.parse("4*-0=0"));
        Assert.assertEquals(YES, Ex80.parse("-0*2=0"));
        Assert.assertEquals(YES, Ex80.parse("-12--7=-5"));
        Assert.assertEquals(YES, Ex80.parse("2*-5=-10"));
    }

    @Test
    public void testEqualsFalse(){
        Assert.assertEquals(NO, Ex80.parse("-5--7=-12"));
        Assert.assertEquals(NO, Ex80.parse("6/5=1"));
        Assert.assertEquals(NO, Ex80.parse("123+-3=126"));
        Assert.assertEquals(NO, Ex80.parse("123/0=1"));
        Assert.assertEquals(NO, Ex80.parse("0/0=0"));
        Assert.assertEquals(NO, Ex80.parse("-4875*-998=-3742"));
        Assert.assertEquals(NO, Ex80.parse("23*7=421"));
    }

    @Test
    public void testEqualsError(){
        Assert.assertEquals(ERROR, Ex80.parse("+2+3=5"));
        Assert.assertEquals(ERROR, Ex80.parse("*2+3=5"));
        Assert.assertEquals(ERROR, Ex80.parse("/2+3=5"));
        Assert.assertEquals(ERROR, Ex80.parse("-/2+3=5"));
        Assert.assertEquals(ERROR, Ex80.parse("2 + 3 = 5"));
        Assert.assertEquals(ERROR, Ex80.parse("4+4 = 8"));
        Assert.assertEquals(ERROR, Ex80.parse("4+4=8.0"));
        Assert.assertEquals(ERROR, Ex80.parse("-1-1=-1-1"));
        Assert.assertEquals(ERROR, Ex80.parse("132+3="));
        Assert.assertEquals(ERROR, Ex80.parse("1-1-1=2"));
        Assert.assertEquals(ERROR, Ex80.parse("+3f+3+sg=3"));
        Assert.assertEquals(ERROR, Ex80.parse("3/2+3/2=3"));
        Assert.assertEquals(ERROR, Ex80.parse("2=3-1"));
        Assert.assertEquals(ERROR, Ex80.parse("1+3=2+2"));
        Assert.assertEquals(ERROR, Ex80.parse("1+1+1+1+1+1+1+1+1+1=10"));
        Assert.assertEquals(ERROR, Ex80.parse("(2*2)=4"));
        Assert.assertEquals(ERROR, Ex80.parse("10^2+10^2=200"));
        Assert.assertEquals(ERROR, Ex80.parse("2+3*7=23"));
        Assert.assertEquals(ERROR, Ex80.parse("2*=3"));
        Assert.assertEquals(ERROR, Ex80.parse("173"));
        Assert.assertEquals(ERROR, Ex80.parse("2+2=a"));
        Assert.assertEquals(ERROR, Ex80.parse("--2-2=0"));
        Assert.assertEquals(ERROR, Ex80.parse("two plus three is five"));
        Assert.assertEquals(ERROR, Ex80.parse("2+3="));
        Assert.assertEquals(ERROR, Ex80.parse("2+3"));
        Assert.assertEquals(ERROR, Ex80.parse("2+"));
        Assert.assertEquals(ERROR, Ex80.parse("-2"));
        Assert.assertEquals(ERROR, Ex80.parse("-2--1= "));
        Assert.assertEquals(ERROR, Ex80.parse("9999999999+9999999999=9999999999"));
        Assert.assertEquals(ERROR, Ex80.parse("-999999999999999999999999999"));
    }
}
