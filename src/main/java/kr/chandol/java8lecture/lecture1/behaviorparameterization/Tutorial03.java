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
        List<Apple> inventory = Apple.dummies();

        // 익명 클래스 사용하기
        List<Apple> apples1 = filterApples(inventory,
                new ApplePredicate() {
                    @Override
                    public boolean test(Apple apple) {
                        return "red".equals(apple.getColor());
                    }
                }
        );
        System.out.println(apples1);

        // 람다 표현식 사용하기
        List<Apple> apples2 = filterApples(inventory,
                (Apple apple) -> "red".equals(apple.getColor())
        );
        System.out.println(apples2);

        List<Apple> apples3 = filterApples(inventory,
                (Apple apple) -> 150 > apple.getWeight()
        );
        System.out.println(apples3);
    }

}


