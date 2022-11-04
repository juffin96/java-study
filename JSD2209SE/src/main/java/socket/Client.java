package socket;

import java.io.IOException;
import java.net.Socket;

/**
 * 客户端
 * @author Chen
 */
public class Client {
    /*
     * Socket封装了TCP协议的通讯细节，使用它可以与服务端建立TCP连接
     * 并获取两条流（一条输入、一条输出）进行读写完成与远端计算机的交互。
     */
    private Socket socket;
    /**
     * 初始化客户端
     */
    public Client() {
        try {
            /*
             * 参数一：服务端的IP地址
             * 参数二：服务端对外打开的服务端口
             * 实例化的过程是与服务端建立连接的过程，此时会根据给定的服务端IP去网络上找到服务器计算机
             * 再根据其对外打开的端口来连接服务端的应用程序
             */
            System.out.println("正在连接服务端...");
            socket = new Socket("localhost", 8088);
            System.out.println("与服务端建立连接！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 启动客户端
     */
    public void start() {

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }
}
