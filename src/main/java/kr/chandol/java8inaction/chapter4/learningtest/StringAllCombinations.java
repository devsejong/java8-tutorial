package kr.chandol.java8inaction.chapter4.learningtest;

import java.math.BigInteger;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringAllCombinations {
    private static AtomicBigInteger count = new AtomicBigInteger(new BigInteger("-1"));

    public static BigInteger combinationsCount(BigInteger num) {
        if (num.equals(BigInteger.ZERO))
            return BigInteger.ZERO;
        return num.multiply(combinationsCount(num.subtract(BigInteger.ONE))).add(num);
    }

    // goes out of memory so commented
    public static Stream<String> combinations(String str) {
        int number = str.length();
        BigInteger max = combinationsCount(new BigInteger(String.valueOf(number)));
        System.out.println("Combinations of " + number + "=" + max.toString() + " for " + str);
        Stream<String> curStream = IntStream.range(0, str.length()).boxed()
                .flatMap(i -> combinationsHelper(i, str));
        return curStream;
    }

    public static Stream<String> combinationsHelper(int len, String str) {
        if (str.length() == len) {
            BigInteger cnt = count.incrementAndGet();
            if (cnt.compareTo(BigInteger.ZERO) > 0 && cnt.remainder(new BigInteger("1000")).equals(BigInteger.ZERO)) {
                System.out.println(cnt + " are done...");
            }
            return Stream.of("");
        }
        return IntStream.range(0, str.length()).boxed().flatMap(
                i -> combinationsHelper(len, str.substring(0, i) + str.substring(i + 1)).map(t -> str.charAt(i) + t));
    }

    static final class AtomicBigInteger {
        private final AtomicReference<BigInteger> valueHolder = new AtomicReference<>();

        public AtomicBigInteger(BigInteger bigInteger) {
            valueHolder.set(bigInteger);
        }

        public BigInteger incrementAndGet() {
            for (; ; ) {
                BigInteger current = valueHolder.get();
                BigInteger next = current.add(BigInteger.ONE);
                if (valueHolder.compareAndSet(current, next)) {
                    return next;
                }
            }
        }
    }

    public static void main(String[] args) {
        int rangeLow = 65;
        int number = 4;
        Date startDate = new Date();
        long startTime = System.nanoTime();

        System.out.println("Started at " + startDate);
        combinations(
                IntStream.range(0, number)
                        .boxed()
                        .map(s -> Character.toString((char) (rangeLow + s)))
                        .collect(Collectors.toList())
                    .stream()
                        .map(i -> i)
                        .reduce((a, b) -> a + b).get())
                    .parallel()
                        .collect(Collectors.toSet())
                    .stream()
                        .sorted()
                        .forEach(System.out::println);

        Date endDate = new Date();
        long totalTime = System.nanoTime() - startTime;

        System.out.println("Ended at " + endDate + " total time=" + totalTime + " nanosec");
    }
}