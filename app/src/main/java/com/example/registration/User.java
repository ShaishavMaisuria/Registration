package com.example.registration;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    String email;
    String ID;
    String department;

    public User(String name, String email, String ID, String department) {
        this.name = name;
        this.email = email;
        this.ID = ID;
        this.department = department;
    }
    public User(){

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getID() {
        return ID;
    }

    public String getDepartment() {
        return department;
    }
}
