package single_instance;

/**
 * 懒汉单例设计模式
 */
public class SingleInstance01 {
    //1.构造器私有化
    private SingleInstance01() {

    }

    //2.提供静态成员变量存储一个对象
    private static SingleInstance01 ins = new SingleInstance01();

    //3.提供公开的方法获取对象
    public static SingleInstance01 getInstance() {
        return ins;
    }
}
