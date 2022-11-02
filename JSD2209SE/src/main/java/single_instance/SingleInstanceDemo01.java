package single_instance;

/**
 * 单例设计模式
 */
public class SingleInstanceDemo01 {
    public static void main(String[] args) {
        // 懒汉单例设计模式获取对象
        SingleInstance01 ins = SingleInstance01.getInstance();
        SingleInstance01 ins2 = SingleInstance01.getInstance();
        System.out.println(ins == ins2);
        // 饿汉单例设计模式获取对象
        SingleInstance02 ins3 = SingleInstance02.getInstance();
        SingleInstance02 ins4 = SingleInstance02.getInstance();
        System.out.println(ins3 == ins4);
    }
}