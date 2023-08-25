package com.dessert.project.dessert.service.impl;

import com.dessert.project.dessert.DAO.OrderRepository;
import com.dessert.project.dessert.entities.Consumers;
import com.dessert.project.dessert.entities.Orders;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServiceOrderImplTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private ServiceOrderImpl orderService;

    @Test
    void getAllOrders() {
        List<Orders> expectedOrders = new ArrayList<>();
        expectedOrders.add(new Orders());
        expectedOrders.add(new Orders());

        when(orderRepository.findAll()).thenReturn(expectedOrders);

        List <Orders> actualOrders = orderService.getAllOrders();

        assertEquals(expectedOrders, actualOrders);

        verify(orderRepository, times(1)).findAll();

    }

    @Test
    void deleteOrder() {

        Orders order = new Orders();
        Consumers consumer = new Consumers();

        order.setId(1);
        order.setConsumer(consumer);

        orderRepository.save(order);

        orderService.deleteOrder(1);

        Optional<Orders> deletedOrder = orderRepository.findById(1);
        assertFalse(deletedOrder.isPresent());
    }

    @Test
    void getOrder() {

        Orders order = new Orders();
        order.setId(1);

        when(orderRepository.findById(1)).thenReturn(Optional.of(order));

        Orders actualOrder = orderService.getOrder(1);

        assertEquals(actualOrder, order);
        assertNotNull(actualOrder);

        verify(orderRepository).findById(1);

    }

    @Test
    void saveOrder() {
        Orders order = new Orders();

        orderService.saveOrder(order);

        verify(orderRepository, times(1)).save(order);
    }

    @Test
    void updateOrder() {
        Orders order = new Orders();
        order.setId(1);
        order.setWeight(2.7);
        order.setFilling("Медовик");
        order.setDesign("Пираты");

        orderRepository.save(order);

        Orders updatedOrder = new Orders();
        updatedOrder.setId(1);
        updatedOrder.setWeight(2.7);
        updatedOrder.setFilling("Красный бархат");
        updatedOrder.setDesign("Пираты");

        when(orderRepository.getById(1)).thenReturn(order);

        orderService.updateOrder(updatedOrder);

        when(orderRepository.findById(1)).thenReturn(Optional.of(order));

        Orders retrievedOrder = orderService.getOrder(1);

        assertNotNull(retrievedOrder);
        assertEquals(updatedOrder.getId(), retrievedOrder.getId());
        assertEquals(updatedOrder.getDesign(), retrievedOrder.getDesign());
        assertEquals(updatedOrder.getWeight(), retrievedOrder.getWeight());
        assertEquals(updatedOrder.getFilling(), retrievedOrder.getFilling());

    }
}