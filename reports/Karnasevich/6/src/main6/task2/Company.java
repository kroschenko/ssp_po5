package main6.task2;

import java.util.*;
import java.util.stream.Collectors;


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

    public void pringSalaryReport() {
        var group = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        for (var list : group.entrySet()) {
            printSalaryReport(list.getKey(), list.getValue());
        }
    }

    public void printSalaryReport(Department department, List<Employee> employees) {
        var leaders =
                employees.stream()
                        .filter(x -> !x.hasManager() || x.getManager().isPresent() && !x.getManager().get().getDepartment().equals(department))
                        .collect(Collectors.toList());
        var rest = new HashSet<>(employees);
        while (!rest.isEmpty()) {
            leaders.forEach(rest::remove);
            leaders.forEach(System.out::println);
            leaders = leaders.stream()
                    .flatMap(x -> x.getSubordinates().stream())
                    .filter(x -> x.getDepartment().equals(department))
                    .collect(Collectors.toList());
        }
    }
}
