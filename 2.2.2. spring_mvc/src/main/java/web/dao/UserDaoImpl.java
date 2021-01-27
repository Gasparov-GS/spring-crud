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

        addCar(new Car("Lada", "White", 98));
        addCar(new Car("BMW", "BLACK", 350));
        addCar(new Car("Porshe", "Red", 300));
        addCar(new Car("Opel", "Orange", 120));
        addCar(new Car("Kia", "Black", 150));
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
