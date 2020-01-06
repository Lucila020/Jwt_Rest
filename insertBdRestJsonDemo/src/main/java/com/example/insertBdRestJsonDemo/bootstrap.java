package com.example.insertBdRestJsonDemo;

import com.example.insertBdRestJsonDemo.persistence.model.Privilege;
import com.example.insertBdRestJsonDemo.persistence.model.Role;
import com.example.insertBdRestJsonDemo.persistence.model.User;
import com.example.insertBdRestJsonDemo.repository.PrivilegeRepository;
import com.example.insertBdRestJsonDemo.repository.RoleRepository;
import com.example.insertBdRestJsonDemo.repository.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**@Component
public class bootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private PrivilegeRepository privilegeRepository;

    private RoleRepository roleRepository;

    private UserRepository userRepository;

    public bootstrap(PrivilegeRepository privilegeRepository, RoleRepository roleRepository, UserRepository userRepository) {
        this.privilegeRepository = privilegeRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) { initData();}



        private void initData(){
     //User
        User user = new User();
        user.setFirstName("Lucila");
        user.setLastName("Llanos");
        user.setEmail("lucila.llanos@gmail.com");
        user.setPassword("CataFran1!");


        User user1 = new User();
        user1.setFirstName("Pepe");
        user1.setLastName("Argento");
        user1.setEmail("pepe.argento@gmail.com");
        user1.setPassword("pearge123!");

        //Role
        Role role = new Role();
        role.setName("ADMIN");


        Role role1 = new Role();
        role1.setName("ROLE_USER");


        //Privilegios
        Privilege priv = new Privilege();
        priv.setName("READ_PRIVILEGE");

        Privilege priv1 = new Privilege();
        priv1.setName("WRITE_PRIVILEGE");


        Collection<Role> crole = new ArrayList<>();
        crole.add(role);
        crole.add(role1);

        user.setRoles(crole);

        priv.setRoles(crole);
        priv1.setRoles(crole);

        Collection<User> cuser = new ArrayList<>();
        cuser.add(user1);

        role.setUsers(cuser);
        role1.setUsers(cuser);

        Collection<Privilege> cpriv = new ArrayList<>();
        cpriv.add(priv);
        cpriv.add(priv1);

        role.setPrivileges(cpriv);
        role1.setPrivileges(cpriv);

        userRepository.save(user);
        userRepository.save(user1);

        roleRepository.save(role);
        roleRepository.save(role1);

        privilegeRepository.save(priv);
        privilegeRepository.save(priv1);
    }




}**/
