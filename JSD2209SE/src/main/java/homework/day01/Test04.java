package homework.day01;

import java.io.File;
import java.util.Scanner;

/**
 * 在控制台输入一个目录名，然后将当前项目目录下的这个目录删除。（只要求删除Test03创建的空目录）
 */
public class Test04 {
    public static void main(String[] args) {
        String fileName = new Scanner(System.in).next();
        File file = new File("./" + fileName);
        if (!file.exists()) {
            file.delete();
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }
}
