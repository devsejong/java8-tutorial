package kr.chandol.java8lecture.lecture1.methodreference;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Example {

    public void methodReferenceExample() {
        Function<String, Integer> toNumber1
                = (str) -> Integer.parseInt(str);

        Function<String, Integer> toNumber2
                = Integer::parseInt;

        Consumer<String> out1 = (str) -> System.out.println(str);
        Consumer<String> out2 = System.out::println;

        Comparator<Integer> comp1 = (o1, o2) -> o1.compareTo(o2);
        Comparator<Integer> comp2 = Integer::compareTo;

        Supplier<String> int1 = () -> new String();
        Supplier<String> int2 = String::new;


    }
}
