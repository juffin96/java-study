package charset;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws Exception {
        // 1.编码
        String str = "abc我爱你中国";
//        byte[] bytes = str.getBytes(); // 以当前代码默认字符集进行编码，UTF-8
        byte[] bytes = str.getBytes("GBK");
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));

        // 2.解码
        String rs = new String(bytes);
        System.out.println(rs);
    }
}
