package com.example.realEstateListing.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.context.support.WithMockUser;


import com.example.realEstateListing.services.PropertyService;

@WebMvcTest(PropertyController.class)
@AutoConfigureMockMvc(addFilters=false)
public class PropertyControllerTest {
    @Autowired private MockMvc mockMvc;
    @MockBean private PropertyService propertyService;

    @Test
    @WithMockUser(username="testuser", roles={"CUSTOMER"})
    public void testSavePropertyDetails() throws Exception {
        String requestBody = """
                        {
                            "title":"test",
                            "description":"test",
                            "price":123,
                            "type":"test",
                            "location":"test",
                            "ownerId":123,
                            "userId":123,
                            "adminApproval":"test",
                            "imageUrl":"test",
                            "contactNumber":"test"
                        }         
                """;
        mockMvc.perform(
            post("/user/rest/save-property")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
        )
        .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username="testuser", roles={"CUSTOMER"})
    public void testGetPropertyDetails() throws Exception {
    
        mockMvc.perform(get("/user/rest/get-property/1")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username="testuser", roles={"CUSTOMER"})
    public void testDeletePropertyDetails() throws Exception {
    
        mockMvc.perform(delete("/user/rest/delete-property/1")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username="testuser", roles={"CUSTOMER"})
    public void testGetPropertyDetailsById() throws Exception {
    
        mockMvc.perform(get("/user/rest/get-propertyById/1")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username="testuser", roles={"CUSTOMER"})
    public void testGetAllPropertyDetails() throws Exception {
    
        mockMvc.perform(get("/user/rest/get-allProperty")).andExpect(status().isOk());
    }
}
