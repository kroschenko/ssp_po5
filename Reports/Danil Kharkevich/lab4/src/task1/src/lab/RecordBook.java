package lab;
import java.util.ArrayList;

public class RecordBook {
    private class Exam {
        int exam_id;
        String subject;
        String teacher;
        int mark;

        @Override
        public String toString() {
            return "Exam " + exam_id +
                    "\nSubject: " + subject +
                    "\nTeacher: " + teacher +
                    "\nMark: " + mark + "\n";
        }
    }

    ArrayList<Exam> exams = new ArrayList<>();

    public void AddExam (int _id, String _sub, String _teacher, int _mark) {
        Exam ex = new Exam();
        ex.exam_id = _id;
        ex.subject = _sub;
        ex.teacher = _teacher;
        ex.mark = _mark;
        exams.add(ex);
    }

    public void show () {
        for (Exam ex : exams) {
            System.out.println(ex.toString());

        }
    }
}
