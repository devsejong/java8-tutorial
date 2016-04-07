package kr.chandol.java8inaction.chapter8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class subChapter4 {

    @Test
    public void exam() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        numbers.stream()
                .map(x -> x + 17)
                .filter(x -> x % 2 == 0)
                .limit(3)
                .forEach(System.out::println);
    }


    @Test
    public void examWithPeek() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        numbers.stream()
                .peek(x -> System.out.println("from Stream : " + x))
                .map(x -> x + 17)
                .sequential()
                .peek(x -> System.out.println("from map : " + x))
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("from filter : " + x))
                .limit(3)
                .peek(x -> System.out.println("from limit : " + x))
                .forEach(System.out::println);
    }
}
