package kr.chandol.java8lecture.lecture2;

import kr.chandol.java8inaction.chapter5.Dish;
import org.junit.Test;

import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static kr.chandol.java8inaction.chapter5.Dish.menu;

// 박싱 언박싱
public class PrimitiveStream {
    @Test
    public void primitiveStream() {

        int calories1 = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);

//  아래 코드는 동작하지 않는다.
//        int calories2 = menu.stream()
//                .map(Dish::getCalories)
//                .sum();

        int calories3 = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
    }

    @Test
    public void toBoxedType() {
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);

        IntStream.rangeClosed(1, 100)
                .boxed()
                .reduce(0, Integer::sum);
    }

    @Test
    public void intSummaryStatistics() {
        IntSummaryStatistics statistics = IntStream.rangeClosed(1, 100)
                .summaryStatistics();

        // {count=100, sum=5050, min=1, average=50.500000, max=100}
        System.out.println(statistics);
    }

    @Test
    public void intStreamGenerate() {

        // > 1, 2, 3
        IntStream.of(1, 2, 3);

        // > 0, 2, 4
        IntStream.iterate(0, i -> i + 2).limit(3);

        // > 1, 2
        IntStream.range(1, 3);

        // > 1, 2, 3
        IntStream.rangeClosed(1, 3);


    }

    @Test
    public void rangeClosed() {
        IntStream evenNumbers = IntStream
                .rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
    }


}
