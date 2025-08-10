package com.example.realEstateListing.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.realEstateListing.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Set<Role> findByName(String name);
    
}
