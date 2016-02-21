package kr.chandol.java8.chpater3;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class subChapter3 {


    private void doSomething() {
    }

    void legacyProcessFile() {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("data.txt"));
            doSomething();
        } //
        catch (IOException e) {
            throw new RuntimeException("예외발생", e);
        } //
        finally {
            try {
                if (br != null) br.close();
            } //
            catch (IOException ignored) {
            }
        }`
    }


    @FunctionalInterface
    interface BufferedReaderProcess {
        String process(BufferedReader b) throws IOException;
    }

    String processFile(BufferedReaderProcess p) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            return p.process(br);
        } catch (IOException e) {
            throw new RuntimeException("예외발생", e);
        }
    }

    @Test
    public void runner() {
        String oneLine
                = processFile((br) -> br.readLine());
        String twoLines
                = processFile((br) -> br.readLine() + br.readLine());
    }

}
