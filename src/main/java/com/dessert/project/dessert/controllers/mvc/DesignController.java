package com.dessert.project.dessert.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DesignController {

    @GetMapping("/")
    public String mainPage(){
        return "design/mainPage";
    }

    @GetMapping("/about")
    public String aboutPage(){
        return "design/aboutPage";
    }

    @GetMapping("/menu")
    public String menuPage(){
        return "design/menuPage";
    }

    @GetMapping("/reviews")
    public String reviewsPage(){
        return "design/reviewsPage";
    }

}
