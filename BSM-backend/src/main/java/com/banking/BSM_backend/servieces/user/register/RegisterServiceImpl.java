package com.banking.BSM_backend.servieces.user.register;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banking.BSM_backend.dto.UserRegisterDTO;
import com.banking.BSM_backend.entity.UserEntity;
import com.banking.BSM_backend.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {
    private final UserRepository userRepository;

public  UserEntity postUser(UserRegisterDTO userRegisterDTO) {
    return saveOrUpdateUser(new UserEntity(), userRegisterDTO);

}
private UserEntity saveOrUpdateUser(UserEntity user, UserRegisterDTO userRegisterDTO) {
  user.setFullName(userRegisterDTO.getFullName());
  user.setEmail(userRegisterDTO.getEmail());
  user.setPhoneNumber(userRegisterDTO.getPhoneNumber());
  user.setUsername(userRegisterDTO.getUsername());
  user.setPassword(userRegisterDTO.getPassword());
  return userRepository.save(user);
}
public UserEntity  updateUserEntity(long id, UserRegisterDTO userRegisterDTO) {
  Optional <UserEntity> user = userRepository.findById(id);
  if(user.isPresent()){
    return saveOrUpdateUser(user.get(), userRegisterDTO);
  }
  else{
    throw  new EntityNotFoundException( "User is not present with id : " + id);
  }
}

public List<UserEntity> getAllUsers() {
    return userRepository.findAll();
}
public  UserEntity getUserById(long id) {
    Optional<UserEntity> user = userRepository.findById(id);
    if(user.isPresent()){
      return user.get();
    }
    else{
      throw  new EntityNotFoundException( "User is not present with id : " + id);
    }
  }
  public void deleteUserById(long id) {
    Optional<UserEntity> user = userRepository.findById(id);
    if(user.isPresent()){
      userRepository.deleteById(id);
    }
    else{
      throw  new EntityNotFoundException( "User is not present with id : " + id);
    }
  }
}
