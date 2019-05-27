package dictionary;

import org.junit.Test;

public class ProgramTest {

    @Test
    public void test() {
        Program program = new Program();
        program.readFile("src/dictionary/File");
        program.processFile("src/dictionary/File2");
    }
}