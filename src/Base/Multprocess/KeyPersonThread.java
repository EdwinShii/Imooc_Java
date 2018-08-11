package Base.Multprocess;

/**
 * Created by Edwin_1993 on 2018/8/11.
 */
public class KeyPersonThread extends Thread {
    public void run(){
        System.out.println(Thread.currentThread().getName() + "start the war");

        for (int i = 0 ;i< 10; i ++){
            System.out.println(Thread.currentThread().getName() +  "attack the Sui army");
        }
        System.out.println(Thread.currentThread().getName() + "end the war");
    }
}
