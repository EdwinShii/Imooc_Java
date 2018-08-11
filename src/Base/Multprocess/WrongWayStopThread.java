package Base.Multprocess;

/**
 * Created by Edwin_1993 on 2018/8/11.
 */
public class WrongWayStopThread extends Thread {
    public static void main(String args[]){
        WrongWayStopThread wrongWayStopThread = new WrongWayStopThread();
        System.out.println("Thread starting ...");
        wrongWayStopThread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread interrupting ...");
        wrongWayStopThread.interrupt();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread ending ...");
    }

    public void run(){
//        while (true){
        while (!this.isInterrupted()){
            System.out.println("Thread is running ...");
            long time = System.currentTimeMillis();
            while((System.currentTimeMillis() - time) < 1000){

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
