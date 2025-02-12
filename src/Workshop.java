import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends Car> {
    private int maxCarCapacity;
    private List<T> cars;
    private Class<?>[] acceptableCarTypes;

    public Workshop(int maxCarCapacity,Class<? extends Car>... brands){
        this.maxCarCapacity = maxCarCapacity;
        this.acceptableCarTypes = brands;
    }

    public void loadCar(T car){
        for(Class<?> brand : acceptableCarTypes){
            if(brand.isInstance(car)){
                if(cars.size() < maxCarCapacity){
                    cars.add(car);
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
}
