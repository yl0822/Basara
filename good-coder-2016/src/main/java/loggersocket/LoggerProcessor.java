package loggersocket;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by long.yl
 * Created in 2016/8/9
 * Created on Basara_loggersocket
 */
public class LoggerProcessor implements Runnable{

    private volatile boolean stopped = false;
    private ServerSocket serverSocket;

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(8081);
        }catch (Exception e){
            e.printStackTrace();
        }
        while (!stopped){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            }catch (Exception e){
                continue;
            }
            // handle this socket off to an HttpProcessor

        }
    }
}
