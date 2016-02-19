package kr.chandol.java8.chpater3;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class subChapter8 {

    @Test
    public void 생성자_메서드() {
        //빈생성자 사용
        Supplier<Apple> a = new Supplier<Apple>() {
            @Override
            public Apple get() {
                return new Apple();
            }
        };
        Supplier<Apple> b = () -> new Apple();
        Supplier<Apple> c = Apple::new;

        // 파라미터가 하나인 생성자.
        IntFunction<Apple> d = new IntFunction<Apple>() {
            @Override
            public Apple apply(int value) {
                return new Apple(value);
            }
        };

        IntFunction<Apple> e = (weight) -> new Apple(weight);
        IntFunction<Apple> f = Apple::new;
    }

    @Test
    public void Comparator조합() {
        //메서드 레퍼런스를 통한 무게 가져오기
        Comparator<Apple> c = Comparator.comparing(Apple::getWeight);

        //역정렬
        Comparator.comparing(Apple::getWeight)
                .reversed();

        //정렬조건 추가
        Comparator.comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getCountry);
    }

    @Test
    public void Predicate조합() {

        // Predicate 선언하기.
        Predicate<Apple> redApple
                = (a) -> a.getColor().equals("red");

        // predicate 뒤집기.
        Predicate<Apple> notRedApple
                = redApple.negate();

        // red & heavy
        Predicate<Apple> redAndHeavyApple
                = redApple.and(a -> a.getWeight() > 150);


    }

    @Test
    public void Function조합() {

        // Function 조합
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;

        //f를 부른다음 g를 부른다.
        Function<Integer, Integer> h = f.andThen(g);

        System.out.println(h.apply(2));

        // Function 조합
        Function<Integer, Integer> i = x -> x + 1;
        Function<Integer, Integer> j = x -> x * 2;

        //f를 부른다음 g를 부른다.
        Function<Integer, Integer> k = i.compose(j);

        System.out.println(k.apply(2));
    }

}
