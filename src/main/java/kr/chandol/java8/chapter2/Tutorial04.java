package kr.chandol.java8.chapter2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

// 실전예제
public class Tutorial04 {

    //2.4.1. Comparator로 정렬하기
    @Test
    public void sortWithLambda() {
        List<Apple> inventory = new ArrayList<>();

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getColor().compareTo(a2.getColor());
            }
        });

        inventory.sort(
                (Apple a1, Apple a2) -> a1.getColor().compareTo(a2.getColor())
        );

        //앞으로 나올꺼지만..
        inventory.sort(comparing(Apple::getWeight));
    }

    //2.4.2. Runnable로 코드 블록 실행하기
    @Test
    public void runnableWithLambda() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, world!");
            }
        });

        new Thread(() -> System.out.println("Hello, world!"));
    }
}


