package com.company.database.tables;

import com.company.database.interfaces.DBInterface;
import com.company.entities.Lecturer;

import java.sql.*;
import java.util.ArrayList;

public class LecturerTable implements DBInterface<Lecturer> {

    private final Connection connection;

    public LecturerTable(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Lecturer Add(Lecturer entity) throws SQLException {
        String query =
                "INSERT INTO schedule.lecturers(" +
                        "firstname, lastname, patronymic)" +
                        " VALUES (?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, entity.getFirstname());
        statement.setString(2, entity.getLastname());
        statement.setString(3, entity.getPatronymic());

        statement.execute();

        ResultSet generatedKeys = statement.getGeneratedKeys();
        generatedKeys.next();
        entity.setId(generatedKeys.getInt(1));

        return entity;
    }

    @Override
    public void Update(Lecturer entity) throws SQLException {
        String query =
                "UPDATE schedule.lecturers" +
                        " SET firstname=?, lastname=?, patronymic=?" +
                        " WHERE id=?";


        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, entity.getFirstname());
        statement.setString(2, entity.getLastname());
        statement.setString(3, entity.getPatronymic());
        statement.setInt(4, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public void Delete(Lecturer entity) throws SQLException {
        String query = "DELETE FROM schedule.lecturers" +
                " WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public Lecturer GetByIdOrNull(int id) throws SQLException {
        String query =
                "SELECT * FROM schedule.lecturers" +
                        " WHERE Id = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        ResultSet reader = statement.executeQuery();
        if(reader.next())
        {
            Lecturer result = new Lecturer();
            result.setId(reader.getInt("id"));
            result.setFirstname(reader.getString("firstname"));
            result.setLastname(reader.getString("lastname"));
            result.setPatronymic(reader.getString("patronymic"));
            return result;
        }

        return null;
    }

    @Override
    public ArrayList<Lecturer> GetAll() throws SQLException {
        String query =
                "SELECT * FROM schedule.lecturers Order by id";

        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet reader = statement.executeQuery();
        ArrayList result = new ArrayList<Lecturer>();
        while (reader.next())
        {
            Lecturer lecturer = new Lecturer();
            lecturer.setId(reader.getInt("id"));
            lecturer.setFirstname(reader.getString("firstname"));
            lecturer.setLastname(reader.getString("lastname"));
            lecturer.setPatronymic(reader.getString("patronymic"));

            result.add(lecturer);
        }

        return result;
    }

}
