/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.icbtwebservice.resources;

/**
 *
 * @author Dinindu
 */
public class User {
    
    private String email;
    private String c_password;
    
    public User(String email, String c_password) {
        this.email = email;
        this.c_password = c_password;
    }

    public User() {
    }

    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return c_password;
    }

    public void setPassword(String c_password) {
        this.c_password = c_password;
    }
    
}
