package mk.ukim.finki.dians.app.service.impl;


import mk.ukim.finki.dians.app.model.User;
import mk.ukim.finki.dians.app.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.dians.app.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.dians.app.repository.UserRepository;
import mk.ukim.finki.dians.app.service.AuthService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
