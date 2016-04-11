package jmp.dao;

import jmp.domain.User;

public interface UserDao extends DomainOjectDao<User> {

    User getUserById(Integer id);
}
