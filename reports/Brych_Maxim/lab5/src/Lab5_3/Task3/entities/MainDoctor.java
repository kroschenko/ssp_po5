package entities;

import interfaces.IMainDoctor;

import java.util.ArrayList;

public class MainDoctor extends Doctor implements IMainDoctor {

    public MainDoctor(int id, String name, String surname) {
        super(id, name, surname, 1);
    }

    public void makePurposes(Patient patient, ArrayList<Purpose> purposes) {
        for (Purpose purpose : purposes) {
            Purpose purpose1 = purpose.clone();
            purpose1.updateTime();
            purpose1.setDoctor(this);
            patient.addToHistory(purpose1);
        }
    }
    public void dischargePatient(Patient patient, int reason){
        patient.setStatus(reason);
    }
}
