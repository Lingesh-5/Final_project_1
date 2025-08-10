package com.example.realEstateListing.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@EnableMethodSecurity
public class PropertyWebController {

    @GetMapping("/property")
    @PreAuthorize("hasRole('CUSTOMER')")
    public String property() {
        return "property.html";
    }

    @GetMapping("/property-list")
    @PreAuthorize("hasRole('CUSTOMER')")
    public String propertyList() {
        return "property-list.html";
    }

    @GetMapping("/property-details")
    @PreAuthorize("hasRole('CUSTOMER')")
    public String propertyDetails() {
        return "property-details.html";
    }
    
    
}
