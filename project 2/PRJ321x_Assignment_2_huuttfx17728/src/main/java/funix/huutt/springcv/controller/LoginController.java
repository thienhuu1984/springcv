package funix.huutt.springcv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("login", " ");

        return "public/login";
    }

    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("register", " ");

        return "public/login";
    }


}
