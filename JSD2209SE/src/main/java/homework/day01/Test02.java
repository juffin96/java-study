package homework.day01;

import java.io.File;

/**
 * 将当前项目目录下1.txt-100.txt文件删除
 */
public class Test02 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            File file = new File("./" + i + ".txt");
            if (file.exists()) {
                file.delete();
                System.out.println(file.getName() + "文件删除成功");
            }else {
                System.out.println("文件不存在");
            }
        }
    }
}
