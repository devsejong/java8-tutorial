package kr.chandol.java8lecture.lecture1.behaviorparameterization;

import java.util.List;

public class Apple {
    private int weight;
    private String color;

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

    public static List<Apple> dummies(){

    }
}
