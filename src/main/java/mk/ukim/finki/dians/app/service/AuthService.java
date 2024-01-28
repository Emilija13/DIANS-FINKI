package mk.ukim.finki.dians.app.service;



import mk.ukim.finki.dians.app.model.User;

import java.util.List;

public interface AuthService {
    User login(String username, String password);

    List<User> findAll();
}
