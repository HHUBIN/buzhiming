package com.buzhiming.DTO;

import lombok.Data;

@Data
public class RegisterDTO {
    private String name;
    private String gender;
    private String password;
    private String email;
    private String emailCode;
    private String description;
}
