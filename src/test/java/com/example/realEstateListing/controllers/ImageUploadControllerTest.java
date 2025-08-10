package com.example.realEstateListing.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import com.cloudinary.Cloudinary;
import com.cloudinary.Uploader;

@WebMvcTest(ImageUploadController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ImageUploadControllerTest {

    @Autowired private MockMvc mockMvc;
    @MockBean private Cloudinary cloudinary;
    @Mock private Uploader uploader;

        @Test
        public void testUploadImage() throws Exception {

        when(cloudinary.uploader()).thenReturn(uploader);

        Map<String, Object> mockResponse = new HashMap<>();
        mockResponse.put("url", "https://mock.cloudinary.com/image.jpg");

        when(uploader.upload(any(byte[].class), anyMap()))
                .thenReturn(mockResponse);

        MockMultipartFile file = new MockMultipartFile("file", "test.jpg", "image/jpeg", "test-image-content".getBytes());

        mockMvc.perform(multipart("/api/images/upload")
                .file(file))
                .andExpect(status().isOk());
        }

    }
