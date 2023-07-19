package com.dessert.project.dessert.Controllers.security;


import com.dessert.project.dessert.Entities.Consumers;
import com.dessert.project.dessert.Service.impl.ServiceConsumerImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {

    @Autowired
    ServiceConsumerImpl consumerService;

    @GetMapping("/login")
    public String loginPage(){
        return "backend/security/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("consumer") Consumers consumer){
        return "backend/security/registration";
    }

    @PostMapping("/process-registration")
    public String processRegistrationPage(@Valid @ModelAttribute("consumer") Consumers consumer, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "backend/security/registration";
        }

        consumerService.saveConsumer(consumer);

        return "redirect:/login";
    }

}
