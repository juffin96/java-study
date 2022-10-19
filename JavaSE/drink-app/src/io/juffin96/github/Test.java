package io.juffin96.github;

import java.util.Scanner;

/**
 * 4、建立Test测试类 测试以上内容的正确性
 * a、编写main方法 通过命令行传参的方式传入某种饮料的类型。
 * b、在main方法中 调用Drink类的getDrink方法 获得相应的饮料对象。注意捕获DrinkNotFoundException。
 * c、然后调用该饮料对象的taste()方法 输出该饮料的味道
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请问要喝什么饮料：\t1.咖啡\t2.啤酒\t3.牛奶");
        int drinkType = sc.nextInt();
        Drink drink = Drink.getDrink(drinkType);
        if (drink != null) {
            drink.taste();
        }
    }
}
