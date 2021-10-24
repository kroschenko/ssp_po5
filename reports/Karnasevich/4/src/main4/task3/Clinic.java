package main4.task3;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;


public class Clinic {

    private final List<Doctor> doctors;

    private final List<Nurse> nurses;

    public Clinic(List<Doctor> doctors, List<Nurse> nurses) {
        this.doctors = doctors;
        this.nurses = nurses;
    }

    public void registerPatient(Patient patient) {
        var doctor = List.copyOf(doctors).get(new Random().nextInt(doctors.size()));
        doctor.prescribeTreatment(patient);
    }

    public void cureAll() {
        applyToAllPatients((d, p) -> {
            if (Math.random() > 0.5) {
                var docs = doctors.stream().filter(doc -> !doc.equals(d)).collect(Collectors.toList());
                var doc = docs.get(new Random().nextInt(docs.size()));
                doc.cure(p);
            } else {
                var nurse = nurses.get(new Random().nextInt(nurses.size()));
                nurse.cure(p);
            }
        });
    }

    public void dischargeAll() {
        applyToAllPatients((d, p) -> {
            if (p.getStatus().equals(Status.HEALTHY) || p.getStatus().equals(Status.RULES_VIOLATED)) {
                d.patients.remove(p);
            }
        });
    }

    public void applyToAllPatients(BiConsumer<Doctor, Patient> doctorPatientBiConsumer) {
        for (var doc : doctors) {
            for (var pat : doc.patients) {
                doctorPatientBiConsumer.accept(doc, pat);
            }
        }
    }
}
