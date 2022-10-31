package file;

import java.io.File;

public class MkDirDemo {
    public static void main(String[] args) {
        //在当前目录下创建一个名为 demo 的目录
//        File dir = new File("./demo");
        File dir = new File("./a/b/c/d/e/f");
        if (dir.exists()) {
            System.out.println("该目录已存在！");
        } else {
            /*
             * mkdir()在创建一个目录时，要求该目录所在的目录必须存在，否则无效
             * mkdirs()在创建一个目录时，会自动创建该目录的父目录
             */
//            dir.mkdir();
            dir.mkdirs();
            System.out.println("创建成功！");
        }
    }
}
