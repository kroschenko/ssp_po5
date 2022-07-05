package entities;

import interfaces.IDoctor;

public class Doctor extends Person implements IDoctor {

    private int type; //0 - медсестра, 1 - доктор

    public Doctor(int id, String name, String surname, int type) {
        super(id, name, surname);
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void executePurpose(Patient patient, Purpose purpose){
        Purpose donePurpose = purpose.clone();
        donePurpose.setDoctor(this);
        donePurpose.updateTime();
        donePurpose.setDone(true);

        patient.addToHistory(donePurpose);
    }
}
