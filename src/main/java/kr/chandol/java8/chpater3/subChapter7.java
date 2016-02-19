package kr.chandol.java8.chpater3;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class subChapter7 {

    @Test
    public void test() {

        Function<Integer, Long> function1 = (Integer a) -> a.longValue();
        Function<Integer, Long> function2 = Integer::longValue;

        Comparator<Integer> comparator1 = (o1, o2) -> o1.compareTo(o2);
        Comparator<Integer> comparator2 = Integer::compareTo;

        //this 사용하기
        Consumer<String> supplier1 = this::test2;
        Consumer<String> supplier2 = System.out::println;

        //new를 메서드 레퍼런스로 사용하기

        Supplier<Apple> a = new Supplier<Apple>() {
            @Override
            public Apple get() {
                return new Apple();
            }
        };
        Supplier<Apple> b = () -> new Apple();
        Supplier<Apple> c = Apple::new;
    }

    public void test2(String a) {
        System.out.println("test");
    }
}
