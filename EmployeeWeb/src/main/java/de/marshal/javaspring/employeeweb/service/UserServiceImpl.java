package de.marshal.javaspring.employeeweb.service;

import de.marshal.javaspring.employeeweb.entity.Employee;
import de.marshal.javaspring.employeeweb.entity.User;
import de.marshal.javaspring.employeeweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> getUserById(String id) {
        User user = repository.getById(id);
        if (user == null){
            return Optional.empty();
        }
        return Optional.of(user);
    }

    @Override
    public List<User> getUsers() {
        return repository.getAll();
    }

    @Override
    public void add(User user) {
        repository.add(user);
    }

    @Override
    public boolean updateUser(User user) {
        List<User> users = repository.getAll();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                repository.updateById(user);
                return true;
            }
        }
        repository.add(user);
        return false;
    }

    @Override
    public void deleteUser(String id) {
        repository.deleteUser(id);
    }
}
