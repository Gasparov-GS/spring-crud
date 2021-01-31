package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String userList(ModelMap modelMap) {
        List<User> userList = userService.allUser();
        modelMap.addAttribute("forms", userList);
        UserController.log.info("[GET] /");
        return "index";
    }


    @PostMapping("/delete")
    private String deleteUser(@RequestParam("id") int id) {
        userService.removeUser(id);
        UserController.log.info("[POST] /deleteUser " + id);
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
    public String updateForm(@PathVariable("id") int id, Model model) {
        User user = userService.findUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "updateUser";
    }

    @PostMapping("/update/{id}")
    public String updateUser(User user) {
        userService.addUser(user);
        return "redirect:/";
    }

}