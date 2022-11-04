package io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CommonsIODemo01 {
    public static void main(String[] args) throws IOException {
        // 1.完成文件复制
        IOUtils.copy(new FileInputStream("./kunkun.png"), new FileOutputStream("./kunkun_cp2.png"));

        // 2.完成文件复制到某个文件夹下
        FileUtils.copyFileToDirectory(new File("./kunkun.png"), new File("D:/"));
    }
}
