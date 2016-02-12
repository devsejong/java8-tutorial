package kr.chandol.java8.chapter2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Tutorial02 {
    interface ApplePredicate{
        boolean test(Apple apple);
    }

    class AppleHeavyWeightPredicate implements ApplePredicate{
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    class AppleColorPredicate implements ApplePredicate{
        @Override
        public boolean test(Apple apple) {
            return "green".equals(apple.getColor());
        }
    }


    //2.2.1. 녹색 사과만 필터링 하기.
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
        Tutorial02 tutorial02 = new Tutorial02();
        List<Apple> inventory = new ArrayList<>();

        filterApples(inventory, new AppleColorPredicate());
    }
}


