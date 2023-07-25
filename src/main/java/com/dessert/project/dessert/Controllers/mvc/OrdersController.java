package com.dessert.project.dessert.Controllers.mvc;

import com.dessert.project.dessert.Entities.Consumers;
import com.dessert.project.dessert.Entities.Orders;
import com.dessert.project.dessert.Service.impl.ServiceConsumerImpl;
import com.dessert.project.dessert.Service.impl.ServiceOrderImpl;
import com.dessert.project.dessert.Service.impl.UserDetailsServiceImpl;
import com.dessert.project.dessert.security.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrdersController {

    @Autowired
    private ServiceOrderImpl serviceOrderImpl;

    @Autowired
    private ServiceConsumerImpl serviceConsumer;

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
