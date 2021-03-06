package com.example.insertBdRestJsonDemo.repository;


import com.example.insertBdRestJsonDemo.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByUsername(String username);

    @Override
    void delete(User user);

}
