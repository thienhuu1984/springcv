package funix.huutt.springcv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company")
public class CompanyController extends EntityController {

    @GetMapping("/detail")
    public String companyDetail(Model model) {

        return "public/detail-company";
    }
}
