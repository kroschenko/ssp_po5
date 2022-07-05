import entities.Doctor;
import entities.MainDoctor;
import entities.Patient;
import entities.Purpose;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MainDoctor mainDoctor = new MainDoctor(23, "Доктор", "Айболит");

        Doctor doctor = new Doctor(35, "Крокодил", "Гена", 1);
        Doctor nurse = new Doctor(37, "Чебу", "рашка", 0);

        Patient patient = new Patient(50, "Иван", "Бывалый");

        Purpose purpose1 = new Purpose("Анальгин", 1);
        purpose1.setCountOfDay(3);
        Purpose purpose2 = new Purpose("Массаж спины", 0);
        purpose2.setCountOfDay(1);
        Purpose purpose3 = new Purpose("Удаление аденоидов", 2);

        ArrayList<Purpose> purposes = new ArrayList<>();
        purposes.add(purpose1);
        purposes.add(purpose2);
        purposes.add(purpose3);

        mainDoctor.makePurposes(patient, purposes);

        patient.print();

        for(int i=0; i<5; i++)
            System.out.println();

        nurse.executePurpose(patient, purpose1);
        doctor.executePurpose(patient, purpose3);
        nurse.executePurpose(patient, purpose1);
        nurse.executePurpose(patient, purpose2);
        nurse.executePurpose(patient, purpose1);

        mainDoctor.dischargePatient(patient, 1);

        patient.print();
    }
}
