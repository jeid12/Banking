package com.banking.BSM_backend.servieces.user.register;

import java.util.List;

import com.banking.BSM_backend.dto.UserRegisterDTO;
import com.banking.BSM_backend.entity.UserEntity;

public interface RegisterService {
UserEntity postUser(UserRegisterDTO userRegisterDTO);

List<UserEntity> getAllUsers();

UserEntity getUserById(long id);

UserEntity updateUserEntity(long id, UserRegisterDTO userRegisterDTO);

void deleteUserById(long id);


}
