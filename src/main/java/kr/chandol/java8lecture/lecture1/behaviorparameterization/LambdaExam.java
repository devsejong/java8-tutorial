package kr.chandol.java8lecture.lecture1.behaviorparameterization;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

// 실전예제
public class LambdaExam {

    // Comparator로 정렬하기
    @Test
    public void sortWithLambda() {
        List<Apple> inventory = new ArrayList<>();

        inventory.sort((a1, a2) -> a1.getColor().compareTo(a2.getColor()));

        inventory.sort(
                (Apple a1, Apple a2) -> a1.getColor().compareTo(a2.getColor())
        );

        //앞으로 나올꺼지만..
        inventory.sort(comparing(Apple::getWeight));
    }

    // Runnable로 코드 블록 실행하기
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


