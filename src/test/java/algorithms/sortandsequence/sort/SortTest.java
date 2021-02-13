package algorithms.sortandsequence.sort;

import algorithms.sortandsequence.sort.extension.TimingExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

@ExtendWith(TimingExtension.class)
class SortTest {
    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(IntStream.range(1, 100).boxed().toArray(Integer[]::new), 100),
                Arguments.of(IntStream.range(1, 1_000).boxed().toArray(Integer[]::new), 1_000),
                Arguments.of(IntStream.range(1, 10_000).boxed().toArray(Integer[]::new), 10_000),
                Arguments.of(IntStream.range(1, 100_000).boxed().toArray(Integer[]::new), 100_000)
        );
    }

    @ParameterizedTest(name = "{index} => size = {1}")
    @MethodSource("data")
    void testSortSelection(Integer[] array) {
        final Selection alg = new Selection();
        alg.sort(array);
    }

    @ParameterizedTest(name = "{index} => size = {1}")
    @MethodSource("data")
    void testSortInsertion(Integer[] array) {
        final Selection alg = new Selection();
        alg.sort(array);
    }
}