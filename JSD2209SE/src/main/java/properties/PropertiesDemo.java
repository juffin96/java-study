package properties;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.put("admin", "123456");
        properties.setProperty("cjf", "666666");

        /*
         * 参数一：保存管道，字符输出流管道
         * 参数二：保存心得
         */
        properties.store(new FileWriter("./users.properties"), "no comments");
    }
}
