import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class CarTransporter extends Truck implements Dumpy{
    private int maxCars;
    private ArrayList<Car> cars;
    private Boolean platformIsLowered;
    private double proximityRange;

    public CarTransporter(){
        super(2,300, Color.PINK,"CarTransporter");
        cars = new ArrayList<>();
        maxCars = 5;
        platformIsLowered = false;
        proximityRange = 3;
    }

    @Override
    public void move(){
        super.move();
        for (Car car : cars){
            car.setX(getX());
            car.setY(getY());
        }
    }

    @Override
    public void raisePlatform(double amount){
    }

    @Override
    public void lowerPlatform(double amount){
    }

    public void raisePlatform(){
        if (getCurrentSpeed()==0){
            platformIsLowered = false;
        }
    }

    public void lowerPlatform(){
        if (getCurrentSpeed()==0){
            platformIsLowered = true;
        }
    }

    public void loadCar(Car car){
        if((cars.size() < maxCars) && platformIsLowered && isInProximity(car)){
            cars.add(car);
            car.setX(getX());
            car.setY(getY());
        }
    }

    public void unloadCar() {
        Car unloadedCar = null;
        if (platformIsLowered && cars.size() > 0) {
            unloadedCar = cars.get(cars.size() - 1);
            unloadedCar.changeY(1);
            unloadedCar.changeX(1);
            cars.remove(cars.size() - 1);
        }
    }
    public ArrayList<Car> getLoadedCars(){return cars;}
    public Boolean isInProximity(Car car){
        double carX = car.getX();
        double carY = car.getY();
        return (abs(getX()-carX) < proximityRange && abs(getY()-carY) < proximityRange);
    }
}
