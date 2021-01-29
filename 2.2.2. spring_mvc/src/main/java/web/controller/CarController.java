package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
        List<Car> cars = request.getParameter("count") == null
                        ? carService.getCars(5)
                        :carService.getCars(Integer.parseInt(request.getParameter("count")));

        model.addAttribute("forms", cars);
        return "car";
    }


    @GetMapping("/user")
    @ResponseBody
    public String welcome() {
        return new Car("d","d",3).toString();
    }


}
