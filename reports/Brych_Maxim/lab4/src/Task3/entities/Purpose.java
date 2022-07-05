package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Purpose {
    private String name;
    private int type; //0 - процедура, 1 - лекарство, 2 - операция
    private LocalDateTime time;
    private int countOfDay;
    private Doctor doctor;
    private boolean isDone = false;

    public Purpose(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getCountOfDay() {
        return countOfDay;
    }

    public void setCountOfDay(int countOfDay) {
        this.countOfDay = countOfDay;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void updateTime(){
        time = LocalDateTime.now();
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();

        builder.append(time.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        builder.append(" пациенту");

        if(!isDone)
            builder.append(" дано");
        else
            builder.append(" проведено");
        builder.append(" назначение, название: ").append(name).append(", тип: ");
        if(type==0)
            builder.append("процедура");
        else if(type==1)
            builder.append("лекарство");
        else
            builder.append("операция");

        builder.append(", доктор: "+doctor.getName()+" "+doctor.getSurname());

        if(type!=2 && !isDone)
            builder.append(", число в день: "+countOfDay);

        return builder.toString();
    }

    public Purpose clone(){
        Purpose purpose = new Purpose(this.name, this.type);
        purpose.doctor = doctor;
        purpose.time = time;
        purpose.countOfDay = countOfDay;
        purpose.isDone = isDone;
        return purpose;
    }
}
