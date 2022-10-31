package file;

import java.io.File;
import java.io.FileFilter;

public class Test2 {
    public static void main(String[] args) {
        File dir = new File(".");
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().startsWith("test");
            }
        });
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }

        System.out.println("-----------------");

        File[] files1 = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().contains("t");
            }
        });
        if (files1 != null) {
            for (File file : files1) {
                System.out.println(file.getName());
            }
        }
    }
}
