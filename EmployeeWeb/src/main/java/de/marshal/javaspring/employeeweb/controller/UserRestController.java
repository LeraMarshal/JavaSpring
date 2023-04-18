package de.marshal.javaspring.employeeweb.controller;

import de.marshal.javaspring.employeeweb.entity.Employee;
import de.marshal.javaspring.employeeweb.entity.User;
import de.marshal.javaspring.employeeweb.service.EmployeeService;
import de.marshal.javaspring.employeeweb.service.UserService;
import de.marshal.javaspring.employeeweb.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usersRest")
public class UserRestController {

    private final UserService service;

    @Autowired
    public UserRestController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getUsers() {
        return service.getUsers();
    }

    @GetMapping(value = "/find")
    public Optional<User> findUser(@RequestParam(required = false) String id) {
        return service.getUserById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User employee) {
        service.add(employee);
        return employee;
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User employee) {
        boolean isUpdated = service.updateUser(employee);
        if (isUpdated) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(employee, HttpStatus.CREATED);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable String id) {
        System.out.println("Deleting:" + id);
        service.deleteUser(id);
    }
}