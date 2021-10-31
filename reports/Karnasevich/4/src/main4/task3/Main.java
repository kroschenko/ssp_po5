package main4.task3;

import main5.task3.Clinic;
import main5.task3.Doctor;
import main5.task3.Nurse;
import main5.task3.Patient;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        var clinic = new Clinic(
                new ArrayList<>() {{
                    add(new main5.task3.Doctor());
                    add(new Doctor());
                }},
                new ArrayList<>() {{
                    add(new Nurse());
                }}
        );
        var patient = new Patient();
        clinic.registerPatient(patient);
        clinic.cureAll();
        clinic.dischargeAll();
    }
}
