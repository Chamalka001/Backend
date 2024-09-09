/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.icbtwebservice.resources;

/**
 *
 * @author Dinindu
 */
public class Reservation {
    
    private int id;
    private String c_name;
    private String date;
    private String time;
    private String tables;
    private String guests;
    private String decoration;
    private String meal;
    private String contact;

    public Reservation() {
    }
    
    

    public Reservation(int id, String c_name, String date, String time, String tables, String guests, String decoration, String meal, String contact) {
        this.id = id;
        this.c_name = c_name;
        this.date = date;
        this.time = time;
        this.tables = tables;
        this.guests = guests;
        this.decoration = decoration;
        this.meal = meal;
        this.contact = contact;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTables() {
        return tables;
    }

    public void setTables(String tables) {
        this.tables = tables;
    }

    public String getGuests() {
        return guests;
    }

    public void setGuests(String guests) {
        this.guests = guests;
    }

    public String getDecoration() {
        return decoration;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    
    
}
