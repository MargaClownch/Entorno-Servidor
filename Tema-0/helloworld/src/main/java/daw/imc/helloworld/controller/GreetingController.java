package daw.imc.helloworld.controller;

import daw.imc.helloworld.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class GreetingController {
// Cuando accedamos a esta URL, accederemos a este controlador. http://127.0.0.1:8080/info

    @GetMapping("/greeting")
    public String userGreeting(Model model) {
        model.addAttribute("message", "¡Bienvenidos!"); // Cambiado a plural
        User user1 = new User("David", "david@example.com");
        User user2 = new User("Laura", "laura@example.com");
        List<User> userList = Arrays.asList(user1, user2);
        model.addAttribute("users", userList);
        return "user-greeting";
    }
    @GetMapping("/helloworld")
    public String greeting(@RequestParam(required = false) String username, Model
            model) {
        model.addAttribute("message", "Hola " + username);
        return "helloworld";
    }
}