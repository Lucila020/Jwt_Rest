package com.example.insertBdRestJsonDemo.controller;



import com.example.insertBdRestJsonDemo.config.JwtTokenUtil;
import com.example.insertBdRestJsonDemo.persistence.model.*;
import com.example.insertBdRestJsonDemo.repository.UserRepository;
import com.example.insertBdRestJsonDemo.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        User user= new User();
        user.setUsername(authenticationRequest.getUsername());
        JwtResponse jwtResponse = new JwtResponse(token);
        user.setPassword(jwtResponse.getToken());
        user.setFirstName("Pablo");
        user.setLastName("Lucero");
        user.setEmail("pablo.lucero@gmail.com");

        Role role1 = new Role();
        role1.setName("ROLE_USER");
        Collection<Role> crole = new ArrayList<>();
        crole.add(role1);


        //Privilegios
        Privilege priv = new Privilege();
        priv.setName("READ_PRIVILEGE");
        user.setRoles(crole);
        priv.setRoles(crole);

        Collection<User> cuser = new ArrayList<>();
        cuser.add(user);

        role1.setUsers(cuser);

        userRepository.save(user);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @RequestMapping(value = "/hello/{token}", method = RequestMethod.GET)
    public String firstPage(@PathVariable(value = "token") String token) {

        return "Hello World - Sucess  - El nombre de usuario es : " + jwtTokenUtil.getUsernameFromToken(token) + "  "+ userRepository.findByUsername(jwtTokenUtil.getUsernameFromToken(token)).getFirstName()
                + "  "+ userRepository.findByUsername(jwtTokenUtil.getUsernameFromToken(token)).getLastName();
    }
}
