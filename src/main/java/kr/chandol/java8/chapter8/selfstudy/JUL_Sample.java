package kr.chandol.java8.chapter8.selfstudy;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JUL_Sample {
    private static Logger logger = Logger.getLogger("LoggingSample");

    private static String compute() {
        return "test";
    }

    public static void main(String[] args) {
        logger.log(Level.FINER, "테스트입니다." + compute());

        if(logger.isLoggable(Level.FINER)){
            logger.log(Level.FINER, compute());
        }
        //logger.log(Level.FINER, () -> compute());
    }
}


