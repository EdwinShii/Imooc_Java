package Base.Socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by Edwin_1993 on 2018/8/10.
 */
public class ServerThread extends Thread{
    Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        try {
            //            获取客户端的信息
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            bufferedReader = new BufferedReader(isr);
            String info = null;
            while ((info = bufferedReader.readLine())!=null){
                System.out.println("client info : " + info);
            }
            socket.shutdownInput();
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            printWriter.write("welcome");
            printWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //           关闭资源
            try{
                printWriter.close();
                outputStream.close();
                bufferedReader.close();
                isr.close();
                is.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
