package FacultyCompany.Repositories;

import FacultyCompany.Entities.TimeTable;
import FacultyCompany.Interfaces.IBaseRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TimeTableRepository implements IBaseRepository<TimeTable> {

    private final Connection connection;

    public TimeTableRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public TimeTable Add(TimeTable entity) throws SQLException {
        var query =
                "INSERT INTO lab2.timetable(" +
                        "groupid, subjectid, teacherid, weekday, lessonid)" +
                        " VALUES (?, ?, ?, ?, ?);";

        var statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, entity.getGroupid());
        statement.setInt(2, entity.getSubjectid());
        statement.setInt(3, entity.getTeacherid());
        statement.setInt(4, entity.getWeekday());
        statement.setInt(5, entity.getLessonid());

        statement.execute();

        var generatedKeys = statement.getGeneratedKeys();
        generatedKeys.next();
        entity.setId(generatedKeys.getInt(1));

        return entity;
    }

    @Override
    public void Update(TimeTable entity) throws SQLException {

        var query = "UPDATE lab2.timetable " +
                " SET groupid=?, subjectid=?, teacherid=?, weekday=?, lessonid=? " +
                " WHERE id=?";

        var statement = connection.prepareStatement(query);
        statement.setInt(1, entity.getGroupid());
        statement.setInt(2, entity.getSubjectid());
        statement.setInt(3, entity.getTeacherid());
        statement.setInt(4, entity.getWeekday());
        statement.setInt(5, entity.getLessonid());
        statement.setInt(6, entity.getId());

        statement.executeUpdate();
        return;
    }

    @Override
    public void Delete(TimeTable entity) throws SQLException {
        var query = "DELETE FROM lab2.timetable" +
                " WHERE id=?";

        var statement = connection.prepareStatement(query);
        statement.setInt(1, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public TimeTable GetByIdOrNull(int id) throws SQLException {
        var query =
                "SELECT * FROM lab2.timetable" +
                        " WHERE Id = ?";

        var statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        var reader = statement.executeQuery();
        if(reader.next())
        {
            var result = new TimeTable();
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
        var query =
                "SELECT * FROM lab2.timetable Order by id";

        var statement = connection.prepareStatement(query);

        var reader = statement.executeQuery();
        var result = new ArrayList<TimeTable>();
        while (reader.next())
        {
            var timeTable = new TimeTable();
            timeTable.setId(reader.getInt("id"));
            timeTable.setGroupid(reader.getInt("groupid"));
            timeTable.setSubjectid(reader.getInt("subjectid"));
            timeTable.setTeacherid(reader.getInt("teacherid"));
            timeTable.setWeekday(reader.getInt("weekday"));
            timeTable.setLessonid(reader.getInt("lessonid"));

            result.add(timeTable);
        }

        return result;
    }
}
