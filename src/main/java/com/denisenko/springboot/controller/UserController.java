package com.denisenko.springboot.controller;

import com.denisenko.springboot.model.User;
import com.denisenko.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String userList(ModelMap modelMap) {
        List<User> users = userService.findAll();
        modelMap.addAttribute("users", users);
        return "index";
    }

    @GetMapping(value = "/user-create")
    public String createUserForm(User user, ModelMap modelMap) {
        modelMap.addAttribute("users", user);
        return "user-create";
    }

    @PostMapping(value = "/user-create")
    public String createUser(User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, ModelMap modelMap) {
        User user = userService.findById(id);
        modelMap.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping(value = "/user-update")
    public String updateUser(User user) {
        userService.save(user);
        return "redirect:/users";
    }
}
