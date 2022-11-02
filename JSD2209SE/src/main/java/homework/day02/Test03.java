package homework.day02;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * 设计一个User类
 * 要求用户顺序输入信息，
 * 然后实例化一个User对象保存着四个信息，
 * 并将该对象序列化到文件中。
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        // 用户输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入名字");
        String name = scanner.next();
        System.out.println("请输入密码");
        String pwd = scanner.next();
        System.out.println("请输入昵称");
        String nick = scanner.next();
        System.out.println("请输入年龄");
        int age = scanner.nextInt();
        User user = new User(name, pwd, nick, age);
        File file = new File(user.getName() + ".obj");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(user);
        System.out.println("写入完毕");
        oos.close();
    }
}
