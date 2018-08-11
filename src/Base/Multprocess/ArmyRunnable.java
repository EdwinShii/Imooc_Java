package Base.Multprocess;

/**
 * Created by Edwin_1993 on 2018/8/11.
 */
public class ArmyRunnable implements Runnable{
//    volatile 保证了线程可以正确读取其它线程写入的值
//    一旦一个共享变量（类的成员变量、类的静态成员变量）被volatile修饰之后，那么就具备了两层语义：
//
//    1）保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
//
//    2）禁止进行指令重排序
    volatile boolean keepRunning = true;

    @Override
    public void run() {
        while (keepRunning){
            for(int i = 0;i <5;i++){
                System.out.println(Thread.currentThread().getName() + "attack["+i+"]");
//                t
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName() + "end attack");
    }
}
