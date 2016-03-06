package com.theserverside;


import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Method;
import static org.junit.Assert.*;

/**
 * Unit test for simple Math.
 */
public class MathTest {
    @Test
    public void testPrivateMethod() throws Exception{
        Math app = new Math();

        Method method = Math.class.getDeclaredMethod("sum", int.class, int.class);
        method.setAccessible(true);

        int sum = (Integer) method.invoke(app, 1, 2);

        assertEquals(3, sum);
    }

    @Test
    public void testPrivateMethodWithSpringReflectionUtils() throws Exception{
        Math app = new Math();

        int sum = ReflectionTestUtils.invokeMethod(app, "sum", 1, 2);

        assertEquals(3, sum);
    }


}
