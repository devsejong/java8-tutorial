package kr.chandol.java8lecture.lecture1.behaviorparameterization;

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


    // 녹색 사과만 필터링 하기.
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
        filterApples(inventory, new AppleColorPredicate());
    }
}


