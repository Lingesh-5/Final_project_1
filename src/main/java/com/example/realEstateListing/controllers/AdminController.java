package com.example.realEstateListing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.realEstateListing.pojos.PropertyPayload;
import com.example.realEstateListing.pojos.UserPayload;
import com.example.realEstateListing.services.AdminService;



@RestController
@RequestMapping("/admin/rest")
@EnableMethodSecurity
public class AdminController {

    @Autowired private AdminService adminService;

    @GetMapping("/get-allUser")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllUserDetails() {
        return ResponseEntity.ok(adminService.getAllUser());
    }

    @DeleteMapping("/delete-user/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteUserDetails(@PathVariable Long id) {
        adminService.deleteUser(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    @GetMapping("/get-userById/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getUserDetailsById(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.getUserById(id));
    }

    @PostMapping("/save-user")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> saveUserDetails(@RequestBody UserPayload payload) {
        adminService.saveUser(payload);
        return ResponseEntity.ok("Saved successfully");
    }

    @GetMapping("/get-allProperty")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllPropertyDetails() {
        return ResponseEntity.ok(adminService.getAllProperty());
    }

    @DeleteMapping("/delete-property/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deletePropertyDetails(@PathVariable Long id) {
        adminService.deleteProperty(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    @PostMapping("/save-propertyApproval")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> savePropertyApprovalDetail(@RequestBody PropertyPayload payload) {
        adminService.savePropertyApproval(payload);
        return ResponseEntity.ok("Approved successfully");
    }
    
    
    
    
}
