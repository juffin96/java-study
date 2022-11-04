package homework.day03;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 一个简易记事本工具
 * 将控制台上输入的每一行字符串按行写入到该文件中，单行输入exit退出程序。
 */
public class TestDemo {
    public static void main(String[] args) throws FileNotFoundException {
//        PrintStream ps = new PrintStream(new FileOutputStream("node.txt", true));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("node.txt", true), StandardCharsets.UTF_8)), true);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = scanner.nextLine();
            if ("exit".equalsIgnoreCase(s)) {
                break;
            } else {
                pw.print(s);
            }
        }
        pw.close();
    }
}
