package io.juffin96.github;

/**
 * 3、建立异常类DrinkNotFoundException
 * a、继承Exception
 * b、在Drink的方法getDrink(int drinkType)中声明引发DrinkNotFoundException异常 当传入的参数没有相对应的饮料类型时 抛出异常。
 * c、在使用getDrink方法的类中捕捉该异常。
 */
public class DrinkNotFoundException extends Exception {

}
