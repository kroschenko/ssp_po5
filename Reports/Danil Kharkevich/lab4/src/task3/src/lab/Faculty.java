package lab;
import java.util.ArrayList;

public class Faculty {
    public enum FacultyName {
        FEIS,
        SF,
        MSF,
        FISE
    }
    private FacultyName name;
    private ArrayList<Abiturient> RegisteredAbiturients = new ArrayList<>();
    private ArrayList<Abiturient> ReceivedAbiturients = new ArrayList<>();


    public Faculty (FacultyName _name) {
        name = _name;
    }

    public void AddAbiturientToFaculty (Abiturient abit) {
        RegisteredAbiturients.add(abit);
    }

    public void Reception () {
        for (Abiturient _abit:RegisteredAbiturients) {
            if (_abit.GetAverage() > 6) ReceivedAbiturients.add(_abit);
        }

    }

    public void showRegisteredAbiturients() {
        System.out.println("Registered abiturients to " + name);
        for (Abiturient abit: RegisteredAbiturients)
            System.out.println(abit.toString());
        System.out.println('\n');
    }

    public void showRecivedAbiturients () {
        System.out.println("Received abiturients to " + name);
        for (Abiturient abit: ReceivedAbiturients)
            System.out.println(abit.toSmallString());
        System.out.println('\n');
    }

}
