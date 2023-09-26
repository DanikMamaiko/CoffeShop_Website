package com.dessert.project.dessert.service.impl;

import com.dessert.project.dessert.DAO.ConsumerRepository;
<<<<<<< HEAD:src/main/java/com/dessert/project/dessert/service/impl/ServiceConsumerImpl.java
import com.dessert.project.dessert.entities.Consumers;
import com.dessert.project.dessert.entities.Orders;
import com.dessert.project.dessert.service.interf.ServiceConsumerInterface;
=======
import com.dessert.project.dessert.DAO.RoleRepository;
import com.dessert.project.dessert.DAO.UserRoleRepository;
import com.dessert.project.dessert.Entities.Consumers;
import com.dessert.project.dessert.Entities.Orders;
import com.dessert.project.dessert.Entities.Roles;
import com.dessert.project.dessert.Entities.UserRole;
import com.dessert.project.dessert.Service.interf.ServiceConsumerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
>>>>>>> b6ae9ab (Add roles):src/main/java/com/dessert/project/dessert/Service/impl/ServiceConsumerImpl.java
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

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

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

        String encodedPassword = passwordEncoder.encode(consumer.getPassword());
        consumer.setPassword(encodedPassword);

        consumerRepository.save(consumer);

        UserRole userRole = new UserRole();
        userRole.setUserId(consumer.getId());
        userRole.setRoleId(roleRepository.findByTitle(Roles.ROLE_USER.name()).get().getId());
        userRoleRepository.save(userRole);


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
