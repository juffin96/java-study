package io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * 对象序列化：将一个java对象按照其结构转化为一组字节的过程
 * 对象反序列化：将一组字节按照其描述还原为一个Java对象的过程
 */
public class OOSDemo {
    public static void main(String[] args) throws Exception{
        String name = "刘桑";
        int age = 55;
        String gender = "男";
        String[] otherInfo = {"拍片技术一流", "技术好", "大家的启蒙老师"};
        Person p = new Person(name, age, gender, otherInfo);

        FileOutputStream fos = new FileOutputStream("person.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        /*
         * 执行writerObject()时，对象输出流在序列化时要求序列化的对象必须实现了Serializable接口
         *
         * 当我们将对象输出流连接到文件流上，把一个对象写出是，会经历以下操作：
         * 1.对象先经过对象输出流writerObject(p)，该方法会将该对象按照其结构转换为一组字节，
         *   这个过程称为对象序列化。
         * 2.对象输出流会将序列化后的一组字节再经过其连接的文件输出流最终将这组字节写入到文件中保存（写入磁盘），
         *   该过程称为：数据持久化。
         */
        oos.writeObject(p);
        System.out.println("写出完毕");
        oos.close();
    }
}
