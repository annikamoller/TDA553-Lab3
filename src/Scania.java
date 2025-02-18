import java.awt.*;

public class Scania extends Truck implements Dumpy{
    private float minDumpyAngle;
    private float maxDumpyAngle;
    private float currentAngle;

    public Scania(){
        super(2,225,Color.YELLOW,"Scania");
        minDumpyAngle = 0;
        maxDumpyAngle = 70;
        currentAngle = 0;
        imageDirectory = "pics/Scania.jpg";
    }

    @Override
    public void raisePlatform(double amount){
        if (getCurrentSpeed() == 0 && getCurrentAngle() > maxDumpyAngle){
            currentAngle += amount;
            if (getCurrentAngle() > maxDumpyAngle){
                currentAngle = maxDumpyAngle;
            }
        }
    }

    @Override
    public void lowerPlatform(double amount){
        if (getCurrentSpeed() == 0 && getCurrentAngle() > minDumpyAngle){
            currentAngle -= amount;
            if (getCurrentAngle() < minDumpyAngle){
                currentAngle = minDumpyAngle;
            }
        }
    }

    @Override
    public void gas(double amount){
        if (getCurrentAngle() == 0){
            super.gas(amount);
        }
    }

    public float getCurrentAngle(){
        return currentAngle;
    }
}
