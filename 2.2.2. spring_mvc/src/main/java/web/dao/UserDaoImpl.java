package web.dao;

import web.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDaoImpl implements UserDao {
    private final List<Car> cars = new ArrayList<>();

    public UserDaoImpl() {
        init();
    }


    private void init() {

        addCar(new Car("Lada", "White", 1.6));
        addCar(new Car("BMW", "BLACK", 3.5));
        addCar(new Car("Porshe", "Red", 4.0));
        addCar(new Car("Opel", "Orange", 2.0));
        addCar(new Car("Kia", "Black", 3.8));
    }

    @Override
    public List<Car> findCars(int countCar) {
        return cars.stream().limit(countCar).collect(Collectors.toList());
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }
}
