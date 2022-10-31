package file;

import java.io.File;

/**
 * 创建新文件
 * @author Chen
 */
public class CreateNewFileDemo {
    public static void main(String[] args) throws Exception{
        File file = new File("./test.txt");
        if (file.exists()) {
            System.out.println("该文件已存在！");
        }else {
            file.createNewFile();
            System.out.println("创建成功！");
        }
    }
}
