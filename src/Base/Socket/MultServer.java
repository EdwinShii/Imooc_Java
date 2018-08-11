package Base.Socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Edwin_1993 on 2018/8/10.
 */
public class MultServer {
    public static void main(String args[]){
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = null;
            System.out.println("server starting...");
            int count = 0;
            while (true){
                socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.setPriority(4);//设置线程优先级，[1-10]，默认5
                serverThread.run();

                count ++;
                System.out.println("num of client:"+count);

                InetAddress inetAddress = socket.getInetAddress();
                System.out.println("IP:"+inetAddress.getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
