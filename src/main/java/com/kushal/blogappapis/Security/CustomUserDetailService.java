package com.kushal.blogappapis.Security;

import com.kushal.blogappapis.entity.User;
import com.kushal.blogappapis.exception.ResourceNotFoundException;
import com.kushal.blogappapis.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //loading user from db using username(email)
        User user = userRepo.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User", "email: " + username, 0));
        return user;
    }
}
