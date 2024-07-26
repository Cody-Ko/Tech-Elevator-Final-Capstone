package com.techelevator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@CrossOrigin(origins = "https://cody-ko.github.io")
public class HomeController {

//    @GetMapping("/")
//    public RedirectView redirectToLogin() {
//        return new RedirectView("/login");
//    }
}
