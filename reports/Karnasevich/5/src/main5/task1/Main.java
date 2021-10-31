package main5.task1;

import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        var m = new Manager();
        var e = new Engineer();
        var employees = Arrays.<Employee>asList(m, e);
        employees.forEach(Employee::work);
    }
}
