/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.icbtwebservice.resources;

/**
 *
 * @author Dinindu
 */
public class StaffUser {
    private String email;
    private String s_password;

    public StaffUser(String email, String s_password) {
        this.email = email;
        this.s_password = s_password;
    }

    public StaffUser() {
    }
    
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getS_password() {
        return s_password;
    }

    public void setS_password(String s_password) {
        this.s_password = s_password;
    }
    
    
}
