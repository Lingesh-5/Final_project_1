package com.example.realEstateListing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.realEstateListing.models.Property;
import java.util.List;


@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findByUserId(Long userId);
}
