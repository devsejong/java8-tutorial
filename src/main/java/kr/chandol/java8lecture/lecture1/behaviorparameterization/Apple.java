package kr.chandol.java8lecture.lecture1.behaviorparameterization;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Apple {
    private int weight;
    private String color;

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Apple() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    static List<Apple> dummies() {
        return new ArrayList<>(asList(
                new Apple(160, "green"),
                new Apple(140, "green"),
                new Apple(130, "green"),
                new Apple(160, "red"),
                new Apple(140, "red")
        ));
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
