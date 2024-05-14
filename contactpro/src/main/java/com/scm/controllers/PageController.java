package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


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

    //contact page
    @GetMapping("/contact")
    public String contactpage(){
        return new String("contact");
    }

    //login page
    @GetMapping("login")
    public String login() {
        return new String("login");
    }

    @GetMapping("register")
    public String register() {
        return "register";
    }
    
    
}
