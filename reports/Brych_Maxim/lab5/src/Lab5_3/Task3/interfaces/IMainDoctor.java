package interfaces;

import entities.Patient;
import entities.Purpose;

import java.util.ArrayList;

public interface IMainDoctor {

    void makePurposes(Patient patient, ArrayList<Purpose> purposes);
    void dischargePatient(Patient patient, int reason);
}
