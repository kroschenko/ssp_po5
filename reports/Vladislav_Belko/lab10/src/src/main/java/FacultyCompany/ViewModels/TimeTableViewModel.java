package FacultyCompany.ViewModels;

import FacultyCompany.Entities.TimeTable;

public class TimeTableViewModel {
    private int id;

    private String groupname;

    private String subjectName;

    private String teacherFullName;

    private int semesterid;
    private int weekday;
    private String lessontime;

    private int groupid;
    private int subjectid;
    private int teacherid;
    private int lessonid;

    public TimeTableViewModel(TimeTable table) {
        this.id = table.getId();
        this.groupname = table.getGroup().getGroupname();
        this.subjectName = table.getSubject().getSubjectName();
        this.semesterid = table.getCalendar().getSemesterid();
        this.weekday = table.getWeekday();
        this.lessontime = table.getCalendar().getLessontime();
        this.groupid = table.getGroupid();
        this.subjectid = table.getSubjectid();
        this.lessonid = table.getLessonid();
        this.teacherFullName = table.getTeacherName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSemesterid() {
        return semesterid;
    }

    public void setSemesterid(int semesterid) {
        this.semesterid = semesterid;
    }

    public int getWeekday() {
        return weekday;
    }

    public void setWeekday(int weekday) {
        this.weekday = weekday;
    }

    public int getLessonid() {
        return lessonid;
    }

    public void setLessonid(int lessonid) {
        this.lessonid = lessonid;
    }

    public String getLessontime() {
        return lessontime;
    }

    public void setLessontime(String lessontime) {
        this.lessontime = lessontime;
    }

    public String getTeacherFullName() {
        return teacherFullName;
    }
}
