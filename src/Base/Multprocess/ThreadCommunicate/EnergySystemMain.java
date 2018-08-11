package Base.Multprocess.ThreadCommunicate;

/**
 * Created by Edwin_1993 on 2018/8/11.
 */
public class EnergySystemMain {
    public static final int BOX_AMOUNT = 100;

    public static final double INITIAL_ENERGY = 1000;

    public static void main(String args[]){
        EnergySystem energySystem = new EnergySystem(BOX_AMOUNT,INITIAL_ENERGY);
        for (int i = 0; i <  BOX_AMOUNT; i++) {
            EnergyTransferTask energyTransferTask = new EnergyTransferTask(energySystem,i,INITIAL_ENERGY);
            Thread thread = new Thread(energyTransferTask,"TransferThread_"+i);
            thread.start();
        }
    }
}
