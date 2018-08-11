package Base.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Edwin_1993 on 2018/8/10.
 */
public class Server {
    public static void main(String args[]){
        try {
//       创建服务器端的socket,绑定指定的端口并监听
            ServerSocket serverSocket = new ServerSocket(8888);
//            调用accept监听
            System.out.println("等待客户端链接");
            Socket socket = serverSocket.accept();
//            获取客户端的信息
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(isr);
            String info = null;
            while ((info = bufferedReader.readLine())!=null){
                System.out.println("client info : " + info);
            }
            socket.shutdownInput();

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("welcome");
            printWriter.flush();

//           关闭资源
            printWriter.close();
            outputStream.close();

            bufferedReader.close();
            isr.close();
            is.close();
//            socket关闭的时候，相关联的输入输出流也会自动关闭
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
