package enum_instance;

public class EnumDemo {
    public static void main(String[] args) {
        Sex s1 = Sex.BOY;
        System.out.println(s1); // BOY
        System.out.println(s1.ordinal()); // 枚举对象的索引位置
        Sex s2 = Sex.GIRL;
        System.out.println(s2);
        System.out.println(s2.ordinal());
    }
}
