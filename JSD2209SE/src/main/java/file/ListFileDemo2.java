package file;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class ListFileDemo2 {
    public static void main(String[] args) {
        File dir = new File(".");
//        File[] subs = dir.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File file) {
//                String name = file.getName();
//                return name.endsWith(".txt");
//            }
//        });
        File[] subs = dir.listFiles(file -> file.getName().endsWith(".txt"));
        if (subs != null) {
            Arrays.stream(subs).forEach(sub -> System.out.println(sub.getName()));
        }
    }
}
