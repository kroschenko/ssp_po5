package main4.task3;

import main5.task3.Medic;
import main5.task3.Patient;
import main5.task3.Treatment;
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
