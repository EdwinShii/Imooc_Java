package Base.Multprocess;

/**
 * Created by Edwin_1993 on 2018/8/11.
 */
public class Stage extends Thread{
    public void run(){
        ArmyRunnable armyTaskOfSui = new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();

//        create Thread by using runnable interface
        Thread armyOfSui = new Thread(armyTaskOfSui,"隋朝军队");
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt,"农民军");

        armyOfSui.start();
        armyOfRevolt.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("key person appear");
        Thread mrCheng = new KeyPersonThread();
        mrCheng.setName("Mr cheng");

        armyTaskOfRevolt.keepRunning = false;
        armyTaskOfSui.keepRunning = false;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mrCheng.start();
        try {
//            join方法会使得所有线程等待该线程执行完毕
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ending --- ");

    }

    public static void main(String args[]){
        new Stage().run();
    }
}
