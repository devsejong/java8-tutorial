package kr.chandol.java8lecture.lecture3;

import org.junit.Test;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import static kr.chandol.java8lecture.lecture3.Dish.menu;

public class Reduction {

    @Test
    public void maxByMinBy() {

        Comparator<Dish> dishCaloriesComparator =
                Comparator.comparingInt(Dish::getCalories);

        Dish mostCalorieDish = menu.stream()
                .collect(
                        Collectors.maxBy(dishCaloriesComparator)
                ).get();

        Dish lowestCalorieDish = menu.stream()
                .collect(
                        Collectors.minBy(dishCaloriesComparator)
                ).get();
    }


    @Test
    public void joining() {

//pork, beef, chicken ... pizza, prawns, salmon
        String shortMenu = kr.chandol.java8inaction.chapter6.Dish.menu.stream()
                .map(kr.chandol.java8inaction.chapter6.Dish::getName)
                .collect(Collectors.joining(/*구분자*/", "));

        System.out.println(shortMenu);
    }

    @Test
    public void reducing() {

        int totalCalories = Dish.menu.stream().collect(
                Collectors.reducing(
                        0/*연산의 시작값*/,
                        Dish::getCalories/*연산의 대상이 되는 값을 추출*/,
                        (i, j) -> i + j)/*BinaryOperator로 두 값을 합침*/
        );

        Optional<Dish> maxCalorieDish = Dish.menu.stream().collect(
                Collectors.reducing(
                        /*BinaryOperator 연산을 진행*/
                        (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2
                )
        );

    }

}
