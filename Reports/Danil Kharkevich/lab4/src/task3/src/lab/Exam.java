package lab;

public class Exam {

    public enum Subjects {
        Math, Physics, Language
    }
    private Subjects subject;
    public Exam (Subjects _sub) {
        subject = _sub;
    }

    public Subjects getSubject() {
        return subject;
    }
}
