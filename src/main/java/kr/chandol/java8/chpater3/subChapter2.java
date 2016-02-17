package kr.chandol.java8.chpater3;

import org.junit.Test;

import java.util.Comparator;

public class subChapter2 {

    @Test
    public void lambda(){
        Comparator<Apple> appleComparator
                = (Apple a1, Apple a2) -> a1.getColor().compareTo(a2.getColor());
    }

}
