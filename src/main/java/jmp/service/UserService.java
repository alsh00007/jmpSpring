package jmp.service;

import jmp.domain.User;

import java.util.Collection;

public interface UserService {
    Collection<User> getAllUsers();

    User getUserById(Integer userId);
}
