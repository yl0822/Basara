package socket;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author long.yl.
 * @Date 2016/6/5
 */
public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket listener = new ServerSocket(9090);
        while(true){
            Socket socket = listener.accept();
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("asdasd");
            }finally {
                socket.close();
                listener.close();
            }
        }
    }
}
