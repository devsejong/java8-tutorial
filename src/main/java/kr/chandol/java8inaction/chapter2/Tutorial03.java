package kr.chandol.java8inaction.chapter2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Tutorial03 {
    interface ApplePredicate {
        boolean test(Apple apple);
    }

    //2.3.1. 익명 클래스 사용하기.
    List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    //2.3.3. 리스트 형식으로 추상화
    <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    @Test
    public void tutorialRunner() {
        Tutorial03 tutorial03 = new Tutorial03();
        List<Apple> inventory = new ArrayList<>();

        //2.3.1. 익명 클래스 사용하기
        filterApples(inventory,
                new ApplePredicate() {
                    @Override
                    public boolean test(Apple apple) {
                        return "red".equals(apple.getColor());
                    }
                }
        );

        //2.3.2. 람다 표현식 사용하기
        filterApples(
                inventory,
                (Apple apple) -> "red".equals(apple.getColor())
        );

        filterApples(inventory, (Apple apple) -> 150 > apple.getWeight());

        //2.3.3. 리스트 형식으로 추상화
        filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
    }
}


