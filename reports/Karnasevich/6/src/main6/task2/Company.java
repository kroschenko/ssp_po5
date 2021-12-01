package main6.task2;

import java.util.*;


public final class Company {

    private final List<Employee> employees;

    public Company(List<Employee> employees) {
        this.employees = employees;
    }

    public Company() {
        this(new ArrayList<>());
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void fire(Employee employee) {
        employees.stream()
                .filter(Employee::hasManager)
                .filter(e -> e.getManager().orElseThrow().equals(employee))
                .forEach(e -> e.assignManager(employee.getManager().orElse(null)));
    }

    public void printSalaryReport() {
        var it = new FlattenIterator<>(new HierarchicalEmployeeIterator(employees));
        while (it.hasNext()){
            var next = it.next();
            System.out.println(next);
        }
    }
}
