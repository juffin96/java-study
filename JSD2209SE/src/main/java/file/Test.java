package file;

import java.io.File;
import java.io.IOException;

/**
 * 在当前项目目录下新建10个文件，名字为：“test1.txt”---“test10.txt”
 */
public class Test {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            File file = new File("./test" + (i + 1) + ".txt");
            if (file.exists()) {
                System.out.println(file.getName() + "文件已存在！");
                return;
            } else {
                file.createNewFile();
                System.out.println(file.getName() + "创建成功！");
            }
        }
    }

}
