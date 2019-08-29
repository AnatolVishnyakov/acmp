package main.java.strings;

import java.util.Arrays;

enum Rome {
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10),
    XVIII(18),
    XXXI(31),
    XLVI(46),
    L(50),
    LXXV(75),
    XCII(92),
    IC(99),
    C(100),
    CCCII(302),
    CDXLI(441),
    ID(499),
    D(500),
    DCXCV(695),
    CM(900);

    private int value;

    Rome(int value) {
        this.value = value;
    }

    public static int toArabicNumber(String romeValue) {
        int result = 0, element;
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < romeValue.length(); i++) {
            buffer.append(romeValue.charAt(i));

            if (!isExist(buffer.toString())) {
                buffer.deleteCharAt(buffer.length() - 1);
                element = getArabicNumber(buffer.toString());
                result = concatElementResult(result, element);
                buffer = new StringBuilder(); // new builder
                i--;
            }

            if (i == romeValue.length() - 1) {
                element = getArabicNumber(buffer.toString());
                result = concatElementResult(result, element);
            }
        }

        return result;
    }

    private static int concatElementResult(int result, int element) {
        if (result == 0) {
            result = element;
        } else {
            result += element;
        }
        return result;
    }

    private static boolean isExist(String romeValue) {
        return Arrays.stream(values()).anyMatch(v -> v.name().equals(romeValue));
    }

    private static int getArabicNumber(String romeValue) {
        return valueOf(romeValue).value;
    }
}

public class Ex199 {
    public static void main(String[] args) {

    }
}