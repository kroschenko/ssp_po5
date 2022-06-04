package com.company.database;

import java.sql.SQLException;
import com.company.database.tables.*;
import com.company.database.interfaces.DBInterface;
import com.company.entities.*;

public class DBManager {
    public static DBInterface<Subject> subjectTable;
    public static DBInterface<Group> groupTable;
    public static DBInterface<Lecturer> lecturerTable;
    public static DBInterface<Calendar> calendarTable;
    public static DBInterface<TimeTable> scheduleTable;

    private static final Connection connection = new Connection();

    public DBManager() throws SQLException {
        this.subjectTable = new SubjectTable(connection.GetConnection());
        this.groupTable = new GroupTable(connection.GetConnection());
        this.lecturerTable = new LecturerTable(connection.GetConnection());
        this.calendarTable = new CalendarTable(connection.GetConnection());
        this.scheduleTable = new ScheduleTable(connection.GetConnection());
    }    
}
