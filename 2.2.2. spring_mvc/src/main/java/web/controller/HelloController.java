package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static java.rmi.server.LogStream.log;

@Controller
@Slf4j
public class HelloController {

    private final UserService userService;

    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String showFilms(ModelMap modelMap) {
        List<User> userList = userService.allUser();
        modelMap.addAttribute("forms", userList);
        HelloController.log.info("[GET] /");
        return "index";
    }


    @PostMapping("/delete")
    private String deleteUser(@RequestParam("id") int id) {
        userService.removeUser(id);
        HelloController.log.info("[POST] /deleteUser " + id);
        return "redirect:/";
    }


    @GetMapping("/addUser")
    private String userForm(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }


    @PostMapping("/addUser")
    private String addUser(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model, HttpServletRequest request) {
        User user = userService.findUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "updateUser";
    }

}