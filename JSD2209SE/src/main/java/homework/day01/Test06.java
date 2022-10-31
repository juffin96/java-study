package homework.day01;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

/**
 * 列出当前目录中所有名字包含s的子项
 * 使用匿名内部类和Lambda两种写法
 */
public class Test06 {
    public static void main(String[] args) throws Exception {
        // 创建一个文件对象指向该项目的根目录
        File dir = new File(".");
        // 判断是否是目录
        if (dir.isDirectory()) {
            // 使用匿名内部类筛选出该目录下包含s的子项存放到文件的数组中
            File[] subs = dir.listFiles(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    // 返回包含s的子项
                    return file.getName().contains("s");
                }
            });
            // 遍历筛选后的数组
            for (int i = 0; i < subs.length; i++) {
                // 输出数组的各个子项
                System.out.println(subs[i].getName());
            }
            // 使用Lambda，并遍历
            Arrays.stream(dir.listFiles(file -> file.getName().contains("s"))).forEach(System.out::println);
        }
    }
}
