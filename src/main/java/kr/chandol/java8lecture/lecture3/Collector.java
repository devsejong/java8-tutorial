package kr.chandol.java8lecture.lecture3;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

public interface Collector<T, A, R> {

    // 새로운 결과 컨테이너 만들기 누적자 인스턴스를 만들어준다.
    // Coleltor 결과값들이 모이는 시작점
    Supplier<A> supplier();

    // 결과 컨테이너에 요소 추가하기
    // accumulator메서드는 리듀싱 연산을 수행하는 함수를 반환한다.
    // 누적자와 n번째 요소가 람다의 인자로 들어가며, 연산을 통해서 값을 누적해나간다.
    BiConsumer<A, T> accumulator();

    //두 결과 컨테이너의 병합
    //스트림의 서로 다른 서브파트를 병렬로 처리할 때
    // 누적자가 이 결과를 어떻게 처리할지를 정의한다.
    BinaryOperator<A> combiner();

    // 최종 변환값을 결과 컨테이너에 적용하기
    // 스트림 탐색을 끝내고, 누적자 개게를 최종결과로 변환하면서
    // 누적과정을 끝낼때 호출할 함수를 반환하여야 한다.
    Function<A, R> finisher();

    // 연산에 대한 속성값을 지정
    // 스트림을 어떻게 처리할지에 대한 힌트를 제공하여 준다.

    // UNORDERED : 리듀싱 결과는 스트림 요소의 방문순서나 누적순서에 영향을 받지 않는다.
    // CONCURRENT : 다중스레드에서 accumulator를 동시에 호출할 수 있으며, 이 컬렉터는 스트림의 병렬 리듀싱을 수행할 수 있다.
    // IDENTITY_FINISH : finisher 메서드가 반환하는 함수는 단순히 identity를 적용할 뿐이므로 이를 생략한다.
    Set<java.util.stream.Collector.Characteristics> characteristics();

}