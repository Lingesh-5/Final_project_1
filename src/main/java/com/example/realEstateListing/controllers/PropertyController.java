package com.example.realEstateListing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.realEstateListing.pojos.PropertyPayload;
import com.example.realEstateListing.services.PropertyService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("user/rest")
@EnableMethodSecurity
@Validated
public class PropertyController {

    @Autowired private PropertyService propertyService;

    @PostMapping("/save-property")
    @PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<?> savePropertyDetails(@Valid @RequestBody PropertyPayload payload) {
        propertyService.saveProperty(payload);
        return ResponseEntity.ok("Saved successfully");
    }

    @GetMapping("/get-property/{userId}")
    @PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<?> getPropertyDetails(@PathVariable Long userId) {
        return ResponseEntity.ok(propertyService.getProperty(userId));
    }

    @DeleteMapping("/delete-property/{id}")
    @PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<?> deletePropertyDetails(@PathVariable Long id) {
        propertyService.deleteProperty(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    @GetMapping("/get-propertyById/{id}")
    @PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<?> getPropertyDetailsById(@PathVariable Long id) {
        return ResponseEntity.ok(propertyService.getPropertyById(id));
    }

    @GetMapping("/get-allProperty")
    @PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<?> getAllPropertyDetails() {
        return ResponseEntity.ok(propertyService.getAllProperty());
    }
    
    
    
    
    
}
