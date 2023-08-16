package com.dessert.project.dessert.service.impl;

import com.dessert.project.dessert.DAO.ConsumerRepository;
import com.dessert.project.dessert.entities.Consumers;
import com.dessert.project.dessert.entities.Orders;
import com.dessert.project.dessert.service.interf.ServiceConsumerInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceConsumerImpl implements ServiceConsumerInterface {

    private ConsumerRepository consumerRepository;
    public ServiceConsumerImpl(ConsumerRepository consumerRepository)
    {
        this.consumerRepository = consumerRepository;
    }

    @Override
    @Transactional
    public List<Consumers> getAllConsumers() {
        return consumerRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteConsumer(int id) {
        Consumers consumer = consumerRepository.getById(id);
        List <Orders> ordersList = consumer.getOrdersList();
        for(Orders order: ordersList){
            order.setConsumer(null);
        }
        consumerRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Consumers getConsumer(int id) {
        Consumers consumer = null;
        Optional<Consumers> optional = consumerRepository.findById(id);
        if(optional.isPresent()){
            consumer = optional.get();
        }
        return consumer;
    }


    @Override
    @Transactional
    public void saveConsumer(Consumers consumer) {
        consumerRepository.save(consumer);
    }

    @Override
    @Transactional
    public void updateConsumer(Consumers consumer) {
        Consumers oldConsumer = consumerRepository.getById(consumer.getId());

        oldConsumer.setName(consumer.getName());
        oldConsumer.setSurname(consumer.getSurname());
        oldConsumer.setAge(consumer.getAge());
        oldConsumer.setSex(consumer.getSex());
        oldConsumer.setPhoneNumber(consumer.getPhoneNumber());
    }

    @Override
    public double getAvgAge() {
        return consumerRepository.avgAge();
    }

    @Override
    public int getMaleCount() {
        return consumerRepository.getAllMale();
    }

    @Override
    public int getFemaleCount() {
        return consumerRepository.getAllFemale();
    }


}
