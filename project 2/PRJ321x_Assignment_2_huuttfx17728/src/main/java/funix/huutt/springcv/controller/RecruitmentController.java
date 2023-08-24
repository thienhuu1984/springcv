package funix.huutt.springcv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecruitmentController extends EntityController {

    @GetMapping("/recruitment")
    public String recruitmentDetail(Model model){

        return "public/detail-post";
    }

}
