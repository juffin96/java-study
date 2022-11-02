package binary;

public class Demo01 {
    public static void main(String[] args) {
        /*
         * 在编译阶段，将字面量都便以为2进制数
         * Integer.toBinaryString()按照内存实际存世的情况输出，输出的时候高位0省略
         */
        int n = 10000;
        System.out.println(Integer.toBinaryString(n));

        int n1 = 0b1111_1111_1111_1111_1111_1111_1111_1111; // 2进制直接量前缀0b，使用下划线分隔
        System.out.println(n1);
        int n2 = 0xFFFFFFFF;
        System.out.println(Integer.toBinaryString(n2));

        int x = 56;
        int y = ~x + 1;
        System.out.println(x);
        System.out.println(~56);

        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(~x));
        System.out.println(Integer.toBinaryString(~x + 1));

        // 最小值不能去相反数
        int min = Integer.MIN_VALUE;
        int k = -min;
        System.out.println(k);
    }
}
