package de.marshal.javaspring.employeeweb.repository;

import de.marshal.javaspring.employeeweb.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>(List.of(
            new User(UUID.randomUUID().toString(), "admin", "123", "ROLE_ADMIN", "111@gmail.com"),
            new User(UUID.randomUUID().toString(), "editor1", "123", "ROLE_USER", "222@gmail.com"),
            new User(UUID.randomUUID().toString(), "editor2", "123", "ROLE_USER", "333@gmail.com")
    ));

    public List<User> getAll() {
        return new ArrayList<>(users);
    }

    public User getById(String id) {
        return users.stream()
                .filter(e -> Objects.equals(id, e.getId()))
                .findFirst()
                .orElse(null);
    }

    public void add(User user) {
        users.add(user);
    }

    public void deleteUser(String id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    public void updateById(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                users.set(i, user);
            }
        }
    }
}
