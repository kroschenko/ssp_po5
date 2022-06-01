package FacultyCompany.Entities;

public class TimeTable {
    private int id;

    private int groupid;
    private Group group;

    private int subjectid;
    private Subject subject;

    private int teacherid;
    private Teacher teacher;

    private int weekday;

    private int lessonid;
    private Calendar calendar;

    public TimeTable() {}

    public TimeTable(int groupId, int subjectId, int teacherId, int weekDay, int lessonId) {
        this.groupid = groupId;
        this.subjectid = subjectId;
        this.teacherid = teacherId;
        this.weekday = weekDay;
        this.lessonid = lessonId;
    }

    public TimeTable(int id) {
        this.id = id;
    }

    public TimeTable(int id, int groupId, int subjectId, int teacherId, int weekDay, int lessonId) {
        this.id = id;
        this.groupid = groupId;
        this.subjectid = subjectId;
        this.teacherid = teacherId;
        this.weekday = weekDay;
        this.lessonid = lessonId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupId) {
        this.groupid = groupId;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectId) {
        this.subjectid = subjectId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherId) {
        this.teacherid = teacherId;
    }

    public String getTeacherName() {
        return teacher.getFirstname() + " " + teacher.getLastname();
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getWeekday() {
        return weekday;
    }

    public void setWeekday(int weekDay) {
        this.weekday = weekDay;
    }

    public int getLessonid() {
        return lessonid;
    }

    public void setLessonid(int lessonId) {
        this.lessonid = lessonId;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

}
