package funix.huutt.springcv.controller;

import funix.huutt.springcv.entity.Role;
import funix.huutt.springcv.entity.User;
import funix.huutt.springcv.service.EntityService;
import funix.huutt.springcv.view.Registering;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private EntityService entityService;

    @InitBinder
    private void initBinder (WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

    }

    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("login", " ");

        return "public/login";
    }



    @GetMapping("/register")
    public String register(Model model) {

        List<Role> roles = entityService.findAllRoles();

        if(roles == null){
            System.out.println("\n\n\nEmpty Roles\n\n\n");
            roles = new ArrayList<>();
        }

        model.addAttribute("register", new Registering());

        model.addAttribute("roles", roles);

        return "public/login";
    }

    @PostMapping("/register")
    public String authRegister(
            @Valid @ModelAttribute("register") Registering register,
            BindingResult bindingResult,
            Model model
    ) {

        if(bindingResult.hasErrors()) {
            System.out.println(register);
            System.out.println("\n\n\nFailed\n\n\n");

            List<Role> roles = entityService.findAllRoles();

            if(roles == null){
                System.out.println("\n\n\nEmpty Roles\n\n\n");
                roles = new ArrayList<>();
            }

            model.addAttribute("roles", roles);

            return "public/login";
        }
        else {

            User user = parseToUser(register);

            User dbUser = entityService.saveUser(user);

            System.out.println(dbUser);
            if(dbUser != null )
                model.addAttribute("msg_register_success", " ");
            else
                model.addAttribute("msg_register_error" , " ");


            return "public/login";
//            return "redirect:/login";
        }
    }


    private User parseToUser(Registering r) {
        User u = new User(
                r.getEmail(),
                r.getPassword(),
                r.getFullName(),
                "",
                "000000",
                "",
                ""
        );

        //(String email, String password, String fullName, String address, String phoneNumber,  String image, String about)

        Role role = entityService.findRole(r.getRoleId());

        u.setRole(role);

        return u;
    }


}
