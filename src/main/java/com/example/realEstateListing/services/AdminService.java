package com.example.realEstateListing.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.realEstateListing.models.Property;
import com.example.realEstateListing.models.User;
import com.example.realEstateListing.pojos.PropertyPayload;
import com.example.realEstateListing.pojos.UserPayload;
import com.example.realEstateListing.repositories.PropertyRepository;
import com.example.realEstateListing.repositories.UserRepository;

@Service
public class AdminService {

    @Autowired private UserRepository userRepository;
    @Autowired private PropertyRepository propertyRepository;

    public ResponseEntity<?> getAllUser() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(Map.of("users", users));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public ResponseEntity<?> getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return ResponseEntity.ok(Map.of("user", user));
    }

    public void saveUser(UserPayload payload) {
        User user = userRepository.findById(payload.getUserId()).orElse(null);
        user.setName(payload.getName());
        user.setEmail(payload.getEmail());
        userRepository.save(user);
    }

    public ResponseEntity<?> getAllProperty() {
        List<Property> properties = propertyRepository.findAll();
        return ResponseEntity.ok(Map.of("properties", properties));
    }

    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }

    public void savePropertyApproval(PropertyPayload payload) {
        Property property = propertyRepository.findById(payload.getPropertyId()).orElse(null);
        property.setAdminApproval(payload.getAdminApproval());
        propertyRepository.save(property);
    }
    
}
