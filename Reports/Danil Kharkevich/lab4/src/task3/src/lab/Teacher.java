package lab;

public class Teacher extends Person{
    private Exam.Subjects subject;
    public Teacher (String _name, String _surname, Exam _ex) {
        super(_name, _surname);
        subject = _ex.getSubject();
    }
    public Mark Rate(int _mark) {
        Mark mark = new Mark();
        mark.setMark(_mark);
        return  mark;
    }

    public Exam.Subjects getSubject() {
        return subject;
    }
}
