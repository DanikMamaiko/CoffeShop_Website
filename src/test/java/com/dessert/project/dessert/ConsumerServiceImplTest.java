//package com.dessert.project.dessert;
//
//import com.dessert.project.dessert.DAO.ConsumerRepository;
//import com.dessert.project.dessert.Entities.Consumers;
//import com.dessert.project.dessert.Entities.Orders;
//import com.dessert.project.dessert.Service.impl.ServiceConsumerImpl;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class consumerServiceImplTest {
//
//    @Mock
//    private ConsumerRepository consumerRepository;
//
//    @InjectMocks
//    private ServiceConsumerImpl consumerService;
//
//    @Test
//    void getAllConsumers() {
//        List<Consumers> expectedConsumer = new ArrayList<>();
//        expectedConsumer.add(new Consumers());
//        expectedConsumer.add(new Consumers());
//
//        when(consumerRepository.findAll()).thenReturn(expectedConsumer);
//
//        List <Consumers> actualConsumer = consumerService.getAllConsumers();
//        verify(consumerRepository, Mockito.times(1)).findAll();
//
//        assertEquals(expectedConsumer, actualConsumer);
//    }
//
//    @Test
//    void deleteConsumer() {
//        int consumerId = 1;
//        Consumers consumer = new Consumers();
//        consumer.setId(consumerId);
//
//        Orders order1 = new Orders();
//        Orders order2 = new Orders();
//        List <Orders> ordersList = new ArrayList<>();
//        ordersList.add(order1);
//        ordersList.add(order2);
//
//        consumer.setOrdersList(ordersList);
//
//        when(consumerRepository.getById(consumerId)).thenReturn(consumer);
//
//        consumerService.deleteConsumer(consumerId);
//        verify(consumerRepository, Mockito.times(1)).deleteById(consumerId);
//
//        Optional<Consumers> deletedConsumer = consumerRepository.findById(1);
//        assertFalse(deletedConsumer.isPresent());
//
//    }
//
//    @Test
//    void getConsumer(){
//
//        int consumerId = 1;
//        Consumers expectedConsumer = new Consumers();
//        expectedConsumer.setId(consumerId);
//
//        when(consumerRepository.findById(consumerId)).thenReturn(Optional.of(expectedConsumer));
////        verify(consumerRepository).findById(consumerId);
//
//        Consumers actualConsumer = consumerService.getConsumer(consumerId);
//
//        assertEquals(consumerId, actualConsumer.getId());
//        assertNotNull(actualConsumer);
//    }
//
//    @Test
//    void saveConsumer(){
//
//        Consumers consumer = new Consumers();
//
//        consumerService.saveConsumer(consumer);
//        verify(consumerRepository).save(consumer);
//    }
//
//    @Test
//    void updateConsumer(){
//
//        Consumers existingConsumer = new Consumers();
//        existingConsumer.setId(1);
//        existingConsumer.setName("Danik");
//        existingConsumer.setSurname("Mamaiko");
//        existingConsumer.setSex("male");
//        existingConsumer.setAge(18);
//
//        consumerRepository.save(existingConsumer);
//
//        Consumers updatedConsumer = new Consumers();
//        updatedConsumer.setId(1);
//        updatedConsumer.setName("Danik");
//        updatedConsumer.setSurname("Mamaiko");
//        updatedConsumer.setSex("male");
//        updatedConsumer.setAge(19);
//
//        when(consumerRepository.getById(1)).thenReturn(existingConsumer);
//
//        consumerService.updateConsumer(updatedConsumer);
//        verify(consumerRepository, times(1)).getById(1);
//
//        when(consumerRepository.findById(1)).thenReturn(Optional.of(existingConsumer));
//
//        Consumers retrievedConsumer = consumerService.getConsumer(1);
//        verify(consumerRepository, times(1)).findById(1);
//
//        assertEquals(updatedConsumer.getId(), retrievedConsumer.getId());
//        assertEquals(updatedConsumer.getName(), retrievedConsumer.getName());
//        assertEquals(updatedConsumer.getSurname(), retrievedConsumer.getSurname());
//        assertEquals(updatedConsumer.getSex(), retrievedConsumer.getSex());
//        assertEquals(updatedConsumer.getAge(), retrievedConsumer.getAge());
//    }
//
//    @Test
//    void getAvgAge(){
//        Consumers consumer1 = new Consumers();
//        Consumers consumer2 = new Consumers();
//        Consumers consumer3 = new Consumers();
//        consumer1.setAge(10);
//        consumer2.setAge(20);
//        consumer3.setAge(30);
//
//        double result = (consumer1.getAge()+consumer2.getAge()+consumer3.getAge())/3;
//
//        assertEquals((10+20+30)/3, result);
//    }
//
//    @Test
//    void getMaleCount(){
//        Consumers consumer1 = new Consumers();
//        Consumers consumer2 = new Consumers();
//        Consumers consumer3 = new Consumers();
//        consumer1.setSex("male");
//        consumer2.setSex("male");
//        consumer3.setSex("female");
//
//        int count = 0;
//
//        List <Consumers> consumersList = new ArrayList<>();
//        consumersList.add(consumer1);
//        consumersList.add(consumer2);
//        consumersList.add(consumer3);
//
//        for(Consumers consumer: consumersList){
//            if(consumer.getSex().equals("male")){
//                count++;
//            }
//        }
//
//        assertEquals(2, count);
//    }
//
//    @Test
//    void getFemaleCount(){
//        Consumers consumer1 = new Consumers();
//        Consumers consumer2 = new Consumers();
//        Consumers consumer3 = new Consumers();
//        consumer1.setSex("male");
//        consumer2.setSex("female");
//        consumer3.setSex("female");
//
//        int count = 0;
//
//        List <Consumers> consumersList = new ArrayList<>();
//        consumersList.add(consumer1);
//        consumersList.add(consumer2);
//        consumersList.add(consumer3);
//
//        for(Consumers consumer: consumersList){
//            if(consumer.getSex().equals("female")){
//                count++;
//            }
//        }
//
//        assertEquals(2, count);
//    }
//
//
//}
