package entities;

import java.util.ArrayList;

public class Patient extends Person {

    private int status; // 0 - лечится, 1 - выписан по окончанию лечения, 2 - выписан из-за нарушения режима, 3 - выписан при иных обстоятельствах
    private final ArrayList<Purpose> history;

    public Patient(int id, String name, String surname) {
        super(id, name, surname);
        status=0;
        history = new ArrayList<>();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void addToHistory(Purpose purpose){
        history.add(purpose);
    }

    public void print(){
        System.out.print(super.toString());
        System.out.print(", статус: ");
        if(status==0)
            System.out.println("лечится");
        else if(status==1)
            System.out.println("выписан по окончанию лечения");
        else if(status==2)
            System.out.println("выписан из-за нарушения режима");
        else if(status==3)
            System.out.println("выписан при иных обстоятельствах");

        System.out.println("История действий:");
        for (Purpose purpose : history) System.out.println(purpose.toString());
    }

}
