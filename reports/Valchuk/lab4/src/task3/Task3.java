public class Task3 {

    public static void main(String[] args) throws Exception {
	    ElectiveSystem electives = new ElectiveSystem();

        electives.getTeachers().add(new Teacher());
        electives.getStudents().add(new Student());
        electives.getCourses().add(electives.getTeachers().get(0).createCourse());
        electives.getStudents().get(0).enroll(electives.getCourses().get(0));
        electives.getTeachers().get(0).rate(electives.getStudents().get(0), electives.getCourses().get(0), electives.getArchive(), 9);

        System.out.println(electives.getArchive());
    }
}
