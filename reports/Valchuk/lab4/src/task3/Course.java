import java.util.ArrayList;
import java.util.List;

public class Course {
    private final Teacher teacher;
    private final List<Student> students = new ArrayList<>();

    public Course(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }
}
