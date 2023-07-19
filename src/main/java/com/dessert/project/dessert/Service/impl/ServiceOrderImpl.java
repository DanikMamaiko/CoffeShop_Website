package com.dessert.project.dessert.Service.impl;

import com.dessert.project.dessert.DAO.OrderRepository;
import com.dessert.project.dessert.Entities.Consumers;
import com.dessert.project.dessert.Entities.Orders;
import com.dessert.project.dessert.Service.interf.ServiceOrderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceOrderImpl implements ServiceOrderInterface {

    @Autowired
    OrderRepository orderRepository;


    @Override
    @Transactional
    public List<Orders> getAllOrders() {
        List <Orders> ordersList = orderRepository.findAll();
        return ordersList;
    }

    @Override
    @Transactional
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Orders getOrder(int id) {
        Orders order = null;
        Optional <Orders> optional = orderRepository.findById(id);
        if(optional.isPresent()){
            order = optional.get();
        }
        return order;
    }

    @Override
    @Transactional
    public void saveOrder(Orders order) {
        orderRepository.save(order);
    }

    @Override
    @Transactional
    public void updateOrder(Orders order) {
        Orders oldOrder = orderRepository.getById(order.getId());

        oldOrder.setWeight(order.getWeight());
        oldOrder.setFilling(order.getFilling());
        oldOrder.setDesign(order.getDesign());
    }
}
