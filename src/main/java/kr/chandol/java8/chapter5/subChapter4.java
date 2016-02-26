package kr.chandol.java8.chapter5;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// 리듀싱
public class subChapter4 {

    List<Integer> numbers = Arrays.asList(6, 2, 1, 4, 2, 6);

    @Test
    public void reduce() {
        List<Integer> numbers = Arrays.asList(6, 2, 1, 4, 2, 6);
        numbers.stream().sorted(Integer::compareTo);
        Integer product = numbers
                .stream().reduce(1, (a, b) -> a * b);
        Optional<Integer> optionalProduct = numbers.stream().reduce((a, b) -> a * b);
    }

    @Test
    public void max() {
        Optional<Integer> optioanlMax = numbers.stream().reduce(Integer::max);
        Integer max = numbers.stream().reduce(1, Integer::max);
    }


}
