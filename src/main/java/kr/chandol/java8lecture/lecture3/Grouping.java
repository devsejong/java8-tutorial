package kr.chandol.java8lecture.lecture3;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by sejong on 2016. 5. 27..
 */
public class Grouping {

    public enum CaloricLevel {
        DIET, NORMAL, FAT
    }

    @Test
    public void grouping() {

        // OTHER=[french fries, rice, season fruit, pizza],
        // MEAT=[pork, beef, chicken],
        // FISH=[prawns, salmon]
        Map<Dish.Type, List<Dish>> dishesByType = Dish.menu.stream()
                .collect(groupingBy(Dish::getType));

        Dish.menu.stream()
                .collect(groupingBy(Dish::getType));

        System.out.println(dishesByType);

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = Dish.menu.stream()
                .collect(groupingBy(dish -> {
                            if (dish.getCalories() <= 400)
                                return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700)
                                return CaloricLevel.NORMAL;
                            else
                                return CaloricLevel.FAT;
                        })
                );

        System.out.println(dishesByCaloricLevel);

        // {OTHER=4, MEAT=3, FISH=2}
        Dish.menu.stream()
                .collect(groupingBy(
                        Dish::getType, Collectors.counting()
                ));

        // OTHER={true=[french fries, rice, season fruit, pizza]}
        // MEAT={false=[pork, beef, chicken]}
        // FISH={false=[prawns, salmon]}
        Dish.menu.stream()
                .collect(groupingBy(
                        Dish::getType,
                        groupingBy(Dish::isVegetarian)
                ));


Map<Dish.Type, Optional<Dish>> maxDishes1 = Dish.menu.stream().collect(
        groupingBy(
                Dish::getType,
                Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))
        )
);

System.out.println(maxDishes1);

Map<Dish.Type, Dish> maxDishes2 = Dish.menu.stream().collect(groupingBy(
        Dish::getType,
        Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
                Optional::get
        )
));

        System.out.println(maxDishes2);

    }
}
