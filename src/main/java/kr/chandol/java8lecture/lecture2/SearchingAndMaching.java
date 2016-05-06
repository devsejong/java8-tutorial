package kr.chandol.java8lecture.lecture2;

import kr.chandol.java8inaction.chapter5.Dish;
import org.junit.Test;

import static kr.chandol.java8inaction.chapter5.Dish.menu;

// 검색과 매칭
public class SearchingAndMaching {
    @Test
    public void anyMatch() {
        menu.stream()
                .filter(d -> d.getCalories() < 100)
                .anyMatch(kr.chandol.java8inaction.chapter5.Dish::isVegetarian);
    }

    @Test
    public void allMatch() {
        menu.stream()
                .filter(d -> d.getCalories() < 100)
                .allMatch(kr.chandol.java8inaction.chapter5.Dish::isVegetarian);
    }

    @Test
    public void noneMatch() {
        menu.stream()
                .filter(d -> d.getCalories() >= 200)
                .noneMatch(kr.chandol.java8inaction.chapter5.Dish::isVegetarian);
    }

    @Test
    public void findAny() {
        menu.stream().filter(Dish::isVegetarian).findAny();

        menu.stream()
                .filter(d -> d.getCalories() < 200)
                .findAny();
    }

    @Test
    public void findFirst() {
        menu.stream()
                .filter(d -> d.getCalories() < 200)
                .findFirst();
    }

}
