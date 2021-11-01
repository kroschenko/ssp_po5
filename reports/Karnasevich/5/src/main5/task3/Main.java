package main5.task3;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        var clinic = new Clinic(
                new ArrayList<>() {{
                    add(new Doctor());
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
