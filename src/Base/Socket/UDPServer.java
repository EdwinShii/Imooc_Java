package Base.Socket;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by Edwin_1993 on 2018/8/10.
 */
public class UDPServer {
    public static void main(String args[]){
        try {
//            创建服务器端的DatagramSocket,指定端口
            DatagramSocket socket = new DatagramSocket(8800);
//            创建数据报文,由于接受服务端的数据
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data,data.length);
//            接收数据
            System.out.println("服务器端启动...");
            socket.receive(packet);//此方法在接收到数据之前会一直阻塞
//            读取数据
            System.out.println("从客户端得到的数据为:"+ new String(data,0,packet.getLength()));
//            向客户端发送响应
//            定义客户端的地址,端口等
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            byte[] reMessage = "welcome".getBytes();
//            创建数据报
            DatagramPacket rePacket = new DatagramPacket(reMessage,reMessage.length,address,port);
//            响应
            socket.send(rePacket);
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
