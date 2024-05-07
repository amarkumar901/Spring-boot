package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("Home page handler");

        //Sending data to view
        model.addAttribute("name", "Substring technologies.");
        model.addAttribute("youtubeChannel", "Amar kumar");
        model.addAttribute("github", "technologies.");
        return "home";
    }

    //About route
    @RequestMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("isLogin", false);
        System.out.println("About page loading");
        return "about";
    }

    //Services
    @RequestMapping("/services")
    public String servicesPage(){
        System.out.println("Services page loading");
        return "services";
    }
}
