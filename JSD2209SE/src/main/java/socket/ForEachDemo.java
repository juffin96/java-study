package socket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * forEach遍历
 */
public class ForEachDemo {
    public static void main(String[] args) {
        /**
         * ArrayList/LinkedList/HashSet都不是线程安全的集合
         * 使用Collections工具类的静态方法可以转换成线程安全的集合
         */
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        list.forEach(System.out::println);

        list = Collections.synchronizedList(list);
        System.out.println(list);
    }
}
