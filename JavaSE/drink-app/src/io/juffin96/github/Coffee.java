package io.juffin96.github;

/**
 * 2、建立Drink的具体子类
 * a、分别建立Drink的子类 Coffee 代表咖啡 Beer 代表啤酒 Milk 代表牛奶 ;
 * b、实现taste()方法 要求在控制台打印各自的味道特征。
 */
public class Coffee extends Drink {
    @Override
    public void taste() {
        System.out.println("苦味");
    }
}
