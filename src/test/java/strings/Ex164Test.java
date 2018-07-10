package test.java.strings;

import main.java.strings.Ex164;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ex164Test {

    private boolean callMethodIsHappyTicket(String inStr) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Ex164.class.getDeclaredMethod("isHappyTicket", String.class);
        method.setAccessible(true);
        return (boolean) method.invoke(Ex164.class, inStr);
    }

    @Test
    public void testIsHappyTicket() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Assert.assertTrue(callMethodIsHappyTicket("0015420"));
        Assert.assertTrue(callMethodIsHappyTicket("15420"));
        Assert.assertTrue(callMethodIsHappyTicket("162510021"));
        Assert.assertTrue(callMethodIsHappyTicket("911"));

        Assert.assertFalse(callMethodIsHappyTicket("00100"));
    }
}
