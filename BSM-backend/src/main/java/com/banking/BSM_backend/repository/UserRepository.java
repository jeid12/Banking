package com.banking.BSM_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.BSM_backend.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
List<UserEntity> findByUsername(String username);

}
