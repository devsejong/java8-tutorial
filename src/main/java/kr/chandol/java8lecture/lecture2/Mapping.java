package kr.chandol.java8lecture.lecture2;

import kr.chandol.java8inaction.chapter5.Dish;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static kr.chandol.java8inaction.chapter5.Dish.menu;

// 매핑
public class Mapping {
    @Test
    public void map() {
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
    }

    @Test
    public void flatMap() {
        //["hello", "world"]
        // 중복문자 필터링 후 단어 분리
        // ["h","e","l","o","w","r","d"]

        //아래와 같이 할 경우 잘못된 결과가 나옴
        List<String> words = Arrays.asList("hello", "world");
        List<String[]> collect = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());

        //역시나 Stream<Stream<String>>의 값으로 나오므로 문제가 해결되지 않는다.
        List<Stream<String>> collect2 = words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());

        System.out.println(collect2);

        // flatMap은 각 배열을 스트림이 아니라 스트림의 컨텐츠로 매핑한다
        // flatMap 메서드는 스트림의 각 값을 다른 스트림으로 만든 다으메 모든 스트림을 하나의 슽릠으로 연결하는 기능을 수행한다
        List<String> collect1 = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());

        System.out.println(collect1);
    }
}
