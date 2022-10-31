package file;

import java.io.File;
import java.net.URI;

/**
 * java.io.File
 * 1.访问该路径表示的文件或目录的属性信息
 * 2.创建和删除文件或目录
 * 3.访问一个目录中的子项
 * 但是不能访问文件的数据
 */
public class FileDemo {
    public static void main(String[] args) {
        /*
         * ./是一个常用的相对路径
         */
        File file = new File("./demo.txt");
        String name = file.getName();
        System.out.println(name);

        //返回的是文件的长度（字节）
        long length = file.length();
        System.out.println(length);

        boolean cr = file.canRead();
        boolean cw = file.canWrite();
        boolean ih = file.isHidden();
        System.out.println("是否可读:" + cr);
        System.out.println("是否可写:" + cw);
        System.out.println("是否隐藏:" + ih);
    }
}
