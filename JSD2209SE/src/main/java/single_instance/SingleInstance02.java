package single_instance;

/**
 * 饿汉单例设计模式
 */
public class SingleInstance02 {
    //1.构造器私有化
    private SingleInstance02() {

    }

    //2.提供静态成员变量存储一个对象，但是没有直接创建出来！
    private static SingleInstance02 ins;

    //3.提供公开的方法获取对象
    public static SingleInstance02 getInstance() {
        // 第一次不存在对象才创建一个返回
        if (ins == null) {
            ins = new SingleInstance02();
        }
        return ins;
    }
}
