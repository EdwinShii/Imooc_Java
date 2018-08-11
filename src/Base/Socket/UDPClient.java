package Base.Socket;

import java.io.IOException;
import java.net.*;

/**
 * Created by Edwin_1993 on 2018/8/10.
 */
public class UDPClient {
    public static void main(String args[]){
        try {
//            定义服务器地址
            InetAddress address =InetAddress.getByName("localHost");
            int port = 8800;
            byte[] data = "此为服务端数据内容".getBytes();
//            创建数据报
            DatagramPacket packet = new DatagramPacket(data,data.length,address,port);
//            创建socket
            DatagramSocket socket = new DatagramSocket();
//            发送
            socket.send(packet);
//            接收响应
            byte[] reMessage = new byte[1024];
            DatagramPacket repacket = new DatagramPacket(reMessage,reMessage.length);
            socket.receive(repacket);
            System.out.println(new String(reMessage));
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
