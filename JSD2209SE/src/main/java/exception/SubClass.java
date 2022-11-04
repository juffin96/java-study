package exception;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SubClass extends ThrowsDemo {
//    public void dosome() throws IOException, AWTException {}

    //允许仅抛出部分异常
//    public void dosome() throws IOException {}

    //允许抛出超类方法声明抛出异常的子类型异常
//    public void dosome() throws FileNotFoundException {}

    //允许不再抛出异常
//    public void dosome() {}
}
