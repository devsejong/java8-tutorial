package kr.chandol.java8lecture.lecture1.defaultfunction;

import kr.chandol.java8lecture.lecture1.behaviorparameterization.Apple;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Exam {

    public void exam() {
        Predicate<Apple> applePredicate1 = apple -> apple.getWeight() > 150;

        Predicate<Apple> applePredicate2 = apple -> apple.getWeight() > 150;
        boolean isHeavyThan150 = applePredicate2.test(new Apple(150, "green"));

        Consumer<Apple> appleConsumer1 = System.out::println;

        Consumer<Apple> appleConsumer2 = apple -> System.out.println(apple);
        appleConsumer2.accept(new Apple(150, "green"));


        Function<Apple, String> appleFunction1 = apple -> apple.getColor();

        Function<Apple, String> appleFunction2 = Apple::getColor;
        String green1 = appleFunction2.apply(new Apple(150, "green"));

        Supplier<Apple> appleSupplier1 = Apple::new;
        Supplier<Apple> appleSupplier2 = Apple::new;
        Apple apple = appleSupplier2.get();
    }
}
