package test.java.strings;

import main.java.strings.Ex203;
import org.junit.Test;
import org.junit.Assert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ex203Test {
    private Method method;

    public Ex203Test() throws NoSuchMethodException {
        method = Ex203.class.getDeclaredMethod("check", String.class, String.class);
        method.setAccessible(true);
    }

    @Test
    public void testSuccess() throws InvocationTargetException, IllegalAccessException {
        int result = (int) method.invoke(Ex203.class, "abcde", "deabc");
        Assert.assertEquals(2, result);

        result = (int) method.invoke(Ex203.class, "", "");
        Assert.assertEquals(0, result);

        result = (int) method.invoke(Ex203.class, "a", "a");
        Assert.assertEquals(0, result);

        result = (int) method.invoke(Ex203.class, "abbebeeaokeb", "abbebeeaokeb");
        Assert.assertEquals(0, result);

        result = (int) method.invoke(Ex203.class, "abbebeeaokeb", "bbebeeaokeba");
        Assert.assertEquals(11, result);

        result = (int) method.invoke(Ex203.class, "abbebeeaokeb", "babbebeeaoke");
        Assert.assertEquals(1, result);

        result = (int) method.invoke(Ex203.class, "AaaA", "aAAa");
        Assert.assertEquals(2, result);
    }

    @Test
    public void testNegative() throws InvocationTargetException, IllegalAccessException {
        int result = (int) method.invoke(Ex203.class, "a", "b");
        Assert.assertEquals(-1, result);
    }
}
