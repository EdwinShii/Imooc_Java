package Base.Socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Edwin_1993 on 2018/8/10.
 */
public class Client {
    public static void main(String args[]){
//        创建客户端的socket,指定服务器端的地址和端口
        try {
            Socket socket = new Socket("localHost",8888);
//            获取输出流发送登陆信息
            OutputStream os = socket.getOutputStream();

//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
//            User user = new User("edwin","123")
//            objectOutputStream.writeObject(user);
            PrintWriter pw = new PrintWriter(os);
            pw.write("userName:edwin2;key:123");
            pw.flush();

            socket.shutdownOutput();
//            获取输入流来获取服务器端的响应
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String info = null;
            while ((info = bufferedReader.readLine())!= null){
                System.out.println("server said:"+info);
            }
//            关闭资源
            bufferedReader.close();
            inputStream.close();

            pw.close();
            os.close();
            socket.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
