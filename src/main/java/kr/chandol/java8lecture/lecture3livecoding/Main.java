package kr.chandol.java8lecture.lecture3livecoding;


import kr.chandol.java8lecture.lecture3.Collector;
import kr.chandol.java8lecture.lecture3livecoding.Dish.Type;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
import static kr.chandol.java8lecture.lecture3livecoding.Transaction.transactions;

public class Main {

    @Test
    public void test() {

        Map<Type, Dish> collect = Dish.menu.stream()
                .collect(groupingBy(
                        Dish::getType,
                        collectingAndThen(
                                maxBy(comparingInt(Dish::getCalories)),
                                Optional::get
                        )
                ));

        System.out.println(collect);
    }
}
















