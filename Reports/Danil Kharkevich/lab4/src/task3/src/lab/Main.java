package lab;

public class Main {

    public static void main(String[] args) {
        Faculty feis = new Faculty(Faculty.FacultyName.FEIS);
        Faculty msf = new Faculty(Faculty.FacultyName.MSF);

        Exam ex1 = new Exam(Exam.Subjects.Math);
        Exam ex2 = new Exam(Exam.Subjects.Physics);
        Exam ex3 = new Exam(Exam.Subjects.Language);

        Teacher teacher1 = new Teacher("Andrei", "Volkov", ex1);
        Teacher teacher2 = new Teacher("Michail", "Makoed", ex2);
        Teacher teacher3 = new Teacher("Anna", "Veremeuk", ex3);

        //FEIS
        Abiturient abit1 = new Abiturient("Marina", "Shostak");
        Abiturient abit2 = new Abiturient("Dmitry", "Sergievich");
        Abiturient abit3 = new Abiturient("Egor", "Yaroshuk");

        abit1.Register(feis);
        abit2.Register(feis);
        abit3.Register(feis);

        abit1.PassExam(teacher1.Rate(8), teacher1.getSubject());
        abit1.PassExam(teacher2.Rate(6), teacher2.getSubject());
        abit1.PassExam(teacher3.Rate(10), teacher3.getSubject());

        abit2.PassExam(teacher1.Rate(7), teacher1.getSubject());
        abit2.PassExam(teacher2.Rate(9), teacher2.getSubject());
        abit2.PassExam(teacher3.Rate(5), teacher3.getSubject());

        abit3.PassExam(teacher1.Rate(9), teacher1.getSubject());
        abit3.PassExam(teacher2.Rate(6), teacher2.getSubject());
        abit3.PassExam(teacher3.Rate(8), teacher3.getSubject());

        feis.showRegisteredAbiturients();
        feis.Reception();
        feis.showRecivedAbiturients();

        //msf
        Abiturient abit4 = new Abiturient("Pavel", "Tutin");
        Abiturient abit5 = new Abiturient("Katerina", "Kalinovskaya");
        Abiturient abit6 = new Abiturient("Roman", "Pigas");

        abit4.Register(msf);
        abit5.Register(msf);
        abit6.Register(msf);

        abit4.PassExam(teacher1.Rate(4), teacher1.getSubject());
        abit4.PassExam(teacher2.Rate(5), teacher2.getSubject());
        abit4.PassExam(teacher3.Rate(6), teacher3.getSubject());

        abit5.PassExam(teacher1.Rate(7), teacher1.getSubject());
        abit5.PassExam(teacher2.Rate(9), teacher2.getSubject());
        abit5.PassExam(teacher3.Rate(10), teacher3.getSubject());

        abit6.PassExam(teacher1.Rate(9), teacher1.getSubject());
        abit6.PassExam(teacher2.Rate(7), teacher2.getSubject());
        abit6.PassExam(teacher3.Rate(5), teacher3.getSubject());

        msf.showRegisteredAbiturients();
        msf.Reception();
        msf.showRecivedAbiturients();

    }
}
