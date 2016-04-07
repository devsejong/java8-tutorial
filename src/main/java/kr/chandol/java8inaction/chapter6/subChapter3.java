package kr.chandol.java8inaction.chapter6;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class subChapter3 {

    public enum CaloricLevel {
        DIET, NORMAL, FAT
    }

    @Test
    public void grouping() {
        Map<Dish.Type, List<Dish>> dishesByType = Dish.menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));

        System.out.println(dishesByType);

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = Dish.menu.stream()
                .collect(Collectors.groupingBy(dish -> {
                            if (dish.getCalories() <= 400)
                                return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700)
                                return CaloricLevel.NORMAL;
                            else
                                return CaloricLevel.FAT;
                        })
                );

        System.out.println(dishesByCaloricLevel);

    }

    @Test
    public void multiGrouping() {

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel
                = Dish.menu.stream().collect(
                Collectors.groupingBy(
                        Dish::getType,
                        Collectors.groupingBy(dish -> {
                            if (dish.getCalories() <= 400)
                                return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700)
                                return CaloricLevel.NORMAL;
                            else
                                return CaloricLevel.FAT;
                        })
                )
        );

        System.out.println(dishesByTypeCaloricLevel);

//{MEAT=3, OTHER=4, FISH=2}
        Map<Dish.Type, Long> countingOfDishes = Dish.menu.stream().collect(
                Collectors.groupingBy(Dish::getType, Collectors.counting())
        );

        System.out.println(countingOfDishes);


        Map<Dish.Type, Optional<Dish>> maxDishes1 = Dish.menu.stream().collect(
                Collectors.groupingBy(
                        Dish::getType,
                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))
                )
        );

        System.out.println(maxDishes1);

        Map<Dish.Type, Dish> maxDishes2 = Dish.menu.stream().collect(Collectors.groupingBy(
                Dish::getType,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
                        Optional::get
                )
        ));

        System.out.println(maxDishes2);
    }


}
