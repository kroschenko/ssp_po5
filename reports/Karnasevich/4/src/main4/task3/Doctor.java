package main4.task3;

import java.util.*;


public class Doctor extends Medic {

    public final Set<Patient> patients;

    public Doctor() {
        this(new HashSet<>());
    }

    public Doctor(Set<Patient> patients) {
        this.patients = patients;
    }

    public void prescribeTreatment(Patient patient) {
        var treatments = Treatment.values();
        var treatment = treatments[new Random().nextInt(treatments.length)];
        patient.prescribeTreatment(treatment);
        patients.add(patient);
    }
}
