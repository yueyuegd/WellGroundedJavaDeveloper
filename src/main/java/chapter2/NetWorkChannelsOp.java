package chapter2;

import java.io.IOException;
import java.net.*;
import java.nio.channels.DatagramChannel;
import java.nio.channels.MembershipKey;

/**
 * Created by zhangyue-k on 2017/8/21.
 * User:zhangyue-k
 * Date:2017/8/21
 */
//以下代码实现了如何加入IP为180.90.4.12的多播组并对其发送和接收系统状态信息
public class NetWorkChannelsOp {

    public static void main(String[] args) {
        try{
            NetworkInterface networkInterface = NetworkInterface.getByName("net1");
            DatagramChannel dc = DatagramChannel.open(StandardProtocolFamily.INET);
            dc.setOption(StandardSocketOptions.SO_REUSEADDR,true);
            dc.bind(new InetSocketAddress(8080));
            dc.setOption(StandardSocketOptions.IP_MULTICAST_IF,networkInterface);
            InetAddress group = InetAddress.getByName("180.90.4.12");
            MembershipKey key = dc.join(group,networkInterface);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
