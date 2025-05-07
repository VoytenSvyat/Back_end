package de.ait.userapi.repository;

import de.ait.userapi.model.User;

import java.util.List;

public interface UserRepository {

    public List<User> findAll();
    public User findById(Long id);
    public User save(User user);
}
