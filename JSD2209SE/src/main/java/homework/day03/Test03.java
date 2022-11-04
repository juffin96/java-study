package homework.day03;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 改错
 * <p>
 * 程序实现的是简易记事本工具。程序启动后向pw.txt文件写内容
 * 用户输入的每一行字符串都写入到文件中，单独输入exit时
 * 程序退出。
 *
 * @author Xiloer
 */
public class Test03 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("pw.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osw);
        PrintWriter pw = new PrintWriter(bw, true);

        Scanner scanner = new Scanner(System.in);
        System.out.println("请开始输入内容");
        while (true) {
            String str = scanner.nextLine();
            if ("exit".equalsIgnoreCase(str)) {
                break;
            }
            pw.println(str);
        }
        pw.close();
    }
}
