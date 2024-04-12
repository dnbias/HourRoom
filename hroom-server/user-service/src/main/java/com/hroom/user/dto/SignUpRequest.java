package com.hroom.user.dto;

import lombok.Data;
import com.hroom.user.entity.User.Capability;

@Data
public class SignUpRequest {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String role;
}
