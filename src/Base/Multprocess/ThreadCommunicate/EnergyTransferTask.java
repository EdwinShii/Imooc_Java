package Base.Multprocess.ThreadCommunicate;

/**
 * Created by Edwin_1993 on 2018/8/11.
 */
public class EnergyTransferTask implements Runnable {
    private EnergySystem energySystem;
    private int fromBox;
    private double maxAmount;

    private int DELAY = 1000;

    public EnergyTransferTask(EnergySystem energySystem, int fromBox, double maxAmount) {
        this.energySystem = energySystem;
        this.fromBox = fromBox;
        this.maxAmount = maxAmount;
    }

    @Override
    public void run() {
        try{
            while (true){
                int toBox = (int)(energySystem.getBoxLength()*Math.random());
                double amount = maxAmount * Math.random();
                energySystem.transfer(fromBox,toBox,amount);
                Thread.sleep(DELAY);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
