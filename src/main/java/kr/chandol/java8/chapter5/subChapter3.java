package kr.chandol.java8.chapter5;

import org.junit.Test;

import java.util.Optional;

import static kr.chandol.java8.chapter5.Dish.menu;

// 검색과 매칭
public class subChapter3 {
    @Test
    public void anyMatch() {
        menu.stream().anyMatch(Dish::isVegetarian);

    }

    @Test
    public void allMatch(){
        menu.stream().allMatch(d -> d.getCalories() < 1000);
    }

    @Test
    public void noneMatch(){
        menu.stream().allMatch(d -> d.getCalories() >= 1000);
    }

    @Test
    public void findAny(){
        Optional<Dish> any = menu.stream().filter(Dish::isVegetarian).findAny();
    }

    @Test
    public void findFirst(){
        Optional<Dish> first = menu.stream().filter(Dish::isVegetarian).findFirst();
    }

}
