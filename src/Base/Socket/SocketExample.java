package Base.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Created by Edwin_1993 on 2018/8/9.
 */
public class SocketExample {

    public static void useInetAddress(){
        try {
            //        获取本机的InetAddress
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("计算机名" + inetAddress.getHostName());
            System.out.println("计算机IP" + inetAddress.getHostAddress());
            System.out.println(inetAddress);

//            其它获取inetAddress的方式
//            InetAddress inetAddress2 = InetAddress.getByName("Edwin");
//            InetAddress inetAddress3 = InetAddress.getByName("1.1.1.10");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void useURL(){
        try {
//            创建URL实例
            URL immoc = new URL("http://www.imooc.com");
            URL url = new URL(immoc,"/index.html?username=tom#test");

            System.out.println("协议:"+ url.getProtocol());
            System.out.println("Host:"+ url.getHost());
//            如果为指定端口号，则为-1
            System.out.println("Port:" + url.getPort() );
            System.out.println("filePath:" + url.getPath());
            System.out.println("fileName:" + url.getFile());
            System.out.println("相对路径:"+ url.getRef());
            System.out.println("查询字符串:"+ url.getQuery());



            URL baidu = new URL("http://www.baidu.com");
//            通过URL对象的openStream方法可以获取指定资源的输入流
            InputStream inputStream = baidu.openStream();
//            将字节输入流转为字符输入流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");
//            添加缓冲 提高效率
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String data = bufferedReader.readLine();
            while (data!=null){
                System.out.println(data);
                data = bufferedReader.readLine();
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
