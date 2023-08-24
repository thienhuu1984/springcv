package funix.huutt.springcv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Temp {

    @GetMapping("/html/html")
    public String test() {

        return "html";
    }
}
