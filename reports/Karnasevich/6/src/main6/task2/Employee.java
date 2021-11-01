package main6.task2;

import java.util.*;


public final class Employee {

    private final String name;

    private final Department department;

    private final Long salary;

    private final List<Employee> subordinates;

    private Employee manager;

    public Employee(String name, Department department, Long salary, Employee manager, List<Employee> subordinates) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.manager = manager;
        this.subordinates = subordinates;
    }

    public static Employee of(String name, Department department, Long salary) {
        return new Employee(name, department, salary, null, new ArrayList<>());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department, salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && department == employee.department && Objects.equals(salary, employee.salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }

    public void assignManager(Employee employee) {
        if (manager != null) {
            manager.subordinates.remove(this);
        }
        manager = employee;
        manager.subordinates.add(this);
    }

    public Boolean hasManager() {
        return manager != null;
    }

    public Optional<Employee> getManager() {
        return Optional.ofNullable(manager);
    }

    public Department getDepartment() {
        return department;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }
}
