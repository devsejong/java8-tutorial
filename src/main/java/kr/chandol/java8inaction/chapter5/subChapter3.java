package kr.chandol.java8inaction.chapter5;

import org.junit.Test;

import java.util.Optional;

import static kr.chandol.java8inaction.chapter5.Dish.menu;

// 검색과 매칭
public class subChapter3 {
    @Test
    public void anyMatch() {

        menu.stream()
                .filter(d -> d.getCalories() < 100)
                .anyMatch(Dish::isVegetarian);


    }

    @Test
    public void allMatch() {

        menu.stream()
                .filter(d -> d.getCalories() < 100)
                .allMatch(Dish::isVegetarian);

    }

    @Test
    public void noneMatch() {

        menu.stream()
                .filter(d -> d.getCalories() >= 200)
                .noneMatch(Dish::isVegetarian);


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
