package homework.day02;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String pwd;
    private String nick;
    private int age;

    public User() {
    }

    public User(String name, String pwd, String nick, int age) {
        this.name = name;
        this.pwd = pwd;
        this.nick = nick;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 获取
     * @return nick
     */
    public String getNick() {
        return nick;
    }

    /**
     * 设置
     * @param nick
     */
    public void setNick(String nick) {
        this.nick = nick;
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
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{name = " + name + ", pwd = " + pwd + ", nick = " + nick + ", age = " + age + "}";
    }
}
