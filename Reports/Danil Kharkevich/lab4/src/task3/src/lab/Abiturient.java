package lab;
import java.util.HashMap;

public class Abiturient extends Person{

    private Faculty faculty;
    private HashMap<Exam.Subjects, Mark> results = new HashMap<>();


    public Abiturient (String _name, String _surname) {
        super(_name, _surname);
    }
    public void Register (Faculty fac) {
        fac.AddAbiturientToFaculty(this);
        faculty = fac;
    }

    public void PassExam(Mark _mark, Exam.Subjects _sub) {
        results.put(_sub, _mark);
    }


    public int getResults(Exam.Subjects _sub) {
        return this.results.get(_sub).getMark();
    }

    public double GetAverage () {
        return  (this.getResults(Exam.Subjects.Math) + this.getResults(Exam.Subjects.Physics) +
                this.getResults(Exam.Subjects.Language))/3;
    }

    @Override
    public String toString() {
        return "\nName: " + super.getName() + '\n' +
                "Surname: " + super.getSurname() + '\n' +
                "Math: " + results.get(Exam.Subjects.Math).getMark() + '\n' +
                "Physics: " + results.get(Exam.Subjects.Physics).getMark() + '\n' +
                "Language: " + results.get(Exam.Subjects.Language).getMark() + '\n' +
                "Average: " + GetAverage();
    }

    public String toSmallString() {
        return super.getName() + ' ' + super.getSurname();
    }
}
