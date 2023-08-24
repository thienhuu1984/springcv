package funix.huutt.springcv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fragment")
public class FragmentController {

    @GetMapping("/head")
    public String viewHead() {
        return "fragment/head";
    }
}
