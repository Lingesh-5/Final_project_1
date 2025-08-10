package com.example.realEstateListing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.realEstateListing.models.User;


@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    User findByEmail(String email);
}
