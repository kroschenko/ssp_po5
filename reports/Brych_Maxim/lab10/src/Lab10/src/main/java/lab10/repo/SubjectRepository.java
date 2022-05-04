package lab10.repo;

import lab10.entities.Subject;
import lab10.repo.Interfaces.IBaseRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SubjectRepository implements IBaseRepository<Subject> {

    private final Connection connection;

    public SubjectRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void Add(Subject entity) throws SQLException {
        var query =
                "INSERT INTO subjects(" +
                        " subjectname)" +
                        " VALUES (?)";

        var statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, entity.getSubjectName());


        statement.execute();

        var generatedKeys = statement.getGeneratedKeys();
        generatedKeys.next();
        entity.setId(generatedKeys.getInt(1));

    }

    @Override
    public void Update(Subject entity) throws SQLException {
        var query =
                "UPDATE subjects" +
                        " SET subjectname = ?" +
                        " WHERE id = ?";

        var statement = connection.prepareStatement(query);
        statement.setString(1, entity.getSubjectName());
        statement.setInt(2, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public void Delete(Subject entity) throws SQLException {
        var query = "DELETE FROM subjects" +
                " WHERE id=?";
        var statement = connection.prepareStatement(query);
        statement.setInt(1, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public Subject GetByIdOrNull(int id) throws SQLException {
        var query =
                "SELECT * FROM subjects" +
                        " WHERE Id = ? " +
                        "Order by id";

        var statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        var reader = statement.executeQuery();
        if(reader.next())
        {
            var result = new Subject();
            result.setId(reader.getInt("id"));
            result.setSubjectName(reader.getString("subjectname"));
            return result;
        }

        return null;
    }

    @Override
    public ArrayList<Subject> GetAll() throws SQLException {
        var query =
                "SELECT * FROM subjects Order by id";

        var statement = connection.prepareStatement(query);

        var reader = statement.executeQuery();
        var result = new ArrayList<Subject>();
        while (reader.next())
        {
            var subject = new Subject();
            subject.setId(reader.getInt("id"));
            subject.setSubjectName(reader.getString("subjectname"));

            result.add(subject);
        }

        return result;
    }
}
