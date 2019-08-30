package main.java.strings;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

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
    XL(40),
    L(50),
    XC(90),
    IC(99),
    C(100),
    CD(400),
    ID(499),
    D(500),
    CM(900),
    IM(999),
    M(1_000);

    private static final int DEFAULT_VALUE = -1;
    private int arabicValue;

    Rome(int arabicValue) {
        this.arabicValue = arabicValue;
    }

    private static boolean isExistRome(String romeValue) {
        return Arrays.stream(values()).anyMatch(v -> v.name().equals(romeValue));
    }

    private static int getArabicValue(String romeValue) {
        return valueOf(romeValue).arabicValue;
    }

    private static int accumulatorArabicValue(int result, int element) {
        if (result == DEFAULT_VALUE) {
            result = element;
        } else {
            result += element;
        }
        return result;
    }

    public static int toArabicNumber(String romeValue) {
        int result = -1, element;
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < romeValue.length(); i++) {
            buffer.append(romeValue.charAt(i));

            if (!isExistRome(buffer.toString())) {
                buffer.deleteCharAt(buffer.length() - 1);
                element = getArabicValue(buffer.toString());
                result = accumulatorArabicValue(result, element);
                buffer = new StringBuilder(); // new builder
                i--;
            }

            if (i == romeValue.length() - 1) {
                element = getArabicValue(buffer.toString());
                result = accumulatorArabicValue(result, element);
            }
        }

        return result;
    }
}

enum Arabic {
    M(1_000),
    IM(999),
    CM(900),
    D(500),
    ID(499),
    CD(400),
    C(100),
    IC(99),
    XC(90),
    L(50),
    XL(40),
    X(10),
    IX(9),
    VIII(8),
    VII(7),
    VI(6),
    V(5),
    IV(4),
    III(3),
    II(2),
    I(1);

    private int arabicValue;

    Arabic(int arabicValue) {
        this.arabicValue = arabicValue;
    }

    public static String toRomeNumber(int arabicValue) {
        return prepareRomeValue(arabicValue);
    }

    private static String aroundRome(StringBuilder buffer, int arabicValue) {
        Optional<Arabic> optional = Arrays.stream(values())
                .filter(v -> v.arabicValue <= arabicValue)
                .findFirst();

        Arabic arabic = optional.get();
        if (arabic.arabicValue == arabicValue) {
            buffer.append(arabic.name());
            return arabic.name();
        } else {
            buffer.append(arabic.name());
            aroundRome(buffer, arabicValue - arabic.arabicValue);
        }

        return buffer.toString();
    }

    private static String getRomeValue(int arabicValue) {
        Optional<Arabic> optional = Arrays.stream(values())
                .filter(v -> v.arabicValue == arabicValue)
                .findFirst();

        return optional.map(Enum::name)
                .orElseGet(() -> aroundRome(new StringBuilder(), arabicValue));
    }

    private static String prepareRomeValue(int arabicValue) {
        Optional<Arabic> optional = Arrays.stream(values())
                .filter(v -> v.arabicValue == arabicValue)
                .findFirst();

        if (optional.isPresent()) {
            return optional.get()
                    .name();
        } else {
            StringBuilder buffer = new StringBuilder();
            for (int value = arabicValue, order = 1; value != 0; value /= 10, order *= 10) {
                int digit = value % 10;
                if (digit == 0 && value > 0) {
                    continue;
                }
                buffer.insert(0, getRomeValue(digit * order));
            }
            return buffer.toString();
        }
    }
}

public class Ex199 {
    private static final Scanner IN = new Scanner(System.in);
    private static final PrintWriter OUT = new PrintWriter(System.out);
    private static final String ERROR_MESSAGE = "ERROR";
    private static final String FRACTION_PATTERN = "[MDCLXVI]+/[MDCLXVI]+";
    private static final String DIVIDER = "/";

    private static int gcd(int a, int b) {
        return b == 0
                ? a
                : gcd(b, a % b);
    }

    private static boolean isValid(String fraction) {
        return fraction.matches(FRACTION_PATTERN);
    }

    public static int toArabicNumber(String valueRome) {
        return Rome.toArabicNumber(valueRome);
    }

    public static String toRomeNumber(int valueArabic) {
        return Arabic.toRomeNumber(valueArabic);
    }

    public static String reduceFraction(String drob) {
        if (isValid(drob)) {
            String[] values = drob.split(DIVIDER);
            int oneArg = toArabicNumber(values[0]);
            int twoArg = toArabicNumber(values[1]);

            if (oneArg % twoArg == 0) {
                return toRomeNumber(oneArg / twoArg);
            } else {
                int divider = gcd(oneArg, twoArg);
                return String.format("%s/%s",
                        toRomeNumber(oneArg / divider),
                        toRomeNumber(twoArg / divider));
            }
        }

        return ERROR_MESSAGE;
    }

    public static void main(String[] args) {
        String inputLine = IN.nextLine();
        OUT.print(reduceFraction(inputLine));
        OUT.flush();
    }
}