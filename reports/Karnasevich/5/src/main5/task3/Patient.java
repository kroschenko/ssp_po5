package main5.task3;

public class Patient implements Curable {

    private Treatment treatment;

    private Status status;

    public Patient() {
        this(Treatment.PILLS, Status.SICK);
    }

    public Patient(Treatment treatment, Status status) {
        this.treatment = treatment;
        this.status = status;
    }

    @Override
    public void prescribeTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    @Override
    public void cure() {
        status = Status.HEALTHY;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    public void violateRules() {
        status = Status.RULES_VIOLATED;
    }
}
