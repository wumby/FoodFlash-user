package com.jack.user.controller;

import com.jack.user.dto.UserDTO;
import com.jack.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
        UserDTO userAdded = userService.addUser(userDTO);
        return new ResponseEntity<>(userAdded, HttpStatus.CREATED);

    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId){
        return userService.getUserById(userId);
    }



}
