package homework.day01;

import java.io.File;
import java.util.Scanner;

/**
 * 程序启动后，输入一个用户名，如果文件存在则提示并要求用户更换，
 * 直到该文件还不存在为止，然后将这个文件在当前目录中创建出来。
 */
public class Test05 {
    public static void main(String[] args) throws Exception{
        // 创建一个键盘扫描器对象用来接收用户输入
        Scanner scanner = new Scanner(System.in);
        // 定义一个死循环来不断接收用户输入的内容，执行相应操作
        while (true) {
            // 提示用户输入
            System.out.println("请输入用户名：");
            // 定义一个字符串变量来接收用户输入
            String fileName = scanner.nextLine();
            // 创建文件对象
            File file = new File(fileName);
            // 判断文件在项目目录中是否存在
            if (file.exists()) {
                // 提示用户文件已存在
                System.out.println("该文件已存在，请更换名字");
            } else {
                // 若不存在则创建
                file.createNewFile();
                // 提示用户文件创建完毕
                System.out.println("文件创建完毕！");
                // 跳出死循环
                break;
            }
        }
    }
}
