package com.example.realEstateListing.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.example.realEstateListing.services.AdminService;

@WebMvcTest(AdminController.class)
@AutoConfigureMockMvc(addFilters=false)
public class AdminControllerTest {
    @Autowired private MockMvc mockMvc;
    @MockBean private AdminService adminService;

    @Test
    @WithMockUser(username="testuser", roles={"ADMIN"})
    public void testGetAllUserDetails() throws Exception {        

        mockMvc.perform(get("/admin/rest/get-allUser")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username="testuser", roles={"ADMIN"})
    public void testDeleteUserDetails() throws Exception {
    
        mockMvc.perform(delete("/admin/rest/delete-user/1")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username="testuser", roles={"ADMIN"})
    public void testGetUserDetailsById() throws Exception {
    
        mockMvc.perform(get("/admin/rest/get-userById/1")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username="testuser", roles={"ADMIN"})
    public void testSaveUserDetails() throws Exception {
        String requestBody = """
                        {
                            "name":"test",
                            "email":"test2@mail.com",
                            "password":"test2",
                            "role":"test234"
                        }         
                """;
        mockMvc.perform(
            post("/admin/rest/save-user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
        )
        .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username="testuser", roles={"ADMIN"})
    public void testGetAllPropertyDetails() throws Exception {
    
        mockMvc.perform(get("/admin/rest/get-allProperty")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username="testuser", roles={"ADMIN"})
    public void testDeletePropertyDetails() throws Exception {
    
        mockMvc.perform(delete("/admin/rest/delete-property/1")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username="testuser", roles={"ADMIN"})
    public void testSavePropertyApprovalDetail() throws Exception {
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
            post("/admin/rest/save-propertyApproval")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
        )
        .andExpect(status().isOk());
    }
    
}
