package Base.Multprocess;

/**
 * Created by Edwin_1993 on 2018/8/10.
 */
public class ThreadExample extends Thread {
    public void run(){
        System.out.println(getName() + " threadExample");
        int count = 0;
        boolean keepRunning = true;
        while(keepRunning){
            System.out.println((getName()+ " num:" + ++count));

            if (count == 100){
                keepRunning = false;
            }
            if (count%10 == 0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(getName()+ " end");
    }


    public static void main(String args[]){
        Thread thread = new ThreadExample();
        thread.setName("ThreadExample");

        thread.start();

        Thread runnableThread = new Thread(new RunnableExample(),"Ms Runnable");
        runnableThread.start();
    }
}

class RunnableExample implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " RunnableExample");
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println((Thread.currentThread().getName() + " num:" + ++count));

            if (count == 100) {
                keepRunning = false;
            }
            if (count % 10 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}