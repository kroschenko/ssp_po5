import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Abiturient implements Printable {
    private String Name, Surname;
    public Integer assessment;
    private Faculty facultet; // Ассоциация
    private ArrayList<Exams> exams; // Ассоциация
    private Exams exam = new Exams("Show");;

    Abiturient(String name, String surname, String Facultet, ArrayList<Exams> exams) {
        this.Name = name;
        this.Surname = surname;
        this.facultet = new Faculty(name, surname, Facultet); // Композиция
        this.exams = exams; // Агрегация
    }

    Abiturient(String name, String surname) {
        this.Name = name;
        this.Surname = surname;
    }   
    
    String getName() { return this.Name; }
    String getSurname() { return this.Surname; }

    public void show() {
        System.out.println("\nAbiturient: " + this.Surname + " " + this.Name);       
    }

    public void showResult() {
        System.out.println("Abiturient " + this.Surname + " " + this.Name + 
        " of faculty " + this.facultet.getFaculty() + " passed exams " + exam.show());
    }
}

class Faculty extends Abiturient {
    private String Namefacult, name, surname;

    Faculty(String name, String surname, String namefacult) {
        super(name, surname);
        this.name = name;
        this.surname = surname;
        this.Namefacult = namefacult;
    }
    
    String getFaculty() { return this.Namefacult; }

    void showFacult() {
        System.out.println("Abiturient " + this.name + " " 
        + this.surname + " registered with the faculty: " + this.Namefacult);
    }
}

class Exams {
    private String exam;
    static private ArrayList<Exams> exams = new ArrayList<Exams>();

    Exams(String Exam) {
        this.exam = Exam;
    }

    void setExams(Exams oun, Exams two) { 
        exams.add(oun); 
        exams.add(two);
    }

    ArrayList<Exams> getExams() { return exams; }

    String show() {
        return exams.get(0).exam + " and " + exams.get(1).exam;
    }
}

class Teacher extends Abiturient { // Обобщение
    private String name, surname;
    public int Assessment;

    Teacher(String name, String surname, Integer assessment) {
        super(name, surname);
        this.name = name;
        this.surname = surname;
        this.Assessment = assessment;
    }

    @Override
    public void show() {
        System.out.println("The teacher gave the grade " + this.Assessment 
        + " for student " + this.name + " " + this.surname);       
    }
}

class Assessment {
    private int max = 10;
    private int min = 0;

    Integer getAssessment() { return (int)(Math.random()*((max-min)+1))+min; }
}

interface Printable {
 
    void show();
}

public class EntranceExam {
    public static void main(String[] args) {
        HashMap<String, Integer> studentsResult = new HashMap<String, Integer>();
        Abiturient Putin = new Abiturient("Joseph", "Baiden");
        Putin.show();
        
        String Facultet = "FEIS";
        Exams math = new Exams("language");
        Exams history = new Exams("literature");
        Assessment assessment = new Assessment();
        math.setExams(math, history);
        ArrayList<Exams> exams = history.getExams();
        

        Putin = new Abiturient(Putin.getName(), Putin.getSurname(), Facultet, exams);
        Faculty facultet = new Faculty(Putin.getName(), Putin.getSurname(), Facultet);
        facultet.showFacult();
        Putin.showResult();

        Teacher Petya = new Teacher(Putin.getName(), Putin.getSurname(), assessment.getAssessment());
        Putin.assessment = Petya.Assessment;
        Petya.show();
        studentsResult.put(Putin.getSurname(), Putin.assessment);
        
        Abiturient Kim = new Abiturient("Bashar", "Asad");
        Kim.show();

        Kim = new Abiturient(Kim.getName(), Kim.getSurname(), Facultet, exams);
        Faculty facultet2 = new Faculty(Kim.getName(), Kim.getSurname(), Facultet);
        facultet2.showFacult();
        Kim.showResult();

        Teacher Petya2 = new Teacher(Kim.getName(), Kim.getSurname(), assessment.getAssessment());
        Kim.assessment = Petya2.Assessment;
        Petya2.show();
        studentsResult.put(Kim.getSurname(), Kim.assessment);

        System.out.println("\nStudents who passed the exams");
        for (Map.Entry<String, Integer> entry : studentsResult.entrySet())
            if (entry.getValue() >= 4)
                System.out.println(entry.getKey());
    }
}
