package Base.Multprocess.ThreadCommunicate;

/**
 * Created by Edwin_1993 on 2018/8/11.
 */
public class EnergySystem {
    private final double[] energyBoxes;
    private final Object lockObj = new Object();

    public EnergySystem(int n, double initialEnergy) {
        energyBoxes =  new double[n];
        for (int i = 0; i < energyBoxes.length ; i++) {
            energyBoxes[i] = initialEnergy;
        }
    }

    /**
     * energy transfer from one box to another
     * @param from
     * @param to
     * @param amount
     */
    public void transfer(int from ,int to, double amount){

//        通过synchronized进行互斥
        synchronized (lockObj){
//            if (energyBoxes[from] < amount){
//                System.out.println("not enought energy");
//                return;
//            }

//            满足while条件时，任务被阻挡，不去竞争CPU资源。
            while (energyBoxes[from] < amount){
                try {
                    lockObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(Thread.currentThread().getName());
            energyBoxes[from] -= amount;
            System.out.printf("从 %d 转移 %10.2f 单位能量到 %d",from,amount,to);
            energyBoxes[to] += amount;
            System.out.printf("能量总合: %10.2f \n", getTotalEnergy());

        }

//        非互斥模式
//        if (energyBoxes[from] < amount){
//            System.out.println("not enought energy");
//            return;
//        }
//        System.out.print(Thread.currentThread().getName());
//        energyBoxes[from] -= amount;
//        System.out.printf("从 %d 转移 %10.2f 单位能量到 %d",from,amount,to);
//        energyBoxes[to] += amount;
//        System.out.printf("能量总合: %10.2f", getTotalEnergy());

//        唤醒所有在lockObj上等待的线程。
        lockObj.notifyAll();
    }

    public double getTotalEnergy(){
        double sum = 0;
        for (double amount: energyBoxes){
            sum += amount;
        }
        return sum;
    }

    public int getBoxLength(){
        return energyBoxes.length;
    }
}
