package com.example.insertBdRestJsonDemo.service;


import com.example.insertBdRestJsonDemo.persistence.model.UserDTO;
import com.example.insertBdRestJsonDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
  //  private User user;
  @Autowired
  private UserRepository userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("javainuse".equals(username)) {
            return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
      /**  User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());**/



/**
    public UserRepository save(UserDTO user) {
        User newUser = new  User();
        newUser.setUsername(user.getUsername());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setRoles(user.getRoles());
        newUser.setEnabled(user.isEnabled());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return (UserRepository) userDao.save(newUser);
    }**/
}

