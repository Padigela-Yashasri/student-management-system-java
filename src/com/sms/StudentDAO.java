package com.sms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class StudentDAO {

    public static void addStudent(String name, String email, String course) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO students(name, email, course) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Added Successfully ✅");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




public static void viewStudents() {
    try {
        Connection con = DBConnection.getConnection();

        String query = "SELECT * FROM students";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + " | " +
                rs.getString("name") + " | " +
                rs.getString("email") + " | " +
                rs.getString("course")
            );
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void updateStudent(int id, String name) {
    try {
        Connection con = DBConnection.getConnection();

        String query = "UPDATE students SET name=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, name);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Student Updated Successfully ✏️");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void deleteStudent(int id) {
    try {
        Connection con = DBConnection.getConnection();

        String query = "DELETE FROM students WHERE id=?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Student Deleted Successfully ❌");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}






















