package kr.chandol.java8inaction.chapter6;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class subChapter4 {

    @Test
    public void partitioning() {
        // {false=[pork, beef, chicken, prawns, salmon],
        // true=[french fries, rice, season fruit, pizza]}
        Map<Boolean, List<Dish>> partitionedMenu = Dish.menu.stream().collect(
                Collectors.partitioningBy(Dish::isVegetarian)
        );

        System.out.println(partitionedMenu);

        // {false={FISH=[prawns, salmon], MEAT=[pork, beef, chicken]},
        // true={OTHER=[french fries, rice, season fruit, pizza]}}
        Map<Boolean, Map<Dish.Type, List<Dish>>> patitionedAndGroupDishes = Dish.menu.
                stream().collect(
                Collectors.partitioningBy(
                        Dish::isVegetarian,
                        Collectors.groupingBy(Dish::getType)
                )
        );

        System.out.println(patitionedAndGroupDishes);
    }


}
