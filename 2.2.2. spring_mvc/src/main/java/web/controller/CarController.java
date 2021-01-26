package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.Car;
import web.service.CarService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CarController {


    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping(value = "/cars")
    public String printWelcome(ModelMap model, HttpServletRequest request) {
        List<Car> cars = null;

        if (request.getQueryString() == null) {
            cars = carService.getCars(5);
        } else {
            int count = Integer.parseInt(request.getParameter("count"));
            cars = carService.getCars(count);
        }

        model.addAttribute("forms", cars);
        return "car";
    }
}
