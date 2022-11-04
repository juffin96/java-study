package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ISRDemo {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("./src/main/java/io/ISRDemo.java"), StandardCharsets.UTF_8);
        int d;
        while ((d = isr.read())!=-1){
            System.out.print((char) d);
        }
        isr.close();
    }
}
