package socket;

import io.PrintDemo;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 客户端
 *
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
    public synchronized void start() {
        try {
            ServerHandler handler = new ServerHandler();
            Thread t = new Thread(handler);
            t.setDaemon(true);
            t.start();
            /*
             * 获取一个字节输出流，使用这个流可以将数据发送给对方
             */
            OutputStream out = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8)), true);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String line = scanner.nextLine();
                if ("exit".equalsIgnoreCase(line)) {
                    pw.close();
                    break;
                }
                pw.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ServerHandler implements Runnable {
        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

}
