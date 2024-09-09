/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.icbtwebservice.resources;

import java.util.List;

/**
 *
 * @author tharindulakshan
 */
public interface DBUtils {
    
    public List<Student> getStudents();
    
    public Student getStudent(int id);
    
    public boolean addStudent(Student st);
    
    public boolean updateStudent(Student st);
    
    public boolean deleteStudent(int id);
    
    
    
    public List<Customer> getCustomers();
    
    public Customer getCustomer(int id);
    
    public boolean addCustomer(Customer st);
    
    public boolean updateCustomer(Customer st);
    
    public boolean deleteCustomer(int id);
    
    
    
    public List<Staff> getStaffs();
    
    public Staff getStaff(int id);
    
    public boolean addStaff(Staff st);
    
    public boolean updateStaff(Staff st);
    
    public boolean deleteStaff(int id);
    
    
    public List<Reservation> getReservations();
    
    public Reservation getReservation(int id);
    
    public boolean addReservation(Reservation st);
    
    
    public List<Query> getQuerys();
    
    public Query getQuery(int id);
    
    public boolean addQuery(Query st);
    
    
    public boolean userLogin(String email, String c_password);
    
    public boolean SuserLogin(String email, String s_password);
    
}
