package kr.chandol.java8.chapter1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class Main {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<Apple>();

        Collections.sort(inventory, new Comparator<Apple>() {
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        inventory.sort(comparing(Apple::getWeight));
    }

}
