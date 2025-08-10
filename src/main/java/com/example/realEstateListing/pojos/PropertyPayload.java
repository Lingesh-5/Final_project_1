package com.example.realEstateListing.pojos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyPayload {
    @NotBlank(message="Title must not be blank, Please enter title")
    private String title;
    @NotBlank(message="Description must not be blank, Please enter description")
    private String description;
    private Integer price;
    private String type;
    @NotBlank(message="Location must not be blank, Please enter location")
    private String location;
    private Integer ownerId;
    private Long userId;
    private Long propertyId;
    private String adminApproval;
    private String imageUrl;
    @NotBlank(message="Contact Number must not be blank, Please enter contact number")
    private String contactNumber;
}
