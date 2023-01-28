package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    final private UserService userService;
    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/usersAll")
    public String showUsers (Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "usersAll";
    }

    @GetMapping ("/deleteUser/{id}")
    public String removeUser(@PathVariable("id") Long id){
        userService.removeUser(id);
        return "redirect:/admin/usersAll";
    }
    @GetMapping("/addUser")
    public String addUserForm(@ModelAttribute("user") User user){
        return "addUser";
    }
    @PostMapping("/add")
    public String addUserInDb(@ModelAttribute("user") @Valid User user){
        userService.addUser(user);
        return "redirect:/admin/usersAll";
    }
    @GetMapping("/edit/{id}")
    public String editUser(Model model, @PathVariable("id") Long id){
        model.addAttribute("user", userService.getUserId(id));
        return "edit";
    }
    @PostMapping("/updateUser")
    public String update (@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/admin/usersAll";
    }
}
