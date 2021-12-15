abstract class Person {
    String name;
    String surname;
    int age;
}
class Teacher extends Person {
    private static Teacher teacher;
    public static Teacher getInstance(String name, String surname, int age) { //singleton
        if (teacher == null) {
            teacher = new Teacher(name, surname, age);
        }
        return teacher;
    }
    Teacher(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    void print() {
        System.out.println("Teacher data:\n" +
                "Name: " + name + "\nSurname: " + surname + "\nAge: " + age);
    }
    void checkLabWork() {//проверить лаб раб
        System.out.println("Mr. " + this.surname + ": Ready. I just checked your laboratory work. It's OK.");
    }
    void makeConsultation() {//провести консультацию
        System.out.println("Mr. " + this.surname + ": Ok I'll make a consultation");
    }
    void takeExam() {//принять экзамен
        System.out.println("Mr. " + this.surname + ": OK. Ready.");
    }
    void setMark(Student student) { //выставить отметку
        int mark = (int) (Math.random() * 10);
        student.setMark(mark);
        student.print();
    }
    void giveLecture() { //провести лекцию
        System.out.println("Mr. " + this.surname + ": Ok I'll give you a lecture");
    }
}
class Student extends Person {
    private int mark;
    Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    void setMark(int mark) {
        this.mark = mark;
    }
    void teacherCheckLabWork() {//проверить лаб раб
        Teacher teacher = Teacher.getInstance("","",0);
        System.out.println("Student " + name + ": Mr. " + teacher.surname + " please check my laboratory work.");
        teacher.checkLabWork();
    }
    void teacherMakeConsultation() { //провести консультацию
        Teacher teacher = Teacher.getInstance("","",0);
        System.out.println("Student " + name + ": Mr. " + teacher.surname + " please make a consultation.");
        teacher.makeConsultation();
    }
    void teacherTakeExam() { //принять экзамен
        Teacher teacher = Teacher.getInstance("","",0);
        System.out.println("Student " + name + ": Mr. " + teacher.surname + " please take an exam.");
        teacher.takeExam();
    }
    void teacherSetMark() { //выставить отметку
        Teacher teacher = Teacher.getInstance("","",0);
        System.out.println("Student " + name + ": Mr. " + teacher.surname + " please set my mark.");
        teacher.setMark(this);
    }
    void teacherGiveLecture() { //провести лекцию
        Teacher teacher = Teacher.getInstance("","",0);
        System.out.println("Student " + name + ": Mr. " + teacher.surname + " please give a lecture.");
        teacher.giveLecture();
    }
    void print() {
        Teacher teacher = Teacher.getInstance("","",0);
        System.out.println(teacher.surname + " " + teacher.name +
                " rated " + name + " " + surname + ". Mark - " + mark);
    }
}
public class Lab6Task1 {
    public static void main(String[] args) {
        Student student1 = new Student("Nicolay","Qwerty",21);
        Student student2 = new Student("Grigoriy","Tree",22);
        Student student3 = new Student("Evgeniy","Lucky",19);
        Student[] students = {student1,student2,student3};
        Teacher teacher = Teacher.getInstance("Ivan","Ivanov",39);
        teacher.print();
        student1.teacherGiveLecture();
        student2.teacherCheckLabWork();
        student3.teacherMakeConsultation();
        student3.teacherTakeExam();
        student3.teacherSetMark();
    }
}