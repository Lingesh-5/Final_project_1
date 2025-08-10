package com.example.realEstateListing.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
@EnableMethodSecurity
public class AdminWebController {

    @GetMapping("/user-list")
    @PreAuthorize("hasRole('ADMIN')")
    public String userList() {
        return "user-list.html";
    }

    @GetMapping("/property-list")
    public String propertyList() {
        return "admin-property-list";
    }
    
    
    
}
