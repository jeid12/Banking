package com.banking.BSM_backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.BSM_backend.dto.UserRegisterDTO;
import com.banking.BSM_backend.entity.UserEntity;
import com.banking.BSM_backend.servieces.user.register.RegisterService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;




@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
private final RegisterService registerService;

@PostMapping
public ResponseEntity<?> postUser(@RequestBody UserRegisterDTO dto) {
    UserEntity createdUser = registerService.postUser(dto);
    if(createdUser !=null){
        return  ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }else{
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}

@GetMapping("/all")
public ResponseEntity<?> getAllUsers(){
    return ResponseEntity.ok(registerService.getAllUsers());
}

@GetMapping("/{id}")
public  ResponseEntity<?> getUserById(@PathVariable long id){
    try{
        UserEntity user = registerService.getUserById(id);
        return ResponseEntity.ok(user);
    }catch(EntityNotFoundException e){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    catch(Exception e){
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}

@PutMapping("/{id}")
public  ResponseEntity<?> updateUserEntity(@PathVariable long id,  @RequestBody UserRegisterDTO userRegisterDTO){
    try{
        UserEntity user = registerService.updateUserEntity(id, userRegisterDTO);
        return ResponseEntity.ok(user);
    }catch(EntityNotFoundException e){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    catch(Exception e){
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}

@DeleteMapping("/{id}")
public ResponseEntity<?> deleteUserById(@PathVariable long id){
    try{
        registerService.deleteUserById(id);
        return  ResponseEntity.ok("User deleted successfully");
    }catch(EntityNotFoundException e){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    catch(Exception e){
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
}



