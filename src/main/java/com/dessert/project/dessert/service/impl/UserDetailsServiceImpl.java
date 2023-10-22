package com.dessert.project.dessert.service.impl;

import com.dessert.project.dessert.DAO.RoleRepository;
import com.dessert.project.dessert.DAO.UserRoleRepository;
import com.dessert.project.dessert.entities.UserRole;
import com.dessert.project.dessert.security.UserDetailsImpl;
import com.dessert.project.dessert.DAO.ConsumerRepository;
import com.dessert.project.dessert.entities.Consumers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private ConsumerRepository consumerRepository;
    public UserDetailsServiceImpl(ConsumerRepository consumerRepository){
        this.consumerRepository = consumerRepository;
    }

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional <Consumers> usernameOptional = consumerRepository.findByUsername(username);
        if(usernameOptional.isEmpty()){
            throw new UsernameNotFoundException("Consumer not found");
        }
        Consumers consumer = usernameOptional.get();

        setAuthorities(consumer);

        return new UserDetailsImpl(usernameOptional.get());
    }

    private void setAuthorities(Consumers consumer){

        int userId = consumer.getId();

        List<UserRole> userRoles = (List<UserRole>) userRoleRepository.findAllByUserId(userId);
        List <Integer> roleIds = userRoles.stream().map(userRole -> userRole.getRoleId()).collect(Collectors.toList());

        List <String> authorities = roleIds.stream().map(roleId -> roleRepository.findById(roleId).get().getTitle()).collect(Collectors.toList());

        consumer.setAuthorities(authorities);

    }
}
