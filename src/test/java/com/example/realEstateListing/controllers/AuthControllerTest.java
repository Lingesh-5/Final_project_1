package com.example.realEstateListing.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.realEstateListing.services.AuthService;

@WebMvcTest(AuthController.class)
@AutoConfigureMockMvc(addFilters=false)
public class AuthControllerTest {
    @Autowired private MockMvc mockMvc;
    @MockBean private AuthService authService; 

    @Test
    public void testSaveRegisterDetails() throws Exception {
        String requestBody = """
                        {
                            "name":"test",
                            "email":"test2@mail.com",
                            "password":"test2",
                            "role":"test234"
                        }         
                """;
        mockMvc.perform(
            post("/auth/rest/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
        )
        .andExpect(status().isOk());
    }

    @Test
    public void testLoginVerify() throws Exception {
        String requestBody = """
                        {
                            "email":"test2@mail.com",
                            "password":"test2"
                        }         
                """;
        mockMvc.perform(
            post("/auth/rest/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
        )
        .andExpect(status().isOk());
    }
    
}
