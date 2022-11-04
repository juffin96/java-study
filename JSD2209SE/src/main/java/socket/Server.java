package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    /**
     * 运行在服务端的ServerSocket主要的工作
     * 1.向系统申请并打开服务端口，客户端就是通过这个端口与服务器建立连接的
     * 2.监听服务端口，一旦一个客户顿与服务端建立连接则立即返回一个Socket
     * 服务端就可以通过该Socket与客户端对等连接进行通讯。
     * ServerSocket相当于是“总机”。
     */
    private ServerSocket serverSocket;

    public Server() {
        try {
            /*
             * 实例化ServerSocket时指定服务端口，如果该端口已经被系统其他应用程序占用那么会抛出异常
             * 解决办法：
             * 1.重新指定一个端口后重新启动服务端
             * 2.可能是重复启动了服务端导致的，先将之前启动的服务端关闭
             * 3.找到该端口被占用的程序，将其进程结束
             */
            System.out.println("正在启动服务端...");
            serverSocket = new ServerSocket(8088);
            System.out.println("服务端启动完毕...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            /*
             * Socket accept()
             * 该方法用于接收客户端的连接并返回一个Socket实例，使用这个实例就可以与连接的客户端双向通讯了
             * 注意：该方法是一个阻塞方法，如果调用时暂没有客户端连接，此时该方法会一致等待，知道一个客户端连接为止
             */
            System.out.println("等待客户端连接...");
            Socket socket = serverSocket.accept();
            System.out.println("一个客户端连接了！");
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println("客户端：" + s);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
