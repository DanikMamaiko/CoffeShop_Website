package com.dessert.project.dessert.Service.impl;

import com.dessert.project.dessert.security.UserDetailsImpl;
import com.dessert.project.dessert.DAO.ConsumerRepository;
import com.dessert.project.dessert.Entities.Consumers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ConsumerRepository consumerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional <Consumers> usernameOptional = consumerRepository.findByUsername(username);
        if(usernameOptional.isEmpty()){
            throw new UsernameNotFoundException("Consumer not found");
        }
        return new UserDetailsImpl(usernameOptional.get());
    }
}
