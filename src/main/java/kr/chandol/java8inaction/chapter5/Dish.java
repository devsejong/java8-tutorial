package kr.chandol.java8inaction.chapter5;

import java.util.Arrays;
import java.util.List;

import static kr.chandol.java8inaction.chapter5.Dish.Type.FISH;
import static kr.chandol.java8inaction.chapter5.Dish.Type.MEAT;
import static kr.chandol.java8inaction.chapter5.Dish.Type.OTHER;

public class Dish {
    public enum Type {
        MEAT, FISH, OTHER
    }

    private String name;
    private int calories;
    private boolean vegetarian;
    private Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.calories = calories;
        this.vegetarian = vegetarian;
        this.name = name;
        this.type = type;
    }

    public int getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public Type getType() {
        return type;
    }

    public static final List<Dish> menu =
            Arrays.asList(new Dish("pork", false, 800, MEAT),
                    new Dish("beef", false, 700, MEAT),
                    new Dish("chicken", false, 400, MEAT),
                    new Dish("french fries", true, 530, OTHER),
                    new Dish("rice", true, 350, OTHER),
                    new Dish("season fruit", true, 120, OTHER),
                    new Dish("pizza", true, 550, OTHER),
                    new Dish("prawns", false, 400, FISH),
                    new Dish("salmon", false, 450, FISH));


    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", vegetarian=" + vegetarian +
                ", type=" + type +
                '}';
    }
}
