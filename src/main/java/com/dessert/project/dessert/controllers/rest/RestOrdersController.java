package com.dessert.project.dessert.controllers.rest;

import com.dessert.project.dessert.entities.Orders;
import com.dessert.project.dessert.service.impl.ServiceOrderImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api")
public class RestOrdersController {

    private ServiceOrderImpl serviceOrderImpl;

    public RestOrdersController(ServiceOrderImpl serviceOrderImpl) {
        this.serviceOrderImpl = serviceOrderImpl;
    }

    @GetMapping("/orders")
    public List<Orders> allOrders(){
        List <Orders> allOrders = serviceOrderImpl.getAllOrders();
        return allOrders;
    }

    @GetMapping("/orders/{id}")
    public Orders getOrder(@PathVariable("id") int id){
        Orders order = serviceOrderImpl.getOrder(id);
        return order;
    }

    @PostMapping("/orders")
    public Orders createOrder(@RequestBody Orders order){
        serviceOrderImpl.saveOrder(order);
        return order;
    }

    @PutMapping("/orders")
    public Orders updateOrder(@RequestBody Orders order){
        serviceOrderImpl.saveOrder(order);
        return order;
    }

    @DeleteMapping("/orders/{id}")
    public String deleteOrder(@PathVariable("id") int id){
        serviceOrderImpl.deleteOrder(id);
        return "Order with ID = " + id + "was deleted";
    }


}
