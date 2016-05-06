package kr.chandol.java8lecture.lecture2;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;


public class StreamGenerate {
    @Test
    public void 값으로스트림만들기() {
        Stream<String> stream = Stream.of("Java8", "Lambdas", "In", "Action");
        Stream<Integer> emptyStream = Stream.empty();
    }

    @Test
    public void 배열로스트림만들기() {
        int[] numbers = {2, 3, 5, 7, 11};
        int sum = Arrays.stream(numbers).sum();
    }

    @Test
    public void 이터레이터사용법() {
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
    }

    @Test
    public void 제네레이터사용법() {
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);
    }

}
