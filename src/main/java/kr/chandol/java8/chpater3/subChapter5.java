package kr.chandol.java8.chpater3;

import org.junit.Test;

/**
 * Created by sejongpark on 2016. 2. 17..
 */
public class subChapter5 {

    @Test
    public void test(){
        int portNumber = 1337;
        Runnable r = () -> System.out.println(portNumber);
        //아래의 주석을 지울경우 에러 발생.
        //portNumber = 31337;


    }
}
