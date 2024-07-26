package com.techelevator.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@CrossOrigin(origins = "https://cody-ko.github.io")
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleError() {
        // Return a custom 404 error page
        return "The page you are looking for does not exist.";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
