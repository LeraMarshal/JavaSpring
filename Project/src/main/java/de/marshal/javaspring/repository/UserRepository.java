package de.marshal.javaspring.repository;

import de.marshal.javaspring.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
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
}
