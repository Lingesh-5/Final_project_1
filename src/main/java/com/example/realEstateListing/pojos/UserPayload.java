package com.example.realEstateListing.pojos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPayload {
    @NotBlank(message="Name must not be blank, Please enter Name")
    private String name;
    @NotBlank(message="Email must not be blank, Please enter Email")
    private String email;
    private String password;
    private String role;
    private Long userId;
}
