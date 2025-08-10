package com.example.realEstateListing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.realEstateListing.pojos.LoginPayload;
import com.example.realEstateListing.pojos.UserPayload;
import com.example.realEstateListing.services.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth/rest")
@Validated
public class AuthController {

    @Autowired private AuthService authService;

    @PostMapping("/save-register")
    public ResponseEntity<?> saveRegisterDetails(@Valid @RequestBody UserPayload payload) {
        authService.saveRegister(payload);   
        return ResponseEntity.ok("Registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginVerify(@RequestBody LoginPayload payload) {
        return ResponseEntity.ok(authService.verify(payload));
    }
    
}
