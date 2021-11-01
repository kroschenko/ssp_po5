package main4.task3;

public class Patient {

    private Treatment treatment;

    private Status status;

    public Patient() {
        this(Treatment.PILLS, Status.SICK);
    }

    public Patient(Treatment treatment, Status status) {
        this.treatment = treatment;
        this.status = status;
    }

    public void prescribeTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public void cure() {
        status = Status.HEALTHY;
    }

    public void violateRules() {
        status = Status.RULES_VIOLATED;
    }

    public Status getStatus() {
        return status;
    }
}
