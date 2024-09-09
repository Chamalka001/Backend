/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.icbtwebservice.resources;

/**
 *
 * @author Dinindu
 */
public class Customer {
    
    private int id;
    private String c_name;
    private String email;
    private String c_contact;
    private String c_password;

    public Customer() {
    }

    
    public Customer(int id, String c_name, String email, String c_contact, String c_password) {
        this.id = id;
        this.c_name = c_name;
        this.email = email;
        this.c_contact = c_contact;
        this.c_password = c_password;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getC_contact() {
        return c_contact;
    }

    public void setC_contact(String c_contact) {
        this.c_contact = c_contact;
    }

    public String getC_password() {
        return c_password;
    }

    public void setC_password(String c_password) {
        this.c_password = c_password;
    }
    
    
    
}
