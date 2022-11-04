package exception;

public class ThrowDemo {
    public static void main(String[] args) {
        Person person = new Person();
        try {
            person.setAge(10000);
        } catch (IllegalAgeException e) {
            e.printStackTrace();
        }
        System.out.println(person.getAge());
    }
}
