package kr.chandol.java8.chpater3;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.*;

public class subChapter7 {

    @Test
    public void test() {


        //Predicate
        Predicate<Apple> predicate1 = new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("green");
            }
        };
        Predicate<Apple> predicate2 = apple -> apple.getColor().equals("green");

        //BiPredicate
        BiPredicate<Apple, Banana> biPredicate = (a, b) -> {
            return a.getWeight() > b.getWeight();
        };

        //Consumer
        Consumer<Apple> consumer1 = new Consumer<Apple>() {
            @Override
            public void accept(Apple apple) {
                System.out.println(apple);
            }
        };

        Consumer<Apple> consumer2 = System.out::println;

        //BiConsumer
        BiConsumer<Apple, Banana> biConsumer
                = (a, b) -> System.out.println(a.toString() + b.toString());


        //Supplier
        Supplier<Apple> supplier1 = new Supplier<Apple>() {
            @Override
            public Apple get() {
                return new Apple();
            }
        };

        Supplier<Apple> supplier2 = Apple::new;


        //Function
        Function<Apple, Integer> function1 = new Function<Apple, Integer>() {
            @Override
            public Integer apply(Apple apple) {
                return apple.getWeight();
            }
        };

        Function<Apple, Integer> function2 = Apple::getWeight;

        //BiFunction
        BiFunction<Apple, Banana, Integer> biFunction1 = new BiFunction<Apple, Banana, Integer>() {
            @Override
            public Integer apply(Apple apple, Banana banana) {
                return apple.getWeight() + banana.getWeight();
            }
        };

        BiFunction<Apple, Banana, Integer> biFunction2
                = (apple, banana) -> apple.getWeight() + banana.getWeight();

        //UnaryOperator
        UnaryOperator<Apple> unaryOperator = (apple)->{
            apple.setWeight(100);
            return apple;
        };

        //BinaryOperator
        BinaryOperator<Apple> binaryOperator = (a1, a2) -> {
            Apple apple = new Apple();
            apple.setWeight(a1.getWeight() + a2.getWeight());
            return apple;
        };
    }

    //약 140ms 소요
    @Test
    public void wrapper_performanceTest(){
        Integer[] integers = new Integer[1000000];
        for(int i=0;i<1000000;i++){
            integers[i] = i;
        }

        long start = System.currentTimeMillis();
        Arrays.stream(integers).reduce(0, (prev, curr) -> prev + curr);
        Arrays.stream(integers).reduce(0, (prev, curr) -> prev + curr);
        Arrays.stream(integers).reduce(0, (prev, curr) -> prev + curr);
        Arrays.stream(integers).reduce(0, (prev, curr) -> prev + curr);
        Arrays.stream(integers).reduce(0, (prev, curr) -> prev + curr);

        System.out.println(System.currentTimeMillis() - start);
    }

    //약 100ms 소요
    @Test
    public void primitive_performanceTest(){
        int[] ints = new int[1000000];
        for(int i=0;i<1000000;i++){
            ints[i] = i;
        }

        long start = System.currentTimeMillis();
        Arrays.stream(ints).reduce(0, (prev, curr) -> prev + curr);
        Arrays.stream(ints).reduce(0, (prev, curr) -> prev + curr);
        Arrays.stream(ints).reduce(0, (prev, curr) -> prev + curr);
        Arrays.stream(ints).reduce(0, (prev, curr) -> prev + curr);
        Arrays.stream(ints).reduce(0, (prev, curr) -> prev + curr);

        System.out.println(System.currentTimeMillis() - start);
    }
}
