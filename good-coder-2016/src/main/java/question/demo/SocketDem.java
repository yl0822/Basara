package question.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author long.yl.
 * @Date 2016/6/22
 */
public class SocketDem {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("server start ... ");
                SocketServer.start();
            }
        });
        thread.start();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("client send ... ");
                SocketClient.send();
            }
        });
        thread1.start();
        while (true) {

        }
    }

    static class SocketServer {
        public static void start() {
            try {
                ServerSocket server = new ServerSocket(8022);
                // 循环
                while (true) {
                    // 阻塞
                    Socket socket = server.accept();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    // 获取从客户端读入的字符串
                    String result = bufferedReader.readLine();
                    System.out.println("Client say : " + result);

                    /** 发送服务端准备传输的 */
                    // 由Socket对象得到输出流，并构造PrintWriter对象
                    PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                    printWriter.print("hello Client, I am Server!");
                    printWriter.flush();

                    /** 关闭Socket*/
                    printWriter.close();
                    bufferedReader.close();
                    socket.close();
                }
            } catch (Exception e) {
            }
        }
    }

    static class SocketClient {
        public static void send() {
            try {
                Socket socket = new Socket("localhost", 8022);

                PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                printWriter.print("hello Server, I am Client!");
                printWriter.flush();

                /** 关闭Socket*/
                printWriter.close();
                socket.close();
            } catch (Exception e) {
            }
        }
    }
}
