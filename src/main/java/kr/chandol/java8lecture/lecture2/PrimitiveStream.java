package kr.chandol.java8lecture.lecture2;

import kr.chandol.java8inaction.chapter5.Dish;
import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static kr.chandol.java8inaction.chapter5.Dish.menu;

// 박싱 언박싱
public class PrimitiveStream {
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
