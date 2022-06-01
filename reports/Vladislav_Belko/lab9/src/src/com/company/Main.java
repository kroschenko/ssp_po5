package com.company;

import java.sql.*;

public class Main {


    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        String dbHost = "localhost";
        String dbPort = "3306";
        String dbUser = "root";
        String dbPass = "user";
        String dbName = "lab2";
        String connectionString;
        connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try(Connection dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass)){
            if(dbConnection.isValid(30)) {
                System.out.println("Success connection");
            }

            Statement stmt = dbConnection.createStatement();{
                //Заполнение таблицы groups
                /*stmt.executeUpdate("INSERT INTO lab2.groups (GroupName) VALUES ('PO-5')");
                stmt.executeUpdate("INSERT INTO lab2.groups (GroupName) VALUES ('II-18')");*/

                //Заполнение таблицы subjects
                /*stmt.executeUpdate("INSERT INTO lab2.subjects (subject_name) VALUES ('PIS')");
                stmt.executeUpdate("INSERT INTO lab2.subjects (subject_name) VALUES ('Math')");*/

                //Заполнение таблицы teachers
                /*stmt.executeUpdate("INSERT INTO lab2.teachers (FirstName, LastName, Patronymic) VALUES ('Kochurko', 'Pavel', 'Anatolievich')");
                stmt.executeUpdate("INSERT INTO lab2.teachers (FirstName, LastName, Patronymic) VALUES ('Gladkii', 'Ivan', 'Ivanovich')");*/
                //Заполнение таблицы calendar
                /*stmt.executeUpdate("INSERT INTO lab2.calendar (SemesterID, WeekDay, LessonID, LessonTime) VALUES ('6', '4', '1', '09:00 - 10:20')");
                stmt.executeUpdate("INSERT INTO lab2.calendar (SemesterID, WeekDay, LessonID, LessonTime) VALUES ('6', '2', '2', '14:00 - 15:20')");*/

                //Обновление данных в таблице
                /*stmt.executeUpdate("UPDATE lab2.groupss SET GroupName='AS-55' WHERE ID=2");*/

                //Удаление данных из таблицы
                /*stmt.executeUpdate("DELETE FROM lab2.groupss WHERE ID=2");*/

                //Выборка из таблицы
                String select = "SELECT * FROM lab2.teachers ORDER BY FirstName ASC";
                ResultSet rs = stmt.executeQuery(select);
                while(rs.next()) {
                    System.out.println(rs.getString("FirstName"));
                    System.out.println(rs.getString("LastName"));
                    System.out.println(rs.getString("Patronymic"));
                }

                // Выборка данных из разных таблиц благодаря внешнему ключу
                //select calendar.LessonTime,groupss.GroupName from timetable inner join  groupss on timetable.GroupID = groupss.ID inner join calendar on timetable.LessonID = calendar.LessonID
        }
}}}




