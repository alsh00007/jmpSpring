package jmp.dao.impl;

import jmp.dao.UserDao;
import jmp.domain.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserDaoImpl extends DomainObjectDaoImpl<User> implements UserDao {

    private static final Set<User> STORAGE = new HashSet<>();

    static {
        STORAGE.add(new User (1, "Eric", "Cartman"));
        STORAGE.add(new User (2, "Butters", "Stotch"));
        STORAGE.add(new User (3, "Kenny", "McKornick"));

    }

    public UserDaoImpl() {
        super(STORAGE);
    }

    @Override
    public User getUserById(Integer id) {
        for (User user : STORAGE) {
            if (user.getUserId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}
