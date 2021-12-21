import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person implements ICourseCreator {
    @Override
    public Course createCourse() {
        return new Course(this);
    }

    public void rate(Student student, Course course, Archive archive, int gradeValue) throws Exception {
        if (course.getStudents().stream().noneMatch(s -> s == student)) {
            throw new Exception();
        }

        Grade grade = new Grade(course, gradeValue);

        List<Grade> grades = archive.get(student);

        if (grades == null) {
            archive.put(student, new ArrayList<>(List.of(grade)));

            return;
        }

        grades.add(grade);
    }
}
