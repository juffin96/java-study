package exception;

public class Person {
    private int age;

    public Person() {
    }

    public Person(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) throws IllegalAgeException{
        if (age < 0 || age > 100){
            throw new IllegalAgeException("年龄不合法");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{age = " + age + "}";
    }
}
