package kr.chandol.java8.chapter2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

// 실전예제
public class Tutorial04 {

    //2.4.1. Comparator로 정렬하기
    @Test
    public void sortWithLambda(){
        List<Apple> inventory = new ArrayList<>();
        inventory.sort((Apple a1, Apple a2)->a1.getColor().compareTo(a2.getColor()));
    }

    //2.4.2. Runnable로 코드 블록 실행하기
    @Test
    public void runnableWithLambda() {
        new Thread(() -> System.out.println("Hello, world!"));
    }
}


