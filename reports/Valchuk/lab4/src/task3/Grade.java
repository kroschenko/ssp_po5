public record Grade(Course course, int grade) {

    public Course getCourse() {
        return course;
    }

    public int getGrade() {
        return grade;
    }
}
