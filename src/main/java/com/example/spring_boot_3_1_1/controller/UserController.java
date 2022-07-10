package com.example.spring_boot_3_1_1.controller;

import com.example.spring_boot_3_1_1.model.User;
import com.example.spring_boot_3_1_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/show")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping("/show")
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/show";
    }

    @GetMapping("{id}/updateUser")
    public String updateUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/updateUser";
    }

    @PatchMapping("{id}/updateUser")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/show";
    }

    @DeleteMapping("{id}/deleteUser")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/show";
    }
}
