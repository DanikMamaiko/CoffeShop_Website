package com.dessert.project.dessert.Controllers.mvc;

import com.dessert.project.dessert.Entities.Consumers;
import com.dessert.project.dessert.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.security.auth.login.AccountNotFoundException;

@Controller
public class CurrentConsumerController {

    @GetMapping("/currentConsumer")
    public String showRead(Model model) throws AccountNotFoundException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        if (userDetails == null) {
            throw new AccountNotFoundException("Account Error");
        }

        Consumers consumer = userDetails.getConsumer();

        model.addAttribute("consumer", consumer);
        return "backend/consumer/oneConsumerInfo";
    }

}
