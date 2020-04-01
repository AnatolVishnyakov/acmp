package test.java.strings;

import main.java.strings.Ex204;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ex204Test {
    private Method method;

    public Ex204Test() throws NoSuchMethodException {
        method = Ex204.class.getDeclaredMethod("getMinimalSubString", String.class);
        method.setAccessible(true);
    }

    @Test
    public void testSuccess() throws InvocationTargetException, IllegalAccessException {
        int result = (int) method.invoke(Ex204.class, "aaaaaaaaaaa");
        Assert.assertEquals(1, result);

        result = (int) method.invoke(Ex204.class, "abababab");
        Assert.assertEquals(2, result);

        result = (int) method.invoke(Ex204.class, "abababa");
        Assert.assertEquals(2, result);
    }
}
