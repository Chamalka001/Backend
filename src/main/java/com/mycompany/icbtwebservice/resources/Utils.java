/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.icbtwebservice.resources;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
/**
 *
 * @author tharindulakshan
 */
public class Utils implements DBUtils{
    

    @Override
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                students.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("dateOfBirth")));
            }
        } catch (SQLException e) {
            return null;
        }

        return students;
    }

    @Override
    public Student getStudent(int id) {
        Student student = null;
        try {
            
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE id=" + id);
            if (rs.next()) {
                student = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("dateOfBirth"));
            }
        } catch (SQLException e) {
            return null;
        }

        return student;
    }

    @Override
    public boolean addStudent(Student st) {
        
        try {
            
            String query = "INSERT INTO students (id, name, dateOfBirth) VALUES (?, ?, ?)";
            
            Connection con = MyConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, st.getId());
            pst.setString(2, st.getName());
            pst.setString(3, st.getDateOfBirth());
            
            int rowAffected = pst.executeUpdate();
            
            pst.close();
            con.close();
            
            return rowAffected == 1;
            
            
        } catch (Exception e) {
            
            System.out.println("ADD STUDENT ERROR: " + e);
            return false;
            
        }
    }

    @Override
    public boolean updateStudent(Student st) {
        try {
            Connection conn = MyConnection.getConnection();

            // Create a prepared statement with an SQL query to update a student
            String query = "UPDATE students SET name=?, dateOfBirth=? WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, st.getName());
            pstmt.setString(2, st.getDateOfBirth());
            pstmt.setInt(3, st.getId());

            // Execute the update query
            int rowsAffected = pstmt.executeUpdate();

            // Close resources
            pstmt.close();
            conn.close();

            // Check if the update was successful (1 row affected means success)
            return rowsAffected == 1;

        } catch (SQLException e) {
            e.printStackTrace();  // Handle or log the exception properly
            return false;
        }
    }

    @Override
    public boolean deleteStudent(int id) {
        try {
            Connection conn = MyConnection.getConnection();

            // Create a prepared statement with an SQL query to delete a student
            String query = "DELETE FROM students WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);

            // Execute the delete query
            int rowsAffected = pstmt.executeUpdate();

            // Close resources
            pstmt.close();
            conn.close();

            // Check if the delete was successful (1 row affected means success)
            return rowsAffected == 1;

        } catch (SQLException e) {
            e.printStackTrace();  // Handle or log the exception properly
            return false;
        }
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer");

            while (rs.next()) {
                customers.add(new Customer(rs.getInt("id"), rs.getString("c_name"), rs.getString("email"), rs.getString("c_contact"), rs.getString("c_password")));
            }
        } catch (SQLException e) {
            return null;
        }

        return customers;
    }

    @Override
    public Customer getCustomer(int id) {
        Customer customer = null;
        try {
            
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer WHERE id=" + id);
            if (rs.next()) {
                customer = new Customer(rs.getInt("id"), rs.getString("c_name"),rs.getString("email"),rs.getString("c_contact"), rs.getString("c_password"));
            }
        } catch (SQLException e) {
            return null;
        }

        return customer;
    }

    @Override
    public boolean addCustomer(Customer st) {
        try {
            
            String query = "INSERT INTO customer (c_name, email, c_contact, c_password) VALUES (?, ?, ?, ?)";
            
            Connection con = MyConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, st.getC_name());
            pst.setString(2, st.getEmail());
            pst.setString(3, st.getC_contact());
            pst.setString(4, st.getC_password());
            
            int rowAffected = pst.executeUpdate();
            
            pst.close();
            con.close();
            
            return rowAffected == 1;
            
            
        } catch (Exception e) {
            
            System.out.println("ADD CUSTOMER ERROR: " + e);
            return false;
            
        }
    }

    @Override
    public boolean updateCustomer(Customer st) {
        try {
            Connection conn = MyConnection.getConnection();

            // Create a prepared statement with an SQL query to update a student
            String query = "UPDATE customer SET c_name=?, email=?, c_contact=?, c_password=? WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, st.getC_name());
            pstmt.setString(2, st.getEmail());
            pstmt.setString(3, st.getC_contact());
            pstmt.setString(4, st.getC_password());
            pstmt.setInt(5, st.getId());

            // Execute the update query
            int rowsAffected = pstmt.executeUpdate();

            // Close resources
            pstmt.close();
            conn.close();

            // Check if the update was successful (1 row affected means success)
            return rowsAffected == 1;

        } catch (SQLException e) {
            e.printStackTrace();  // Handle or log the exception properly
            return false;
        }
    }

    @Override
    public boolean deleteCustomer(int id) {
        try {
            Connection conn = MyConnection.getConnection();

            // Create a prepared statement with an SQL query to delete a student
            String query = "DELETE FROM customer WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);

            // Execute the delete query
            int rowsAffected = pstmt.executeUpdate();

            // Close resources
            pstmt.close();
            conn.close();

            // Check if the delete was successful (1 row affected means success)
            return rowsAffected == 1;

        } catch (SQLException e) {
            e.printStackTrace();  // Handle or log the exception properly
            return false;
        }
    }

    @Override
    public List<Staff> getStaffs() {
        List<Staff> Staffs = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM staff");

            while (rs.next()) {
                Staffs.add(new Staff(rs.getInt("id"), rs.getString("s_name"),rs.getString("email"),rs.getString("s_contact"), rs.getString("s_password")));
            }
        } catch (SQLException e) {
            return null;
        }

        return Staffs;
    }

    @Override
    public Staff getStaff(int id) {
        Staff staff = null;
        try {
            
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM staff WHERE id=" + id);
            if (rs.next()) {
                staff = new Staff(rs.getInt("id"), rs.getString("s_name"),rs.getString("email"),rs.getString("s_contact"), rs.getString("s_password"));
            }
        } catch (SQLException e) {
            return null;
        }

        return staff;
    }

    @Override
    public boolean addStaff(Staff st) {
        try {
            
            String query = "INSERT INTO staff (s_name, email, s_contact, s_password) VALUES (?, ?, ?, ?)";
            
            Connection con = MyConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, st.getS_name());
            pst.setString(2, st.getEmail());
            pst.setString(3, st.getS_contact());
            pst.setString(4, st.getS_password());
            
            int rowAffected = pst.executeUpdate();
            
            pst.close();
            con.close();
            
            return rowAffected == 1;
            
            
        } catch (Exception e) {
            
            System.out.println("ADD STAFF ERROR: " + e);
            return false;
            
        }
    }

    @Override
    public boolean updateStaff(Staff st) {
        try {
            Connection conn = MyConnection.getConnection();

            // Create a prepared statement with an SQL query to update a student
            String query = "UPDATE staff SET s_name=?, email=?, s_contact=?, s_password=? WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, st.getS_name());
            pstmt.setString(2, st.getEmail());
            pstmt.setString(3, st.getS_contact());
            pstmt.setString(4, st.getS_password());
            pstmt.setInt(5, st.getId());

            // Execute the update query
            int rowsAffected = pstmt.executeUpdate();

            // Close resources
            pstmt.close();
            conn.close();

            // Check if the update was successful (1 row affected means success)
            return rowsAffected == 1;

        } catch (SQLException e) {
            e.printStackTrace();  // Handle or log the exception properly
            return false;
        }
    }

    @Override
    public boolean deleteStaff(int id) {
        try {
            Connection conn = MyConnection.getConnection();

            // Create a prepared statement with an SQL query to delete a student
            String query = "DELETE FROM staff WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);

            // Execute the delete query
            int rowsAffected = pstmt.executeUpdate();

            // Close resources
            pstmt.close();
            conn.close();

            // Check if the delete was successful (1 row affected means success)
            return rowsAffected == 1;

        } catch (SQLException e) {
            e.printStackTrace();  // Handle or log the exception properly
            return false;
        }
    }

    @Override
    public List<Reservation> getReservations() {
        List<Reservation> Reservations = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM reservation");

            while (rs.next()) {
                Reservations.add(new Reservation(rs.getInt("id"), rs.getString("c_name"),rs.getString("date"),rs.getString("time"),rs.getString("tables"),rs.getString("guests"),rs.getString("decoration"),rs.getString("meal"),rs.getString("contact")));
            }
        } catch (SQLException e) {
            return null;
        }

        return Reservations;
    }

    @Override
    public Reservation getReservation(int id) {
        Reservation reservation = null;
        try {
            
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM reservation WHERE id=" + id);
            if (rs.next()) {
                reservation = new Reservation(rs.getInt("id"), rs.getString("c_name"),rs.getString("date"),rs.getString("time"), rs.getString("tables"),rs.getString("guests"),rs.getString("decoration"),rs.getString("meal"),rs.getString("contact"));
            }
        } catch (SQLException e) {
            return null;
        }

        return reservation;
    }

    @Override
    public boolean addReservation(Reservation st) {
        try {
            
            String query = "INSERT INTO reservation (c_name, date, time, tables, guests, decoration, meal, contact) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
            Connection con = MyConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, st.getC_name());
            pst.setString(2, st.getDate());
            pst.setString(3, st.getTime());
            pst.setString(4, st.getTables());
            pst.setString(5, st.getGuests());
            pst.setString(6, st.getDecoration());
            pst.setString(7, st.getMeal());
            pst.setString(8, st.getContact());
            
            int rowAffected = pst.executeUpdate();
            
            pst.close();
            con.close();
            
            return rowAffected == 1;
            
            
        } catch (Exception e) {
            
            System.out.println("ADD RESERVATION ERROR: " + e);
            return false;
            
        }
    }

    @Override
    public List<Query> getQuerys() {
        List<Query> querys = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM query");

            while (rs.next()) {
                querys.add(new Query(rs.getInt("id"), rs.getString("name"), rs.getString("query")));
            }
        } catch (SQLException e) {
            return null;
        }

        return querys;    
    
    }

    @Override
    public Query getQuery(int id) {
        Query query = null;
        try {
            
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM query WHERE id=" + id);
            if (rs.next()) {
                query = new Query(rs.getInt("id"), rs.getString("name"), rs.getString("query"));
            }
        } catch (SQLException e) {
            return null;
        }

        return query;
    }

    @Override
    public boolean addQuery(Query st) {
        try {
            
            String query = "INSERT INTO query (name, query) VALUES (?, ?)";
            
            Connection con = MyConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, st.getName());
            pst.setString(2, st.getQuery());
            
            int rowAffected = pst.executeUpdate();
            
            pst.close();
            con.close();
            
            return rowAffected == 1;
            
            
        } catch (Exception e) {
            
            System.out.println("ADD QUERY ERROR: " + e);
            return false;
            
        }
    }
    
    
    
    

    @Override
    public boolean userLogin(String email, String c_password) {
        
        String sql = "SELECT * FROM customer WHERE BINARY email=? AND c_password=?";
        
        try{
            
            Connection con = MyConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,email);
            pst.setString(2,c_password);
            
            ResultSet resultSet = pst.executeQuery();
            
            if(resultSet.isBeforeFirst()){
                return true;
            }
            
        }catch(Exception e){
            System.out.println("userLogin Function error Database::: " +e);
        }
        
        return false;
    }

    @Override
    public boolean SuserLogin(String email, String s_password) {
        String sql = "SELECT * FROM staff WHERE BINARY email=? AND s_password=?";
        
        try{
            
            Connection con = MyConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,email);
            pst.setString(2,s_password);
            
            ResultSet resultSet = pst.executeQuery();
            
            if(resultSet.isBeforeFirst()){
                return true;
            }
            
        }catch(Exception e){
            System.out.println("SuserLogin Function error Database::: " +e);
        }
        
        return false;
    }
    

    
    
    
    
}
