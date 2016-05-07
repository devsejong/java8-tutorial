package kr.chandol.java8lecture.lecture2;

import kr.chandol.java8inaction.chapter5.Dish;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static kr.chandol.java8inaction.chapter5.Dish.menu;

// 필터링과 슬라이싱
public class FilteringAndSlicing {

    @Test
    public void filter() {
        menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());
    }

    @Test
    public void distinct() {
        List<Integer> numbers = Arrays.asList(1, 1, 1, 2, 5);
        numbers.stream()
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void list() {
        menu.stream()
                .limit(3)
                .collect(toList());
    }

    @Test
    public void skip() {

        menu.stream()
                .skip(2)
                .collect(toList());

    }
}
