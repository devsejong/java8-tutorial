package kr.chandol.java8.chapter8.selfstudy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

// https://github.com/qos-ch/slf4j/pull/70
public class LoggingSample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingSample.class);

    public static void main(String[] args){
        // JUL보다는 slf4j를 사용합시닷!!
        logger.debug("it takes looooooooong time : {}", "test");

        logger.debug("parameter base class : {}", new TenSecondToStringClazz());

//        if(logger.isDebugEnabled()){
//            logger.debug("it takes looooooooong time : {}", new TenSecondToStringClazz());
//        }

//        logger.debug("it takes looooooooong time : {}", ()-> new TenSecondToStringClazz());
    }

    static class TenSecondToStringClazz {

        @Override
        public String toString() {
//            return "그냥 toString";

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "5초가 걸리는 toString 작업입니다.";
        }
    }
}


