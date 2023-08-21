package com.example.html.controller;


import com.example.html.domain.UserHtml;
import com.example.html.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserHtml>> getUsersFromDb(){
        return new ResponseEntity<>(userService.getUsersFromDb(),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UserHtml> addUsersFromHtml(@RequestParam MultipartFile file) throws IOException {
        return new ResponseEntity<>(userService.addUsersFromHtml(file), HttpStatus.CREATED);
    }
}
