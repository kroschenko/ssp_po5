package com.spp.lab3;

import java.sql.*;

public class Main {

    private static Connection connection;

    public static void main(String[] args) throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/spp", "postgres", "admin");
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM groups ORDER BY name");
        while (resultSet.next()) {
            System.out.print(resultSet.getInt("id") + " " + resultSet.getString("name") + " ");
            int headmanId = resultSet.getInt("headman_id");
            System.out.println((resultSet.wasNull() ? null : headmanId) + "\n");
        }

        System.out.println("--------");

        resultSet = statement.executeQuery("INSERT INTO students (first_name, last_name, group_id) VALUES ('Иван', 'Петров', 1) RETURNING id");
        resultSet.next();
        int insertedStudentId = resultSet.getInt("id");
        printStudents();
        System.out.println("--------");

        statement.execute("UPDATE students SET group_id = 3 WHERE id = " + insertedStudentId);
        printStudents();
        System.out.println("--------");

        statement.execute("DELETE FROM students WHERE id = " + insertedStudentId);
        printStudents();
        System.out.println("--------");
    }

    private static void printStudents() throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM students");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + " " + resultSet.getString("first_name") +
                    " " + resultSet.getInt("group_id") + "\n");
        }
    }
}
