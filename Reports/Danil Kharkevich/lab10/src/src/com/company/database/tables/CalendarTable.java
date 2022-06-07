package com.company.database.tables;

import com.company.entities.Calendar;
import com.company.database.interfaces.DBInterface;

import java.sql.*;
import java.util.ArrayList;

public class CalendarTable implements DBInterface<Calendar> {

    private final Connection connection;

    public CalendarTable(Connection connection) { this.connection = connection; }

    @Override
    public Calendar Add(Calendar entity) throws SQLException {
        String query = "INSERT INTO schedule.calendar( " +
                " semesterid, weekday, lessonid, lessontime) " +
                " VALUES (?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        statement.setInt(1, entity.getSemesterid());
        statement.setInt(2, entity.getWeekday());
        statement.setInt(3, entity.getLessonid());
        statement.setString(4, entity.getLessontime());

        statement.execute();

        ResultSet generatedKeys = statement.getGeneratedKeys();
        generatedKeys.next();
        entity.setId(generatedKeys.getInt(1));

        return entity;
    }

    @Override
    public void Update(Calendar entity) throws SQLException {
        String query ="UPDATE schedule.calendar " +
                " SET semesterid=?, weekday=?, lessonid=?, lessontime=?" +
                " WHERE id=?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, entity.getSemesterid());
        statement.setInt(2, entity.getWeekday());
        statement.setInt(3, entity.getLessonid());
        statement.setString(4, entity.getLessontime());
        statement.setInt(5, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public void Delete(Calendar entity) throws SQLException {
        String query = "DELETE FROM schedule.calendar" +
                " WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public Calendar GetByIdOrNull(int id) throws SQLException {
        String query =
                "SELECT * FROM schedule.calendar" +
                        " WHERE Id = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        ResultSet reader = statement.executeQuery();
        if(reader.next())
        {
            Calendar result = new Calendar();
            result.setId(reader.getInt("id"));
            result.setLessonid(reader.getInt("lessonid"));
            result.setSemesterid(reader.getInt("semesterid"));
            result.setWeekday(reader.getInt("weekday"));
            result.setLessontime(reader.getString("lessontime"));
            return result;
        }

        return null;
    }

    @Override
    public ArrayList<Calendar> GetAll() throws SQLException {
        String query =
                "SELECT * FROM schedule.calendar Order by id";

        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet reader = statement.executeQuery();
        ArrayList result = new ArrayList<Calendar>();
        while (reader.next())
        {
            Calendar calendar = new Calendar();
            calendar.setId(reader.getInt("id"));
            calendar.setLessonid(reader.getInt("lessonid"));
            calendar.setSemesterid(reader.getInt("semesterid"));
            calendar.setWeekday(reader.getInt("weekday"));
            calendar.setLessontime(reader.getString("lessontime"));

            result.add(calendar);
        }

        return result;
    }
}
