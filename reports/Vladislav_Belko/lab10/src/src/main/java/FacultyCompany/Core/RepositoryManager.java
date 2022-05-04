package FacultyCompany.Core;

import FacultyCompany.Core.Connection;
import FacultyCompany.Entities.*;
import FacultyCompany.Interfaces.IBaseRepository;
import FacultyCompany.Repositories.*;

import java.sql.SQLException;

public class RepositoryManager {
    public IBaseRepository<Subject> subjectRepository;
    public IBaseRepository<Group> groupRepository;
    public IBaseRepository<Teacher> teacherRepository;
    public IBaseRepository<Calendar> calendarRepository;
    public IBaseRepository<TimeTable> timeTableRepository;

    private static Connection connection = new Connection();

    public RepositoryManager() throws SQLException {
        this.subjectRepository = new SubjectRepository(connection.GetConnection());
        this.groupRepository = new GroupRepository(connection.GetConnection());
        this.teacherRepository = new TeacherRepository(connection.GetConnection());
        this.calendarRepository = new CalendarRepository(connection.GetConnection());
        this.timeTableRepository = new TimeTableRepository(connection.GetConnection());
    }
}
