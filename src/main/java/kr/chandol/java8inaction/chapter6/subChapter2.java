package kr.chandol.java8inaction.chapter6;

import org.junit.Test;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.maxBy;

public class subChapter2 {

    @Test
    public void maxByMinBy() {
        Comparator<Dish> dishCaloriesComparator =
                Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> mostCalorieDish =
                Dish.menu.stream()
                        .collect(maxBy(dishCaloriesComparator));
    }

    @Test
    public void summingint() {
        int totalCalories = Dish.menu.stream().collect(Collectors.summingInt(Dish::getCalories));

        System.out.println(totalCalories);
    }

    @Test
    public void summaryStatistics() {
        // count=9, sum=4300, min=120, average=477.777778, max=800
        IntSummaryStatistics menuStatistics = Dish.menu.stream().collect(
                Collectors.summarizingInt(Dish::getCalories)
        );

        System.out.println(menuStatistics);
    }

    @Test
    public void joining() {
        String shortMenu = Dish.menu.stream()
                .map(Dish::getName).collect(Collectors.joining(/*구분자*/", "));

        System.out.println(shortMenu);
    }

    @Test
    public void reducing() {
        int totalCalories = Dish.menu.stream().collect(
                Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));

        Optional<Dish> maxCalorieDish = Dish.menu.stream().collect(
                Collectors.reducing(
                        (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2
                )
        );

    }
}
