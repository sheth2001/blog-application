package com.kushal.blogappapis.controller;

import com.kushal.blogappapis.DTOs.UserDto;
import com.kushal.blogappapis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("{id}")
    private ResponseEntity<UserDto> findUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/signup")
    private ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto) {
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<UserDto> updateUser(@RequestBody @Valid UserDto userDto, @PathVariable int id) {
        return ResponseEntity.ok(userService.updateUser(userDto, id));
    }
}
