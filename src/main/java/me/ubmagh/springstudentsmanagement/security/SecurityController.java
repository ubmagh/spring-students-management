package me.ubmagh.springstudentsmanagement.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/login")
    public String login(Model model, String error, String logout){

        if (error != null)
            model.addAttribute("errorMsg", "username ou mot de passe erroné .");
        else
            model.addAttribute("errorMsg", "");

        if (logout != null)
            model.addAttribute("msg", "Déconnecté avec succès.");
        else
            model.addAttribute("msg", "");


        return "pages/security/login";
    }

}
