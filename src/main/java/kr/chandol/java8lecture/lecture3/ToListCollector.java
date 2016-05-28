package kr.chandol.java8lecture.lecture3;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.LongStream;

public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return (list, item) -> list.add(item);
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
        //return t -> t;
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(
                EnumSet.of(Characteristics.CONCURRENT)
        );
    }


    public static void main(String[] args) {
        List<Long> collect = LongStream.rangeClosed(0, 5)
                .boxed()
                .collect(new ToListCollector<Long>());

        System.out.println(collect);
    }
}