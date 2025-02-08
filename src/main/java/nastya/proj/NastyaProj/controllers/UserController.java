package nastya.proj.NastyaProj.controllers;

import lombok.RequiredArgsConstructor;
import nastya.proj.NastyaProj.models.User;
import nastya.proj.NastyaProj.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Класс для обработки http запросов связанных с авторизацией пользователя.
 */
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * Метод, который отправляет клиенту страницу для авторизации.
     * @return страницу авторизации.
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Метод, который отправляет клиенту страницу для регистрации.
     * @return страницу регистрации {@link String}.
     */
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    /**
     * Метод, который обрабатывает post запрос со страницы регистрации.
     * Если пользователь с таким email уже существует,
     * иначе перенаправляет клиента на страницу авторизации
     * @param user {@link User}
     * @param model {@link Model} для передачи сообщения об ошибке на страницу
     * @return страницу регистрации {@link String}, если пользователь с таким email уже существует.
     *  Страницу авторизации {@link String}, если пользователя с таким email ещё не существовало.
     */
    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if(!userService.createUser(user)) {
            model.addAttribute("errorMessage", "Пользователь с таким email уже существует!");

            return "registration";
        }

        return "redirect:/login";
    }
}
