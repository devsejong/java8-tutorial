package kr.chandol.java8.chapter4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static kr.chandol.java8.chapter4.Dish.menu;

public class subChapter1 {


    //자바7 스타일 컬렉션 조작
    @Test
    public void java7styleCollectionControl() {
        List<Dish> lowCaloricDishes = new ArrayList<>();

// 칼로리가 400이하인 메뉴만 가지고 온다.
        for (Dish d : menu) {
            if (d.getCalories() < 400) {
                lowCaloricDishes.add(d);
            }
        }

// 칼로리 순으로 정렬한다
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

// 요리 이름만 가지고 온다.
        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }

        System.out.println(lowCaloricDishesName);

    }

    @Test
    public void java8styleCollectionControl() {
        List<String> lowCaloricDishesName = menu
                .stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());

        System.out.println(lowCaloricDishesName);
    }

    @Test
    public void java8parallelStream() {
        List<String> lowCaloricDishesName = menu
                .parallelStream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());

        System.out.println(lowCaloricDishesName);
    }

}
