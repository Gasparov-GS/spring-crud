package web.controller;

import org.springframework.web.bind.annotation.*;
import web.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import web.service.CarService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {


    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping(value = "/cars")
    public String printWelcome(ModelMap model, HttpServletRequest request) {
        int count = Integer.parseInt(request.getParameter("count"));
        List<Car> cars = carService.getCars(count);
        System.out.println(count);
        model.addAttribute("forms", cars);
        return "car";
    }

}
