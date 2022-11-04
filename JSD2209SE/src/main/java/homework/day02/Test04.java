package homework.day02;

import java.io.*;

public class Test04 {
    public static void main(String[] args) throws IOException {
        File dir = new File(".");
        File[] subs = dir.listFiles(f -> f.getName().endsWith(".txt"));
        for (File sub : subs) {
            String filename = sub.getName();
            int index = filename.lastIndexOf(".");
            filename = filename.substring(0, index) + "_cp.txt";
//            filename = filename.replace(".txt", "_cp.txt");
            FileInputStream fis = new FileInputStream(sub);
            FileOutputStream fos = new FileOutputStream(filename);
            int d;
            byte[] data = new byte[1024*10];
            while ((d = fis.read(data)) != -1) {
                fos.write(data, 0, d);
            }
            fos.close();
            fis.close();
        }

    }
}
