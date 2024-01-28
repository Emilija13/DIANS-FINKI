package mk.ukim.finki.dians.app.service;


import mk.ukim.finki.dians.app.model.Role;
import mk.ukim.finki.dians.app.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDate;


public interface UserService extends UserDetailsService {

    User register(String username, String name, String surname, String password, String repeatPassword, Role role);
}
