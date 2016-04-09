package kr.chandol.java8lecture.lecture1.defaultfunction;

import kr.chandol.java8lecture.lecture1.behaviorparameterization.Apple;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Exam {

    public void exam(){
        Predicate<Apple> applePredicate1 = new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 150;
            }
        };

        Predicate<Apple> applePredicate2 = apple -> apple.getWeight() > 150;
        boolean isHeavyThan150 = applePredicate2.test(new Apple(150, "green"));

        Consumer<Apple> appleConsumer1 = new Consumer<Apple>() {
            @Override
            public void accept(Apple apple) {
                System.out.println(apple);
            }
        };

        Consumer<Apple> appleConsumer2 = apple -> System.out.println(apple);
        appleConsumer2.accept(new Apple(150, "green"));


        Function<Apple, String> appleFunction1 = new Function<Apple, String>() {
            @Override
            public String apply(Apple apple) {
                return apple.getColor();
            }
        };

        Function<Apple, String> appleFunction2 = apple -> apple.getColor();
        String green1 = appleFunction2.apply(new Apple(150, "green"));

        Supplier<Apple> appleSupplier1 = new Supplier<Apple>() {
            @Override
            public Apple get() {
                return new Apple();
            }
        };
        Supplier<Apple> appleSupplier2 = () -> new Apple();
        Apple apple = appleSupplier2.get();
    }
}
