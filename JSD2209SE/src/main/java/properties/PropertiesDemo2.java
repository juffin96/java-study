package properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo2 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("./users.properties"));
        String rs = properties.getProperty("cjf");
        System.out.println(rs);
    }
}
