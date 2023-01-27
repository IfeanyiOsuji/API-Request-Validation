package com.ify.api.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotNull(message ="username should not be null")
    @NotBlank(message = "username should not be empty")
    private String name;

    @Email(message = "invalid email address")
    private String email;
    @NotNull
    @Pattern(regexp = "^\\d{10}$", message = "invalid mobile no. entered")
    private String mobileNo;
    @Min(18)
    @Max(60)
    private int age;
    @NotBlank(message = "please provide your nationality")
    private String nationality;
}
