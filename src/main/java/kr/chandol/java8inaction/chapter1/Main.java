package kr.chandol.java8inaction.chapter1;

import java.io.File;
import java.util.*;

import static java.lang.Integer.compare;
import static java.util.Comparator.comparing;

public class Main {


    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<Apple>();

Collections.sort(inventory, new Comparator<Apple>() {
    @Override
    public int compare(Apple o1, Apple o2) {
        return Integer.compare(o1.getWeight(), o2.getWeight());
    }
});


Collections.sort(
        inventory,
        (o1, o2) -> compare(o1.getWeight(), o2.getWeight())
);


        inventory.sort((o1, o2) -> compare(o1.getWeight(), o2.getWeight()));

        inventory.sort(comparing(Apple::getWeight));

        List<String> myList
                = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);


        //메서드 레퍼런스
        new File(".").listFiles(file ->file.isHidden());
        new File(".").listFiles(File::isHidden);

        // Optional
        List<String> nullList = null;
        // NullPointerException 발생!!
        String reuslt = nullList.get(0);
    }

}
