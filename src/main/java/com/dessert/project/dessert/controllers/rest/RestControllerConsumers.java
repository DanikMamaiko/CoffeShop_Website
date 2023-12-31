package com.dessert.project.dessert.controllers.rest;

import com.dessert.project.dessert.entities.Consumers;
import com.dessert.project.dessert.service.impl.ServiceConsumerImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest/api")
public class RestControllerConsumers {

    private ServiceConsumerImpl serviceRepository;
    public RestControllerConsumers(ServiceConsumerImpl serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @GetMapping("/consumers")
    public List<Consumers> showAll(){
        List <Consumers> list = serviceRepository.getAllConsumers();
        return list;
    }

    @GetMapping("/consumers/{id}")
    public Consumers showOne(@PathVariable("id") int id){
        Consumers consumer = serviceRepository.getConsumer(id);
        return consumer;
    }

    @PostMapping("/consumers")
    public Consumers createConsumer(@RequestBody Consumers consumer){
        serviceRepository.saveConsumer(consumer);
        return consumer;
    }

    @PutMapping("/consumers")
    public Consumers updateConsumer(@RequestBody Consumers consumers){
        serviceRepository.saveConsumer(consumers);
        return consumers;
    }

    @DeleteMapping("/consumers/{id}")
    public String deleteConsumer(@PathVariable("id") int id){
        serviceRepository.deleteConsumer(id);
        return "Consumer with ID = " + id + " was deleted";
    }

}
