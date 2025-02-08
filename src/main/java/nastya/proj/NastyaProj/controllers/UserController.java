package nastya.proj.NastyaProj.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nastya.proj.NastyaProj.models.User;
import nastya.proj.NastyaProj.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) {

        if(!userService.createUser(user)) {
            model.addAttribute("errorMessage", "Пользователь с таким email уже существует!");
            return "registration";
        }

        return "redirect:/login";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
