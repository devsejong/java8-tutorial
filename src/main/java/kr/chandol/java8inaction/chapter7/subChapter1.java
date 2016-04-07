package kr.chandol.java8inaction.chapter7;

import org.junit.Test;

import java.util.stream.Stream;

public class subChapter1 {

    @Test
    public void firstParallelSum() {
        System.out.println(parallelSum(10));
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

}
