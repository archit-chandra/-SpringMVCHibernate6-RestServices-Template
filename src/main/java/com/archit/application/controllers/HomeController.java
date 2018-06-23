package com.archit.application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    /**
     * To handle default page if there is no webapp/index.jsp
     * Here, home_page.jsp will become the default page at the start of application
     * If both pages exist, index.jsp will be considered.
     */
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Archit");
        return "home_page";
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name, Model model) {
        String greet = " Hello !!!" + name + " How are You?";
        model.addAttribute("greet", greet);
        System.out.println(greet);
        return "greet_page";
    }
}
