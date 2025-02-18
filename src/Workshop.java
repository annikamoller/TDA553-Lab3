import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends Car> {
    private int maxCarCapacity;
    private List<T> cars;
    private Class<?>[] acceptableCarTypes;

    private double x;
    private double y;

    public Workshop(int maxCarCapacity,double x, double y,Class<? extends Car>... brands){
        this.x = x;
        this.y = y;
        this.maxCarCapacity = maxCarCapacity;
        this.acceptableCarTypes = brands;
        this.cars = new ArrayList<>();
    }

    public void loadCar(T car){
        for(Class<?> brand : acceptableCarTypes){
            if(brand.isInstance(car)){
                if(cars.size() < maxCarCapacity){
                    cars.add(car);
                    car.setIsLoaded(true);
                }else{
                    System.out.println("The Workshop is full!");
                }
            }else{
                throw new IllegalArgumentException("Wrong car type!" + car.getClass().getName() + "is not an acceptable car type.");
            }
        }
    }

    public T unloadCar(int index){
        T unloadedCar = null;
        if (cars.get(index) != null){
            unloadedCar = cars.get(index);
            cars.remove(index);
        }
        return unloadedCar;
    }

    public double getX(){return x;}
    public double getY(){return y;}
}
