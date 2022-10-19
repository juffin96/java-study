package io.juffin96.github;

/**
 * 1、建立一个Java抽象类Drink，
 * a、声明一个抽象方法taste() 该方法负责输出饮料的味道
 * b、声明int型常量来代表不同的饮料类型 咖啡、啤酒、牛奶
 * c、声明静态工厂方法getDrink(int drinkType) 根据传入的参数创建不同的饮料对象 并返回该对象 建议使用switch语句。该方法要求声明DrinkNotFoundException 当没有相对应的饮料类型时 抛出该异常。
 */
public abstract class Drink {
    public static final int COFFEE = 1;
    public static final int BEER = 2;
    public static final int MILK = 3;

    public static Drink getDrink(int drinkType) {
        try {
            return switch (drinkType) {
                case COFFEE -> new Coffee();
                case BEER -> new Beer();
                case MILK -> new Milk();
                default -> throw new DrinkNotFoundException();
            };
        } catch (DrinkNotFoundException e) {
            System.out.println(e + " 找不到对应类型的饮料！");
        }
        return null;
    }

    public abstract void taste();
}
