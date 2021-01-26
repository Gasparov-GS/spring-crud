package web.dao;

import web.model.Car;

import java.util.List;

public interface UserDao {

    List<Car> findCars(int countCar);
    void addCar(Car car);

}
