package chapter2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.channels.NetworkChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;

/**
 * Created by zhangyue-k on 2017/8/21.
 * User:zhangyue-k
 * Date:2017/8/21
 */

//NetWorkChannel选项
public class NetWorkChannelOptions {

    public static void main(String[] args) {
        SelectorProvider provider = SelectorProvider.provider();
        try{

            NetworkChannel socketChannel = provider.openSocketChannel();
            SocketAddress address = new InetSocketAddress(8080);
            socketChannel = socketChannel.bind(address);
            Set<SocketOption<?>> socketOptions = socketChannel.supportedOptions();
            System.out.println(socketOptions.toString());

            socketChannel.setOption(StandardSocketOptions.IP_TOS,3);

            Boolean keepAlive = socketChannel.getOption(StandardSocketOptions.SO_KEEPALIVE);
            System.out.println(keepAlive);

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
