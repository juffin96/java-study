package hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestDemo {
    public static void main(String[] args) {
        Map<Student, String> map = new HashMap<>();
        map.put(new Student("zhangsan", 23), "2");
        map.put(new Student("zhangsan", 23), "2");
        map.put(new Student("zhangsan", 23), "2");
        map.put(new Student("zhangsan", 23), "1");
        Set<Map.Entry<Student, String>> entries = map.entrySet();
        for (Map.Entry<Student, String> entry : entries) {
            System.out.println(entry);
        }
    }
}
