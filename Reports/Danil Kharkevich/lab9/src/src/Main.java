import javax.swing.*;
import java.sql.*;

public class Main {
    public static final String USER_NAME = "root";
    public static final String DATABASE_NAME = "schedule";
    public static final String PASSWORD = "root";
    public static final String URL = "jdbc:mysql://localhost:3306/mysql";
    public static Connection connection;
    public static Statement statement;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

 /*
        statement.execute("INSERT INTO schedule.groupsu (GroupName) VALUES ('PO-5');");
        statement.execute("INSERT INTO schedule.groupsu (GroupName) VALUES ('II-18');");

        statement.execute("INSERT INTO schedule.subjects (SubjectName) VALUES ('NPO');");
        statement.execute("INSERT INTO schedule.subjects (SubjectName) VALUES ('SPP');");
        statement.execute("INSERT INTO schedule.subjects (SubjectName) VALUES ('MP');");

        statement.execute("INSERT INTO schedule.lecturers (FirstName, LastName, Patronymic) VALUES ('Ivan', 'Ivanov', 'Ivanovich');");
        statement.execute("INSERT INTO schedule.lecturers (FirstName, LastName, Patronymic) VALUES ('Vladimir', 'Kapusitn', 'Olegovihc');");
        statement.execute("INSERT INTO schedule.lecturers (FirstName, LastName, Patronymic) VALUES ('Vasiliy', 'Egorov', 'Petrovich');");

        statement.execute("INSERT INTO schedule.calendar (LessonId, LessonTime, SemesterID, WeekDay) VALUES (1, '09:00 - 10:20', 6, 4)");
        statement.execute("INSERT INTO schedule.calendar (LessonId, LessonTime, SemesterID, WeekDay) VALUES (2, '10:40 - 12:00', 6, 4)");
        statement.execute("INSERT INTO schedule.calendar (LessonId, LessonTime, SemesterID, WeekDay) VALUES (1, '12:10 - 13:30', 6, 1)");

        statement.execute("INSERT INTO schedule.timetable (GroupID, SubjectID, LecturerID, WeekDay, LessonID) VALUES (4, 1, 1, 4, 1)");
        */


        String selectThursday = "SELECT t.ID, g.GroupName, sub.SubjectName, l.FirstName, l.LastName, c.LessonTime, c.LessonID " +
                "FROM schedule.timetable t " +
                "    INNER JOIN schedule.groupsu g ON t.GroupID = g.ID " +
                "    INNER JOIN schedule.subjects sub ON t.SubjectID = sub.ID " +
                "    INNER JOIN schedule.lecturers l ON t.LecturerID = l.ID " +
                "    INNER JOIN schedule.calendar c ON t.LessonID = c.ID " +
                "WHERE t.WeekDay = 4 " +
                "    AND g.GroupName = 'PO-5' " +
                "ORDER BY t.LessonID";

        ResultSet rs = statement.executeQuery(selectThursday);

        while(rs.next()) {
            System.out.println(rs.getString("GroupName"));
            System.out.println(rs.getString("SubjectName"));
            System.out.println(rs.getString("FirstName"));
            System.out.println(rs.getString("LastName"));
            System.out.println(rs.getString("LessonTime"));
            System.out.println(rs.getString("LessonID"));
        }
         System.out.println('\n');

        statement.execute("INSERT INTO schedule.groupsu (GroupName) VALUES ('TEST');");
        ResultSet testGroupFirst = statement.executeQuery("SELECT * FROM schedule.groupsu");
        while(testGroupFirst.next()) {
            System.out.println(testGroupFirst.getString("GroupName"));
        }
        System.out.println('\n');

        statement.execute("UPDATE schedule.groupsu SET GroupName='YES' WHERE GroupName='TEST'");
        ResultSet testGroupSecond = statement.executeQuery("SELECT * FROM schedule.groupsu");
        while(testGroupSecond.next()) {
            System.out.println(testGroupSecond.getString("GroupName"));
        }
        System.out.println('\n');

        statement.execute("DELETE FROM schedule.groupsu WHERE GroupName='YES'");
        ResultSet testGroupThird = statement.executeQuery("SELECT * FROM schedule.groupsu");
        while(testGroupThird.next()) {
            System.out.println(testGroupThird.getString("GroupName"));
        }
    }
}


