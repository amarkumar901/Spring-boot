package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class PageController {

    @Autowired
    private UserService userService;

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
    public String register(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return "register";
    }
    
    //processing register
    @RequestMapping(value="/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session){
        System.out.println("Processing registration.");
        // fetch the form data
        System.out.println(userForm);
        // validate form data

        if(rBindingResult.hasErrors()){
            return "register";
        }


        // save to database

        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());

        User savedUser = userService.saveUser(user);
        System.out.println("User saved");
        //message = "Registration successful"
        //add message
        Message message = Message.builder().content("Registration successfull").type(MessageType.green).build();
        session.setAttribute("message", message);

        // redirect to login page
        return "redirect:/register";
    }
    
}
