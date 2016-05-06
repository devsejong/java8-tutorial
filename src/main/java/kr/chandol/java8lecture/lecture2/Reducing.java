package kr.chandol.java8lecture.lecture2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// 리듀싱
public class Reducing {

    List<Integer> numbers = Arrays.asList(6, 2, 1, 4, 2, 6);

    @Test
    public void reduce() {
        Integer product = numbers.stream().reduce(1, (a, b) -> a * b);

        Arrays.asList(6, 2, 1, 4, 2, 6)
                .stream()
                .reduce(0, (a, b) -> a + b);


        Optional<Integer> optionalProduct = numbers.stream().reduce((a, b) -> a * b);

    }

    @Test
    public void max() {
        Arrays.asList(6, 2, 1, 4, 2, 6)
                .stream()
                .reduce(0, Integer::max);

    }

    @Test
    public void sort() {

        Arrays.asList(6, 2, 1, 4, 2, 6)
                .stream()
                .sorted(Integer::compareTo);

    }


}
