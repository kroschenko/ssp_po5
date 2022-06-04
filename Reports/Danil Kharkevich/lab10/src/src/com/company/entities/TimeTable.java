package com.company.entities;

public class TimeTable {
    private int id;

    private int groupid;
    private Group group;

    private int subjectid;
    private Subject subject;

    private int lecturerid;
    private Lecturer lecturer;

    private int weekday;

    private int lessonid;
    private Calendar calendar;

    public TimeTable() {}

    public TimeTable(int groupId, int subjectId, int lecturerId, int weekDay, int lessonId) {
        this.groupid = groupId;
        this.subjectid = subjectId;
        this.lecturerid = lecturerId;
        this.weekday = weekDay;
        this.lessonid = lessonId;
    }

    public TimeTable(int id) {
        this.id = id;
    }

    public TimeTable(int id, int groupId, int subjectId, int lecturerId, int weekDay, int lessonId) {
        this.id = id;
        this.groupid = groupId;
        this.subjectid = subjectId;
        this.lecturerid = lecturerId;
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

    public int getLecturerid() {
        return lecturerid;
    }

    public void setLecturerid(int lecturerId) {
        this.lecturerid = lecturerId;
    }

    public String getLecturerName() {
        return lecturer.getFirstname() + " " + lecturer.getLastname();
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
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
