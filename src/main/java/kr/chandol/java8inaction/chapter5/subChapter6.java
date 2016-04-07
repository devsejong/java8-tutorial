package kr.chandol.java8inaction.chapter5;

import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static kr.chandol.java8inaction.chapter5.Dish.menu;

// 필터링과 슬라이싱
public class subChapter6 {
    @Test
    public void toBoxedType() {
IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
Stream<Integer> stream = intStream.boxed();
    }

    @Test
    public void rangeClosed() {
IntStream evenNumbers = IntStream
        .rangeClosed(1, 100);
    }

}
