package main.java.binarysearch;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/** Ex267
 * Секретарша Ирочка сегодня опоздала на работу и ей срочно
 * нужно успеть к обеду сделать N копий одного документа.
 * В ее распоряжении имеются два ксерокса, один из которых
 * копирует лист за х секунд, а другой – за y секунд.
 * (Разрешается использовать как один ксерокс, так и оба одновременно.
 * Можно копировать не только с оригинала, но и с копии.)
 * Помогите ей выяснить, какое минимальное время для этого потребуется.
 * <p>
 * N - кол-во копий документа
 * x - скорость копирования 1 ксерокса
 * y - скорость копирования 2 ксерокса
 * <p>
 * Входные данные
 * - Во входном файле INPUT.TXT записаны три натуральных числа N, x и y, разделенные пробелом (1 ≤ N ≤ 2*10^8, 1 <= x, y <= 10).
 * <p>
 * Выходные данные
 * - В выходной файл OUTPUT.TXT выведите одно число – минимальное время в секундах, необходимое для получения N копий.
 * <p>
 * Пример:
 * <p>
 * 4 1 1 -> 3
 * 5 1 2 -> 4
 */
public class Ex267 {
    private static boolean isValidNumberOfCopy(int value) {
        return value != 0 && value != 1;
    }

    private static int print(int speedXerox, AtomicInteger currentSpeed) {
        if (currentSpeed.get() == speedXerox) {
            currentSpeed.set(1);
            return 1;
        }
        currentSpeed.incrementAndGet();
        return 0;
    }

    public static int run(int n, int x, int y) {
        if (isValidNumberOfCopy(n)) {
            int numberOfCopyDocument = 1; // сделали копию
            AtomicInteger firstXerox =  new AtomicInteger(1);
            AtomicInteger secondXerox = new AtomicInteger(1);
            final int minSpeed = (x < y) ? x : y;
            final int maxSpeed = (x > y) ? x : y;

            int time;
            for (time = 2; ; time++) {
                if (minSpeed != 0) {
                    numberOfCopyDocument += print(minSpeed, firstXerox);
                    if (numberOfCopyDocument == n) {
                        break;
                    }
                }
                if (maxSpeed != 0) {
                    numberOfCopyDocument += print(maxSpeed, secondXerox);
                    if (numberOfCopyDocument == n) {
                        break;
                    }
                }
            }

            return time;
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        int n = reader.nextInt();
        int x = reader.nextInt();
        int y = reader.nextInt();

        int result = run(n, x, y);
        writer.println(result);

        writer.flush();
    }
}