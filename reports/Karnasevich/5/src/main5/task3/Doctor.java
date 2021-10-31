package main5.task3;

import java.util.*;


public class Doctor extends Medic {

    public final Set<Curable> patients;

    public Doctor() {
        this(new HashSet<>());
    }

    public Doctor(Set<Curable> patients) {
        this.patients = patients;
    }

    public void prescribeTreatment(Curable patient) {
        var treatments = Treatment.values();
        var treatment = treatments[new Random().nextInt(treatments.length)];
        patient.prescribeTreatment(treatment);
        patients.add(patient);
    }
}
