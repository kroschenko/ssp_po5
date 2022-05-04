package lab10.core;

import lab10.entities.*;
import lab10.repo.*;
import lab10.repo.Interfaces.IBaseRepository;

import java.sql.SQLException;

public class RepositoryManager {
    public IBaseRepository<Subject> subjectRepository;
    public IBaseRepository<Group> groupRepository;
    public IBaseRepository<Lecturer> lecturerRepository;
    public IBaseRepository<Calendar> calendarRepository;
    public IBaseRepository<TimeTable> timeTableRepository;

    private static final Connection connection = new Connection();

    public RepositoryManager() throws SQLException {
        try {
            this.subjectRepository = new SubjectRepository(connection.GetConnection());
            this.groupRepository = new GroupRepository(connection.GetConnection());
            this.lecturerRepository = new LecturerRepository(connection.GetConnection());
            this.calendarRepository = new CalendarRepository(connection.GetConnection());
            this.timeTableRepository = new TimeTableRepository(connection.GetConnection());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
