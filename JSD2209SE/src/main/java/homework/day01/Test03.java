package homework.day01;

import java.io.File;
import java.util.Scanner;

/**
 * 在控制台输入一个目录名，然后将这个目录创建在当前项目目录下
 */
public class Test03 {
    public static void main(String[] args) {
        String dirName = new Scanner(System.in).next();
        File dir = new File("./" + dirName);
        if (!dir.exists()) {
            dir.mkdirs();
            System.out.println("目录创建成功！");
        }else {
            System.out.println("目录创建失败！");
        }
    }
}
