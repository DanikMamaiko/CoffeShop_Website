package com.dessert.project.dessert.service.interf;

import com.dessert.project.dessert.entities.Orders;

import java.util.List;

public interface ServiceOrderInterface {

    public List<Orders> getAllOrders();

    public void deleteOrder(int id);

    public Orders getOrder(int id);

    public void saveOrder(Orders order);

    public void updateOrder(Orders order);

}
