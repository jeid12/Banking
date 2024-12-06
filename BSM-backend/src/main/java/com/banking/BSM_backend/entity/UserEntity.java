package com.banking.BSM_backend.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String FullName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
     private String phoneNumber;

     @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
}
