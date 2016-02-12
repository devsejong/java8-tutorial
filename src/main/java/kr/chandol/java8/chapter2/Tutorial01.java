package kr.chandol.java8.chapter2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Tutorial01 {


    //2.1.1. 녹색 사과만 필터링 하기.

    public List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    //2.1.2. 색을 파라미터화 하기
    List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }

        return result;
    }


    List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }

        return result;
    }

    //2.1.3. 가능한 모든 속성으로 필터링
    public List<Apple> filterApples(
            List<Apple> inventory, String color, int weight, boolean flag
    ) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color))
                    || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }

        return result;
    }


    @Test
    public void tutorialRunner() {
        Tutorial01 tutorial01 = new Tutorial01();
        List<Apple> inventory = new ArrayList<>();

        tutorial01.filterGreenApples(inventory);

        tutorial01.filterApplesByColor(inventory, "green");
        tutorial01.filterApplesByColor(inventory, "red");

        tutorial01.filterApples(inventory, "green", 0, true);
        tutorial01.filterApples(inventory, "", 150, true);
    }
}
