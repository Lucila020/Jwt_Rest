package com.example.insertBdRestJsonDemo.controller;

import com.example.insertBdRestJsonDemo.config.JwtTokenUtil;
import com.example.insertBdRestJsonDemo.persistence.model.JwtRequest;
import com.example.insertBdRestJsonDemo.persistence.model.JwtResponse;
import com.example.insertBdRestJsonDemo.persistence.model.User;
import com.example.insertBdRestJsonDemo.persistence.model.UserDTO;
import com.example.insertBdRestJsonDemo.repository.PrivilegeRepository;
import com.example.insertBdRestJsonDemo.repository.RoleRepository;
import com.example.insertBdRestJsonDemo.repository.UserRepository;
import com.example.insertBdRestJsonDemo.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
public class DemoController {

   private PrivilegeRepository privilegeRepository;

    private RoleRepository roleRepository;
    private UserRepository userRepository;


    public DemoController() {
    }

    public DemoController(PrivilegeRepository privilegeRepository, RoleRepository roleRepository, UserRepository userRepository) {
        this.privilegeRepository = privilegeRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }


    @RequestMapping("/users")
    public String getUsers(Model model){

        model.addAttribute("users", userRepository.findAll());
        return "users";
    }


    @RequestMapping("/privileges")
    public String getPrivileges(Model model){

        model.addAttribute("privileges", privilegeRepository.findAll());
        return "privileges";
    }

    @RequestMapping("/roles")
    public String getRoles(Model model){

        model.addAttribute("roles", roleRepository.findAll());
        return "roles";
    }


}
