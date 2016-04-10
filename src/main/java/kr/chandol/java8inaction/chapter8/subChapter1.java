package kr.chandol.java8inaction.chapter8;

import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static kr.chandol.java8inaction.chapter8.Dish.menu;
import static kr.chandol.java8inaction.chapter8.subChapter1.exam2.CaloricLevel.*;

public class subChapter1 {

    @Test
    public void exam1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello!");
            }
        };

        Runnable r2 = () -> System.out.println("Hello");
    }

    public static class exam2 {

        public enum CaloricLevel {
            DIET, NORMAL, FAT
        }

        @Test
        public void exam2() {
            menu.stream().collect(Collectors.groupingBy(dish -> {
                if (dish.getCalories() <= 400) return DIET;
                else if (dish.getCalories() <= 700) return NORMAL;
                else return FAT;
            }));

            menu.stream().collect(Collectors.groupingBy(this::getCaloricLevel));
        }

        public CaloricLevel getCaloricLevel(Dish dish) {
            if (dish.getCalories() <= 400) return DIET;
            else if (dish.getCalories() <= 700) return NORMAL;
            else return FAT;
        }
    }

    @Test
    public void exam3(){
        // JUL

        //자바 클래식
        Logger logger = Logger.getLogger("test!!");
        if(logger.isLoggable(Level.FINE)){
            logger.fine("메시지!!");
        }

        //자바8
        logger.fine(()->"메시지");
    }

}
