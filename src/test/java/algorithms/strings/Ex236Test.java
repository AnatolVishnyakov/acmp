package algorithms.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

class Ex236Test {
    public static Iterable<Object[]> testDataCalculate() {
        return Arrays.asList(new Object[][]{
                {"-2+x^1-3*x^2+x^2+100*x^3-2*x", 0, -2},
                {"-2+x^1-3*x^2+x^2+100*x^3-2*x", 1, 95},
                {"2+x^1-3*x^2+x^2+100*x^3-2*x", 0, 2},
                {"x^1-3*x^2+x^2+100*x^3-2*x", 0, 0},
                {"1-3*x^2+x^2+100*x^3-2*x", 0, 1},
                {"3*x^2+x^2+100*x^3-2*x", 1, 102},
                {"x^2+x^2+100*x^3-2*x", 1, 100},
                {"2+x^2+100*x^3-2*x", 0, 2},
                {"x^2+100*x^3-2*x", 0, 0},
                {"x^2+100*x^3-2*x", 1, 99},
                {"2+100*x^3-2*x", 1, 100},
                {"2+x^3-2*x", 1, 1},
                {"x^3-2*x", 1, -1},
                {"3-2*x", 1, 1},
                {"-3-2*x", 1, -5},
                {"-2*x", 1, -2},
                {"-3-2", 1, -5},
                {"2*x", 1, 2},
                {"x", 1, 1},
                {"8*x+5", 7, 61},
                {"8*x-5", 7, 51},
                {"x+5", 0, 5},
                {"x-5", 0, -5},
                {"x^2-x^2", 2, 0},
                {"2*x-2*x", 99, 0},
                {"2*x-2*x+1+2*x-2*x+1+2*x-2*x+1+2*x-2*x+1+2*x-2*x+1+2*x-2*x+1+2*x-2*x+1+2*x-2*x+12", 0, 19},
                {"2*x-2*x+1+2*x-2*x+1+2*x-2*x+1+2*x-2*x+1+2*x-2*x+1+2*x-2*x+1+2*x-2*x+1+2*x-2*x+123", 0, 19}
        });
    }

    @ParameterizedTest(name = "[{index}]: Expression: {0} -> x: {1} -> result: {2}")
    @MethodSource("testDataCalculate")
    public void testCalculate(String expression, int x, int expected) {
        Ex236.EquationSolver handler = new Ex236.EquationSolver(expression, x);
        assertEquals(expected, handler.calculate());
    }
}