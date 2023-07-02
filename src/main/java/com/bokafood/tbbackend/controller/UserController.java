package com.bokafood.tbbackend.controller;


import com.bokafood.tbbackend.dto.users.UserDTO;
import com.bokafood.tbbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    /*@Autowired
    private UserService userService;


    @GetMapping("/login")
    public ResponseEntity<UserDTO> login() {
        return new ResponseEntity<>(userService., HttpStatus.OK);
    }*/
}
