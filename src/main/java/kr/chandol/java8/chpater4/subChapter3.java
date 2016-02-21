package kr.chandol.java8.chpater4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static kr.chandol.java8.chpater4.Dish.menu;

public class subChapter3 {

    @Test(expected = IllegalStateException.class)
    public void 딱한번만탐색가능한스트림() {
        List<String> title = Arrays.asList("Java8", "In", "Action");

        Stream<String> s = title.stream();
        //title의 각 단어가 출력된다.
        s.forEach(System.out::println);
        //IllegalStateException이 발생된다. 스트림이 이미 소비되었거나 닫혔기 때문이다.
        s.forEach(System.out::println);
    }


    @Test
    public void 외부반복과내부반복() {
List<String> names = new ArrayList<>();
for(Dish d : menu){
    names.add(d.getName());
}

List<String> namesWithStream
        = menu.stream().map(Dish::getName).collect(toList());
    }

}
