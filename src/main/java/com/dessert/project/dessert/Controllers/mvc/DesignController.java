package com.dessert.project.dessert.Controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
