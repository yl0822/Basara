package jdk.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * Created by long.yl on 2016/7/11.
 */

public class AIOClient {

    public static void main(String... args) throws Exception {
        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
        client.connect(new InetSocketAddress("localhost", 9888));
        client.write(ByteBuffer.wrap("test".getBytes())).get();
    }
}
