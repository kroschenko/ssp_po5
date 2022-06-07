package com.company.database.tables;

import com.company.database.interfaces.DBInterface;
import com.company.entities.Group;

import java.sql.*;
import java.util.ArrayList;

public class GroupTable implements DBInterface<Group> {

    private final Connection connection;

    public GroupTable(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Group Add(Group entity) throws SQLException {
        String query =
                "INSERT INTO schedule.groupsu(" +
                        " groupname)" +
                        " VALUES (?)";

        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, entity.getGroupname());

        statement.execute();

        ResultSet generatedKeys = statement.getGeneratedKeys();
        generatedKeys.next();
        entity.setId(generatedKeys.getInt(1));

        return entity;
    }

    @Override
    public void Update(Group entity) throws SQLException {
        String query =
                "UPDATE schedule.groupsu" +
                        " SET groupname = ?" +
                        " WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, entity.getGroupname());
        statement.setInt(2, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public void Delete(Group entity) throws SQLException {
        String query = "DELETE FROM schedule.groupsu" +
                " WHERE id=?";
       PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public Group GetByIdOrNull(int id) throws SQLException {
        String query =
                "SELECT * FROM schedule.groupsu" +
                        " WHERE Id = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        ResultSet reader = statement.executeQuery();
        if(reader.next())
        {
            Group result = new Group();
            result.setId(reader.getInt("id"));
            result.setGroupname(reader.getString("groupname"));
            return result;
        }

        return null;
    }

    @Override
    public ArrayList<Group> GetAll() throws SQLException {
        String query =
                "SELECT * FROM schedule.groupsu Order by id";

        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet reader = statement.executeQuery();
        ArrayList result = new ArrayList<Group>();
        while (reader.next())
        {
            Group group = new Group();
            group.setId(reader.getInt("id"));
            group.setGroupname(reader.getString("groupname"));

            result.add(group);
        }

        return result;
    }
}
