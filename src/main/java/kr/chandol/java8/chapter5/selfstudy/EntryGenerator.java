package kr.chandol.java8.chapter5.selfstudy;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EntryGenerator {

    @Test
    public void generate() {

        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(4, 5);

        List<String> collect = a.stream().flatMap(
                i -> b.stream()
                        .map(j -> i + ", " + j)
        ).collect(Collectors.toList());

        System.out.println(collect);
    }
}
