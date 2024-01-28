package mk.ukim.finki.dians.app.service.impl;

import mk.ukim.finki.dians.app.model.Role;
import mk.ukim.finki.dians.app.model.User;
import mk.ukim.finki.dians.app.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.dians.app.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.dians.app.model.exceptions.UsernameAlreadyExistsException;
import mk.ukim.finki.dians.app.repository.UserRepository;
import mk.ukim.finki.dians.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s).orElseThrow(()->new UsernameNotFoundException(s));
    }

    @Override
    public User register(String username, String name, String surname, String password, String repeatPassword, Role role) {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }

        if (!password.equals(repeatPassword)) {
            throw new PasswordsDoNotMatchException();
        }

        if(this.userRepository.findByUsername(username).isPresent()) {
            throw new UsernameAlreadyExistsException(username);
        }

        User user = new User(
                username,
                name,
                surname,
                passwordEncoder.encode(password),
                role
        );

        return userRepository.save(user);
    }
}