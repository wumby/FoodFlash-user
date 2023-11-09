package com.jack.user.service;

import com.jack.user.dto.UserDTO;
import com.jack.user.entity.User;
import com.jack.user.mapper.UserMapper;
import com.jack.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserDTO addUser(UserDTO userDTO){
       User userAdded = userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
       return UserMapper.INSTANCE.mapUserToUserDTO(userAdded);
    }


    public ResponseEntity<UserDTO> getUserById(Integer userId) {
        Optional<User> user = userRepo.findById(userId);
        if(user.isPresent()){
            return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(user.get()), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
}
