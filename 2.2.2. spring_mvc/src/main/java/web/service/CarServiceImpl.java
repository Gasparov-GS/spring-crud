package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final UserDao userDao;

    public CarServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<Car> getCars(int countCar) {
        return userDao.findCars(countCar);
    }
}
