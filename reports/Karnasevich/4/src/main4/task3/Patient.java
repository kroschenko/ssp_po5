package main4.task3;

import main5.task3.Status;
import main5.task3.Treatment;


public class Patient {

    private main5.task3.Treatment treatment;

    private main5.task3.Status status;

    public Patient() {
        this(main5.task3.Treatment.PILLS, main5.task3.Status.SICK);
    }

    public Patient(main5.task3.Treatment treatment, main5.task3.Status status) {
        this.treatment = treatment;
        this.status = status;
    }

    public void prescribeTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public void cure() {
        status = main5.task3.Status.HEALTHY;
    }

    public void violateRules() {
        status = main5.task3.Status.RULES_VIOLATED;
    }

    public Status getStatus() {
        return status;
    }
}
