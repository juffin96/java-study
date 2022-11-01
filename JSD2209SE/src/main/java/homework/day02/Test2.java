package homework.day02;

import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) throws Exception {
        File file = new File("node.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        OutputStream os = new FileOutputStream(file, true); // append为true，会在文件中追加数据
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            byte[] bytes = line.getBytes(StandardCharsets.UTF_8);
            if ("exit".equalsIgnoreCase(line)) {
                System.out.println("退出成功");
                break;
            }
            os.write(bytes);
            os.flush(); // 写数据必须，刷新数据
        }
        os.close(); // 释放资源
    }
}
