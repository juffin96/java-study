package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 缓冲字符流
 * BufferedWriter和BufferedReader
 * 缓冲流内部维护一个char数组，默认长度8k，以块读写方式读写字符数据包装效率。
 *
 * java.io.PrintWriter则是具有自动行刷新的缓冲字符输出流，其内部是连接着BufferedWriter这个流来实现缓冲功能的。
 */
public class PWDemo {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        // 按行想文件pw.txt中写入字符串
//        PrintWriter pw = new PrintWriter("pw.txt");
        PrintWriter pw = new PrintWriter("pw.txt", "UTF-8");
        pw.println("夜空中最亮的行，能否听清。");
        pw.println("那仰望的人，心底的孤独和叹息。");
        System.out.println("写出完毕！");
        pw.close();
    }
}
