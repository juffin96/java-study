package file;

import java.io.File;
import java.util.Arrays;

/**
 * 访问一个目录中的所有子项
 */
public class ListFilesDemo {
    public static void main(String[] args) {
        File dir = new File(".");
        /*
         * boolean isFile() 返回对象是否是一个文件
         * boolean isDirectory() 返回对象是否是一个目录
         */
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
            }
        }
    }
}
