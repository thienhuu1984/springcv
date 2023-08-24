package funix.huutt.springcv.controller;

import funix.huutt.springcv.entity.Recruitment;
import funix.huutt.springcv.entity.User;
import funix.huutt.springcv.service.EntityService;
import funix.huutt.springcv.view.CategoryAnalysis;
import funix.huutt.springcv.view.Statistics;
import funix.huutt.springcv.view.TopCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SpringcvController extends EntityController {

    @Autowired
    private EntityService entityService;


    public SpringcvController() {
        statistics = new Statistics();
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

    }

    @GetMapping("/")
    public String showHome(Model model) {

        totalStatistic ();



        model.addAttribute("statistics", statistics);

        model.addAttribute("topCategories", entityService.categoriesAnalysis());

        model.addAttribute("topRecruitments", entityService.getTopRecuitments());

        model.addAttribute("topCompanies", entityService.findTopCompanies());



        return "public/home";
    }

    private void totalStatistic () {

        if(statistics == null) statistics = new Statistics();

        List<User> candidates = entityService.findAllCandidate();
        List<User> companies = entityService.findAllCompany();
        List<Recruitment> recruitments = entityService.findAllRecruitment();

        statistics.setTotalCandidate ((candidates == null)?0:users.size());
        statistics.setTotalCompanies((companies==null)?0:companies.size());
        statistics.setTotalRecruitments((recruitments==null)?0:recruitments.size());

    }

}
