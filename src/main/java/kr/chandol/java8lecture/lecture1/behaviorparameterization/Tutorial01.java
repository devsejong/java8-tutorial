package kr.chandol.java8lecture.lecture1.behaviorparameterization;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Tutorial01 {

    public List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

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

    @Test
    public void tutorialRunner() {
        Tutorial01 tutorial01 = new Tutorial01();
        List<Apple> inventory = new ArrayList<>();

        tutorial01.filterGreenApples(inventory);

        tutorial01.filterApplesByColor(inventory, "green");
        tutorial01.filterApplesByColor(inventory, "red");
    }
}
