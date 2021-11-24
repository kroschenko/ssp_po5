package interfaces;

import entities.Patient;
import entities.Purpose;

public interface IDoctor {

    void executePurpose(Patient patient, Purpose purpose);
}
