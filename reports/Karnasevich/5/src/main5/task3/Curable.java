package main5.task3;

public interface Curable {

    void prescribeTreatment(Treatment treatment);

    void cure();

    Status getStatus();
}
