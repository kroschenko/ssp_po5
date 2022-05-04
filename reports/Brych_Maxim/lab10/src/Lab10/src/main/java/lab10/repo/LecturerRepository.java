package lab10.repo;

import lab10.entities.Lecturer;
import lab10.repo.Interfaces.IBaseRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LecturerRepository implements IBaseRepository<Lecturer> {

    private final Connection connection;

    public LecturerRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void Add(Lecturer entity) throws SQLException {
        var query =
                "INSERT INTO lecturers(" +
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

    }

    @Override
    public void Update(Lecturer entity) throws SQLException {
        var query =
                "UPDATE lecturers" +
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
    public void Delete(Lecturer entity) throws SQLException {
        var query = "DELETE FROM lecturers" +
                " WHERE id=?";
        var statement = connection.prepareStatement(query);
        statement.setInt(1, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public Lecturer GetByIdOrNull(int id) throws SQLException {
        var query =
                "SELECT * FROM lecturers" +
                        " WHERE Id = ?";

        var statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        var reader = statement.executeQuery();
        if(reader.next())
        {
            var result = new Lecturer();
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
        var query =
                "SELECT * FROM lecturers Order by id";

        var statement = connection.prepareStatement(query);

        var reader = statement.executeQuery();
        var result = new ArrayList<Lecturer>();
        while (reader.next())
        {
            var lecturer = new Lecturer();
            lecturer.setId(reader.getInt("id"));
            lecturer.setFirstname(reader.getString("firstname"));
            lecturer.setLastname(reader.getString("lastname"));
            lecturer.setPatronymic(reader.getString("patronymic"));

            result.add(lecturer);
        }

        return result;
    }
}
