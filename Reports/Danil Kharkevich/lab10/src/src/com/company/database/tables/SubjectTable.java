package com.company.database.tables;

import com.company.database.interfaces.DBInterface;
import com.company.entities.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SubjectTable implements DBInterface<Subject> {
    private final Connection connection;

    public SubjectTable(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Subject Add(Subject entity) throws SQLException {
        String query =
                "INSERT INTO schedule.subjects(" +
                        " subjectname)" +
                        " VALUES (?)";

        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, entity.getSubjectName());

        statement.execute();

        ResultSet generatedKeys = statement.getGeneratedKeys();
        generatedKeys.next();
        entity.setId(generatedKeys.getInt(1));

        return entity;
    }

    @Override
    public void Update(Subject entity) throws SQLException {
        String query =
                "UPDATE schedule.subjects" +
                        " SET subjectname = ?" +
                        " WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, entity.getSubjectName());
        statement.setInt(2, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public void Delete(Subject entity) throws SQLException {
        String query = "DELETE FROM schedule.subjects" +
                " WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public Subject GetByIdOrNull(int id) throws SQLException {
        String query =
                "SELECT * FROM schedule.subjects" +
                        " WHERE Id = ? " +
                        "Order by id";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        ResultSet reader = statement.executeQuery();
        if(reader.next())
        {
            Subject result = new Subject();
            result.setId(reader.getInt("id"));
            result.setSubjectName(reader.getString("subjectname"));
            return result;
        }

        return null;
    }

    @Override
    public ArrayList<Subject> GetAll() throws SQLException {
        String query =
                "SELECT * FROM schedule.subjects Order by id";

        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet reader = statement.executeQuery();
        ArrayList result = new ArrayList<Subject>();
        while (reader.next())
        {
            Subject subject = new Subject();
            subject.setId(reader.getInt("id"));
            subject.setSubjectName(reader.getString("subjectname"));

            result.add(subject);
        }

        return result;
    }
}
