package com.example.SimpleTaksPraksa.controller;

import com.example.SimpleTaksPraksa.dto.UserLoginDTO;
import com.example.SimpleTaksPraksa.model.User;
import com.example.SimpleTaksPraksa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userServices;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/registration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registration(@RequestBody User user){
        return new ResponseEntity<>(userServices.registration(user), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody UserLoginDTO user){
        return new ResponseEntity<>(userServices.login(user), HttpStatus.OK);
    }


}
