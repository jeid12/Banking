package com.banking.BSM_backend.dto;


import lombok.Data;

@Data
public class UserRegisterDTO {
    
    private Long id;

    
    private String FullName;

    
    private String email;

    
     private String phoneNumber;

    
    private String username;

    
    private String password;


}
