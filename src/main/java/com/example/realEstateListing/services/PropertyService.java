package com.example.realEstateListing.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.realEstateListing.models.Property;
import com.example.realEstateListing.pojos.PropertyPayload;
import com.example.realEstateListing.repositories.PropertyRepository;

@Service
public class PropertyService {

    @Autowired private PropertyRepository propertyRepository;

    public void saveProperty(PropertyPayload payload) {

        if(payload.getPropertyId() == null) {
            Property property = new Property();
            property.setTitle(payload.getTitle());
            property.setDescription(payload.getDescription());
            property.setPrice(payload.getPrice());
            property.setType(payload.getType());
            property.setLocation(payload.getLocation());
            property.setOwnerId(payload.getOwnerId());
            property.setDateListed(LocalDate.now());
            property.setUserId(payload.getUserId());
            property.setAdminApproval(payload.getAdminApproval());
            property.setImageUrl(payload.getImageUrl());
            property.setContactNumber(payload.getContactNumber());
            propertyRepository.save(property);
        } else {
            Property property = propertyRepository.findById(payload.getPropertyId()).orElse(null);
            property.setTitle(payload.getTitle());
            property.setDescription(payload.getDescription());
            property.setPrice(payload.getPrice());
            property.setType(payload.getType());
            property.setLocation(payload.getLocation());
            property.setOwnerId(payload.getOwnerId());
            property.setDateListed(LocalDate.now());
            property.setUserId(payload.getUserId());
            property.setImageUrl(payload.getImageUrl());
            property.setContactNumber(payload.getContactNumber());
            propertyRepository.save(property);
        }
    }

    public ResponseEntity<?> getProperty(Long userId) {
        List<Property> properties = propertyRepository.findByUserId(userId);
        return ResponseEntity.ok(Map.of("properties", properties));
    }

    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }

    public ResponseEntity<?> getPropertyById(Long id) {
        Property property = propertyRepository.findById(id).orElse(null);
        return ResponseEntity.ok(Map.of("property", property));
    }

    public ResponseEntity<?> getAllProperty() {
        List<Property> properties = propertyRepository.findAll();
        return ResponseEntity.ok(Map.of("properties", properties));
    }
    
}
