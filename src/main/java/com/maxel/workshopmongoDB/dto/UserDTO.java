package com.maxel.workshopmongoDB.dto;

import com.maxel.workshopmongoDB.domain.User;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private String id;
    private String name;
    private String email;

    public UserDTO() {}

    public UserDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.id = user.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
