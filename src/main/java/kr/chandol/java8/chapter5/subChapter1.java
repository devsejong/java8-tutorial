package kr.chandol.java8.chapter5;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static kr.chandol.java8.chapter5.Dish.menu;

// 필터링과 슬라이싱
public class subChapter1 {
    @Test
    public void predicateTest() {
        menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());
    }

    @Test
    public void distinct() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3);
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
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());
    }
}
