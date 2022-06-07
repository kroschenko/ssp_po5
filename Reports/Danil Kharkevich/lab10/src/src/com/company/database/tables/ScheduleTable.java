package com.company.database.tables;

import com.company.database.interfaces.DBInterface;
import com.company.entities.TimeTable;

import java.sql.*;
import java.util.ArrayList;

public class ScheduleTable implements DBInterface<TimeTable> {
    private final Connection connection;

    public ScheduleTable(Connection connection) {
        this.connection = connection;
    }

    @Override
    public TimeTable Add(TimeTable entity) throws SQLException {
        String query =
                "INSERT INTO schedule.timetable(" +
                        "groupid, subjectid, lecturerid, weekday, lessonid)" +
                        " VALUES (?, ?, ?, ?, ?);";

        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, entity.getGroupid());
        statement.setInt(2, entity.getSubjectid());
        statement.setInt(3, entity.getLecturerid());
        statement.setInt(4, entity.getWeekday());
        statement.setInt(5, entity.getLessonid());

        statement.execute();

        ResultSet generatedKeys = statement.getGeneratedKeys();
        generatedKeys.next();
        entity.setId(generatedKeys.getInt(1));

        return entity;
    }

    @Override
    public void Update(TimeTable entity) throws SQLException {

        String query = "UPDATE schedule.timetable " +
                " SET groupid=?, subjectid=?, lecturerid=?, weekday=?, lessonid=? " +
                " WHERE id=?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, entity.getGroupid());
        statement.setInt(2, entity.getSubjectid());
        statement.setInt(3, entity.getLecturerid());
        statement.setInt(4, entity.getWeekday());
        statement.setInt(5, entity.getLessonid());
        statement.setInt(6, entity.getId());

        statement.executeUpdate();
        return;
    }

    @Override
    public void Delete(TimeTable entity) throws SQLException {
        String query = "DELETE FROM schedule.timetable" +
                " WHERE id=?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public TimeTable GetByIdOrNull(int id) throws SQLException {
        String query =
                "SELECT * FROM schedule.timetable" +
                        " WHERE Id = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        ResultSet reader = statement.executeQuery();
        if(reader.next())
        {
            TimeTable result = new TimeTable();
            result.setId(reader.getInt("id"));
            result.setLessonid(reader.getInt("lessonid"));
            result.setWeekday(reader.getInt("weekday"));
            result.setGroupid(reader.getInt("groupid"));
            result.setSubjectid(reader.getInt("subjectid"));
            return result;
        }

        return null;
    }

    @Override
    public ArrayList<TimeTable> GetAll() throws SQLException {
        String query =
                "SELECT * FROM schedule.timetable Order by id";

        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet reader = statement.executeQuery();
        ArrayList result = new ArrayList<TimeTable>();
        while (reader.next())
        {
            TimeTable    timeTable = new TimeTable();
            timeTable.setId(reader.getInt("id"));
            timeTable.setGroupid(reader.getInt("groupid"));
            timeTable.setSubjectid(reader.getInt("subjectid"));
            timeTable.setLecturerid(reader.getInt("lecturerid"));
            timeTable.setWeekday(reader.getInt("weekday"));
            timeTable.setLessonid(reader.getInt("lessonid"));

            result.add(timeTable);
        }

        return result;
    }
}
