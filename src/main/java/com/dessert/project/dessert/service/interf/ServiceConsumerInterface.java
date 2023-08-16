package com.dessert.project.dessert.service.interf;

import com.dessert.project.dessert.entities.Consumers;

import java.util.List;

public interface ServiceConsumerInterface {

    public List<Consumers> getAllConsumers();

    public void deleteConsumer(int id);

    public Consumers getConsumer(int id);

    public void saveConsumer(Consumers consumer);

    public void updateConsumer(Consumers consumer);

    public double getAvgAge();

    public int getMaleCount();

    public int getFemaleCount();

}
