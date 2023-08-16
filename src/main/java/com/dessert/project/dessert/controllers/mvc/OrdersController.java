package com.dessert.project.dessert.controllers.mvc;

import com.dessert.project.dessert.entities.Consumers;
import com.dessert.project.dessert.entities.Orders;
import com.dessert.project.dessert.service.impl.ServiceOrderImpl;
import com.dessert.project.dessert.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrdersController {

    private ServiceOrderImpl serviceOrderImpl;
    public OrdersController(ServiceOrderImpl serviceOrderImpl) {
        this.serviceOrderImpl = serviceOrderImpl;
    }

    @GetMapping("/allOrders")
    public String ordersPage(Model model){
        List<Orders> ordersList = serviceOrderImpl.getAllOrders();
        model.addAttribute("allOrders", ordersList);

        return "backend/order/ordersPage";
    }

    @GetMapping("/addNewOrder")
    public String addNewOrder(Model model) throws AccountNotFoundException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        if (userDetails == null) {
            throw new AccountNotFoundException("Account Error");
        }

        Consumers consumer = userDetails.getConsumer();

        Orders order = new Orders();

        order.setConsumer(consumer);

        model.addAttribute("order", order);

        List <String> fillingList = new ArrayList<>();
        fillingList.add("Красный бархат");
        fillingList.add("Медовик");
        fillingList.add("Сникерс");

        model.addAttribute("fillingList", fillingList);

        return "backend/order/orderFormPage";
    }

    @PostMapping("/saveOrder")
    public String saveOrder(@ModelAttribute("order") Orders order){
        serviceOrderImpl.saveOrder(order);
        return "redirect:/allOrders";
    }


    @GetMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable("id") int id){
        serviceOrderImpl.deleteOrder(id);
        return "redirect:/allOrders";
    }

    @GetMapping("/updateOrder/{id}")
    public String updateOrder(@PathVariable("id") int id, Model model){
        Orders order = serviceOrderImpl.getOrder(id);
        model.addAttribute("order", order);

        List <String> fillingList = new ArrayList<>();
        fillingList.add("Красный бархат");
        fillingList.add("Медовик");
        fillingList.add("Сникерс");

        model.addAttribute("fillingList", fillingList);

        return "backend/order/updateOrderPage";
    }

    @PostMapping("/updateOrder/updateOrder")
    public String updateOrder(@ModelAttribute("order") Orders order){
        serviceOrderImpl.updateOrder(order);
        return "redirect:/allOrders";
    }

}
