/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.icbtwebservice.resources;

/**
 *
 * @author Dinindu
 */
public class Staff {
    
    private int id;
    private String s_name;
    private String email;
    private String s_contact;
    private String s_password;

    public Staff() {
    }

    
    
    public Staff(int id, String s_name, String email, String s_contact, String s_password) {
        this.id = id;
        this.s_name = s_name;
        this.email = email;
        this.s_contact = s_contact;
        this.s_password = s_password;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getS_contact() {
        return s_contact;
    }

    public void setS_contact(String s_contact) {
        this.s_contact = s_contact;
    }

    public String getS_password() {
        return s_password;
    }

    public void setS_password(String s_password) {
        this.s_password = s_password;
    }
    
    
    
    
    
}
