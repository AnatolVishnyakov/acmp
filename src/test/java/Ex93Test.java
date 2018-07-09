package test.java;

import main.java.Ex93;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Ex93Test {

    @Test
    public void testCompare() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Ex93.class.getDeclaredMethod("compare", char[].class, char[].class);
        method.setAccessible(true);

        boolean result = (boolean) method.invoke(Ex93.class, "ZEUS".toCharArray(), "ZEVS".toCharArray());
        Assert.assertTrue(result);

        result = (boolean) method.invoke(Ex93.class, "POSEIDON".toCharArray(), "POSEYDON".toCharArray());
        Assert.assertTrue(result);

        result = (boolean) method.invoke(Ex93.class, "ZEUS".toCharArray(), "ZERS".toCharArray());
        Assert.assertTrue(result);

        result = (boolean) method.invoke(Ex93.class, "AFINA".toCharArray(), "AVYNA".toCharArray());
        Assert.assertFalse(result);

        result = (boolean) method.invoke(Ex93.class, "ZEUS".toCharArray(), "POSEIDON".toCharArray());
        Assert.assertFalse(result);
    }

    @Test
    public void testMatcherDictionary() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Ex93.class.getDeclaredMethod("matcherDictionary", List.class, List.class);
        method.setAccessible(true);

        List<String> correct = new ArrayList<String>(){{
            add("ZEUS"); add("POSEIDON"); add("AFINA");
        }};

        List<String> inCorrect = new ArrayList<String>(){{
           add("ZEVS"); add("POSEYDON"); add("AVYNA"); add("ZERS");
        }};

        String actual = (String) method.invoke(Ex93.class, correct, inCorrect);
        Assert.assertEquals("2 1 0", actual);
    }
}
