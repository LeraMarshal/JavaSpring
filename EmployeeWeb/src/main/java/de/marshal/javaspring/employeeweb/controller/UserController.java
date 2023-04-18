package de.marshal.javaspring.employeeweb.controller;

import de.marshal.javaspring.employeeweb.entity.User;
import de.marshal.javaspring.employeeweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @Value("${userNotPresentMessage}")
    private String userNotPresentMessage;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String getUsers(Model model){
        List<User> users = service.getUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/find")
    public String findUser(@RequestParam(required = false) String id,
                               Model model){
        Optional<User> userById = service.getUserById(id);
        if (userById.isPresent()) {
            model.addAttribute("userToFind", userById.get());
        } else {
            model.addAttribute("notPresentMessage", userNotPresentMessage);
        }
        return "findUserPage";
    }

    @PostMapping
    public String addUser(@ModelAttribute User userToAdd, RedirectAttributes attributes) {
        service.add(userToAdd);
        attributes.addFlashAttribute("added", userToAdd.getId());
        return "redirect:/users";
    }

    @PostMapping(value = "/delete")
    public String deleteUser(@RequestParam String userId, RedirectAttributes attributes){
        System.out.println("Delete " + userId);
        service.deleteUser(userId);
        attributes.addFlashAttribute("deleted", userId);
        return "redirect:/users";
    }

    @ModelAttribute("userToAdd")
    public User getUser(){
        return new User();
    }

}