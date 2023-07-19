package com.dessert.project.dessert.Controllers.mvc;

import com.dessert.project.dessert.Entities.Consumers;
import com.dessert.project.dessert.Service.impl.ServiceConsumerImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ConsumersController {

    @Autowired
    private ServiceConsumerImpl serviceRepository;

    @GetMapping("/allConsumers")
    public String consumersPage(Model model){
        List<Consumers> allConsumers = serviceRepository.getAllConsumers();
        model.addAttribute("allConsumers", allConsumers);

        double avgAge = serviceRepository.getAvgAge();
        model.addAttribute("avgAge", avgAge);

        int maleCount = serviceRepository.getMaleCount();
        int femaleCount = serviceRepository.getFemaleCount();
        model.addAttribute("maleCount", maleCount);
        model.addAttribute("femaleCount", femaleCount);

        return "backend/consumer/consumersPage";
    }

    @GetMapping("/addNewConsumer")
    public String addNewConsumer(Model model){
        model.addAttribute("consumer", new Consumers());
        return "backend/consumer/consumerFormPage";
    }

    @PostMapping("/saveConsumer")
    public String saveConsumer(@Valid @ModelAttribute("consumer") Consumers consumer, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "backend/order/consumerFormPage";
        } else {
            serviceRepository.saveConsumer(consumer);
            return "redirect:/allConsumers";
        }

    }

    @GetMapping("/delete/{id}")
    public String deleteConsumer(@PathVariable("id") int id, Model model){
        serviceRepository.deleteConsumer(id);
        return "redirect:/allConsumers";
    }

    @GetMapping("/update/{id}")
    public String updateConsumer(@PathVariable("id") int id, Model model){
        model.addAttribute("consumer", serviceRepository.getConsumer(id));
        return "backend/consumer/updateConsumerPage";
    }

    @PostMapping("/update/updateConsumer")
    public String updateConsumer(@Valid @ModelAttribute("consumer") Consumers consumer, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "backend/consumer/updateConsumerPage";
        } else {
            serviceRepository.updateConsumer(consumer);
            return "redirect:/allConsumers";
        }
    }

    @GetMapping("/getConsumer/{id}")
    public String getConsumerById(@PathVariable("id") int id, Model model){
        Consumers consumer = serviceRepository.getConsumer(id);
        model.addAttribute("consumer", consumer);

        return "backend/consumer/oneConsumerInfo";
    }


}
