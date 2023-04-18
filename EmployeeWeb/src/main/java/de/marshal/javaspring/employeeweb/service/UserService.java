package de.marshal.javaspring.employeeweb.service;

import de.marshal.javaspring.employeeweb.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(String id);

    List<User> getUsers();

    void add(User user);

    boolean updateUser(User user);

    void deleteUser(String id);
}
