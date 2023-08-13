package com.kushal.blogappapis.service;

import com.kushal.blogappapis.DTOs.UserDto;
import com.kushal.blogappapis.entity.User;
import com.kushal.blogappapis.exception.ResourceNotFoundException;
import com.kushal.blogappapis.repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return modelMapper.map(userRepo.save(user), UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, int id) {
        User user = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "update", id));
        user.setName(userDto.getName());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        return modelMapper.map(userRepo.save(user), UserDto.class);
    }

    @Override
    public UserDto findById(int id) {
        return modelMapper.map((userRepo.findById(id)).orElseThrow(() -> new ResourceNotFoundException("User", "id", id)), UserDto.class);
    }

    @Override
    public void deleteUserById(int id) {
        userRepo.deleteById(id);
    }
}
