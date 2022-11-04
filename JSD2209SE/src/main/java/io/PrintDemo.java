package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintDemo {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream(new FileOutputStream("ps.txt", true));
        ps.println(97);
        ps.println('a');
        ps.println(23.3);
        ps.println(true);
        ps.println("我是打印输出的");
        ps.close();

        PrintWriter pw = new PrintWriter("./pw.txt");
        pw.println("123");
        pw.println("456");
        pw.println("789");
        pw.close();
    }
}
