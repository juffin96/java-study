package file;

import java.io.File;

public class DeleteDirDemo {
    public static void main(String[] args) {
        File dir = new File("./demo");
        if (dir.exists()) {
            dir.delete();
            System.out.println(dir.getName() + "删除成功！");
        }else {
            System.out.println("目录不存在！");
        }
    }
}
