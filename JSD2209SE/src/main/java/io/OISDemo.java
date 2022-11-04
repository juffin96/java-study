package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 使用对象输入流完成对象的反序列化
 */
public class OISDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 从person.obj文件中将对象反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.obj"));
        /*
         * Object readObject()
         * 该方法会进行对象的反序列化，如果对象流通过其连接的流读取字节分析并非是一个java对象是，会抛出异常ClassNotFoundException
         */
        Person o = (Person) ois.readObject();
        System.out.println(o);
        ois.close();
    }
}
