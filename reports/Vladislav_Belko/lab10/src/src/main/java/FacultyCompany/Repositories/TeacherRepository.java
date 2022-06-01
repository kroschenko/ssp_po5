package FacultyCompany.Repositories;

import FacultyCompany.Entities.Teacher;
import FacultyCompany.Interfaces.IBaseRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TeacherRepository implements IBaseRepository<Teacher> {

    private final Connection connection;

    public TeacherRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Teacher Add(Teacher entity) throws SQLException {
        var query =
                "INSERT INTO lab2.teachers(" +
                        "firstname, lastname, patronymic)" +
                        " VALUES (?, ?, ?)";

        var statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, entity.getFirstname());
        statement.setString(2, entity.getLastname());
        statement.setString(3, entity.getPatronymic());

        statement.execute();

        var generatedKeys = statement.getGeneratedKeys();
        generatedKeys.next();
        entity.setId(generatedKeys.getInt(1));

        return entity;
    }

    @Override
    public void Update(Teacher entity) throws SQLException {
        var query =
                "UPDATE lab2.teachers" +
                        " SET firstname=?, lastname=?, patronymic=?" +
                        " WHERE id=?";


        var statement = connection.prepareStatement(query);
        statement.setString(1, entity.getFirstname());
        statement.setString(2, entity.getLastname());
        statement.setString(3, entity.getPatronymic());
        statement.setInt(4, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public void Delete(Teacher entity) throws SQLException {
        var query = "DELETE FROM lab2.teachers" +
                " WHERE id=?";
        var statement = connection.prepareStatement(query);
        statement.setInt(1, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public Teacher GetByIdOrNull(int id) throws SQLException {
        var query =
                "SELECT * FROM lab2.teachers" +
                        " WHERE Id = ?";

        var statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        var reader = statement.executeQuery();
        if(reader.next())
        {
            var result = new Teacher();
            result.setId(reader.getInt("id"));
            result.setFirstname(reader.getString("firstname"));
            result.setLastname(reader.getString("lastname"));
            result.setPatronymic(reader.getString("patronymic"));
            return result;
        }

        return null;
    }

    @Override
    public ArrayList<Teacher> GetAll() throws SQLException {
        var query =
                "SELECT * FROM lab2.teachers Order by id";

        var statement = connection.prepareStatement(query);

        var reader = statement.executeQuery();
        var result = new ArrayList<Teacher>();
        while (reader.next())
        {
            var teacher = new Teacher();
            teacher.setId(reader.getInt("id"));
            teacher.setFirstname(reader.getString("firstname"));
            teacher.setLastname(reader.getString("lastname"));
            teacher.setPatronymic(reader.getString("patronymic"));

            result.add(teacher);
        }

        return result;
    }
}
