package lambda;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Arrays.stream(new File(".").listFiles(File::isFile)).forEach(System.out::println);
    }
}
