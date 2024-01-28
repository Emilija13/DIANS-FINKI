package mk.ukim.finki.dians.app.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.dians.app.model.User;
import mk.ukim.finki.dians.app.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.dians.app.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.dians.app.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String getLoginPage(Model model) {
        model.addAttribute("bodyContent","login");
        return "login";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model) {
        User user = null;

        try {
            user = authService.login(request.getParameter("username"), request.getParameter("password"));
        } catch (InvalidUserCredentialsException | InvalidArgumentsException exception) {
            model.addAttribute("bodyContent", "login");
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login";
        }

        request.getSession().setAttribute("user", user);
        return "redirect:/movies";
    }
}