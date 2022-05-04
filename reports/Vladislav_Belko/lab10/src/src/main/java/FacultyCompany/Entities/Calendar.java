package FacultyCompany.Entities;

public class Calendar {
    private int id;
    private int semesterid;
    private int weekday;
    private int lessonid;
    private String lessontime;

    public Calendar() {}

    public Calendar(int semesterId, int weekDay, int lessonId, String lessonTime) {
        this.semesterid = semesterId;
        this.weekday = weekDay;
        this.lessonid = lessonId;
        this.lessontime = lessonTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSemesterid() {
        return semesterid;
    }

    public void setSemesterid(int semesterId) {
        this.semesterid = semesterId;
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

    public String getLessontime() {
        return lessontime;
    }

    public void setLessontime(String lessonTime) {
        this.lessontime = lessonTime;
    }

    @Override
    public String toString()
    {
        return getLessontime();
    }
}
