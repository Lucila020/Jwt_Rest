package com.example.insertBdRestJsonDemo.persistence.model;

import java.io.Serializable;
import java.util.Collection;

public class JwtRequest implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;
    private String username;
    private String password;
  //  private String firstName;
  //  private String lastName;
  //  private String email;
  //  private boolean enabled;
  //  private Collection<Role> roles;

    //need default constructor for JSON Parsing
    public JwtRequest()
    {
    }
    public JwtRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    /**public JwtRequest(String username, String password, String firstName, String lastName, String email, Collection<Role> roles) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enabled = false;
        this.roles = roles;
    }**/

    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    /**public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }**/
}
