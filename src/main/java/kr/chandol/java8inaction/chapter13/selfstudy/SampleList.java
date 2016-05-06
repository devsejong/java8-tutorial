package kr.chandol.java8inaction.chapter13.selfstudy;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by devse on 2016-04-15.
 */
public class SampleList {

    public void aa() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> anotherNumbers = numbers;

        anotherNumbers.add(10);

        assertThat(anotherNumbers.size(), is(6));
        assertThat(numbers.size(), is(5));
    }
}
