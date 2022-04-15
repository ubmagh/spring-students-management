package me.ubmagh.springstudentsmanagement.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("tab", "home");
        return "pages/home";
    }

}
