package test.java.strings;

import main.java.strings.Ex164;
import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.InvocationTargetException;


public class Ex164Test {

    @Test
    public void testIsHappyTicket() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Assert.assertTrue(Ex164.isHappyTicket("0015420"));
        Assert.assertTrue(Ex164.isHappyTicket("15420"));
        Assert.assertTrue(Ex164.isHappyTicket("162510021"));
        Assert.assertTrue(Ex164.isHappyTicket("911"));
        Assert.assertTrue(Ex164.isHappyTicket("119"));
        Assert.assertTrue(Ex164.isHappyTicket("11111111111"));

//        Assert.assertFalse(callMethodIsHappyTicket("00100"));
    }
}
