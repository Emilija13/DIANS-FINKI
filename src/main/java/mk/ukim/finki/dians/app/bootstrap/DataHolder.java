package mk.ukim.finki.dians.app.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.dians.app.model.Heritage;
import mk.ukim.finki.dians.app.model.Role;
import mk.ukim.finki.dians.app.model.User;
import mk.ukim.finki.dians.app.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

@Component
public class DataHolder {
    public static List<User> users = null;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public DataHolder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        users = new ArrayList<>();

        if (userRepository.count() == 0) {
            users.add(new User(
                            "admin",
                            "admin",
                            "admin",
                            passwordEncoder.encode("admin"),
                            Role.ROLE_ADMIN
                    )
            );
            users.add(new User(
                            "user",
                            "user",
                            "user",
                            passwordEncoder.encode("user"),
                            Role.ROLE_USER
                    )
            );
            userRepository.saveAll(users);
    }
}}
