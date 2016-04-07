package kr.chandol.java8lecture.lecture1.behaviorparameterization;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Tutorial03 {
    interface ApplePredicate {
        boolean test(Apple apple);
    }

    List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    @Test
    public void tutorialRunner() {
        List<Apple> inventory = new ArrayList<>();

        // 익명 클래스 사용하기
        filterApples(inventory,
                new ApplePredicate() {
                    @Override
                    public boolean test(Apple apple) {
                        return "red".equals(apple.getColor());
                    }
                }
        );

        // 람다 표현식 사용하기
        filterApples(
                inventory,
                (Apple apple) -> "red".equals(apple.getColor())
        );

        filterApples(inventory, (Apple apple) -> 150 > apple.getWeight());
    }
}


