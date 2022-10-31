package lambda;

import java.io.File;
import java.io.FileFilter;

public class LambdaDemo {
    public static void main(String[] args) {
        FileFilter f1 = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        };

        FileFilter f2 = f -> f.getName().endsWith(".txt");

    }
}
