package com.example.realEstateListing.configs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.realEstateListing.models.Role;
import com.example.realEstateListing.repositories.RoleRepository;

@Configuration
public class DataInitializer {

    @Autowired
    private RoleRepository roleRepository;

    @Bean
    public String initData() {
        List<Role> roles = roleRepository.findAll();
        if(roles.isEmpty()) {
            roleRepository.save(new Role(null, "ADMIN"));
            roleRepository.save(new Role(null, "CUSTOMER"));
        }
        return "Method initiated";
    }
    
}
