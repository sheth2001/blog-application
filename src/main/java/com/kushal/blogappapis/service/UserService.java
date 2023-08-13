package com.kushal.blogappapis.service;

import com.kushal.blogappapis.DTOs.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, int id);
    UserDto findById(int id);
    void deleteUserById(int id);
}
