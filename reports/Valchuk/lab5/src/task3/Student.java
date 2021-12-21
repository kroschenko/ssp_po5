public class Student extends Person {
    public void enroll(Course course) {
        course.getStudents().add(this);
    }
}
