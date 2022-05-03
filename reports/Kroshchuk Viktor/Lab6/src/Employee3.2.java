package lab3_3;

import java.util.ArrayList;

enum WorkDepartment {
    LEAD,
    RESEARCH,
    PROJECTS,
    MARKETING
}

enum WorkField {
    DESIGN,
    DEVELOPMENT,
    MANAGEMENT
}

class Employee implements EmployeeIterator {

    public static double MONEY_PER_PROJECT = 200;

    private String name;
    private int numProjects;
    private WorkDepartment department;
    private WorkField field;


    int position = 0;

    private ArrayList<Employee> subordinates = new ArrayList<>();

    public Employee(String name, int numProjects, WorkDepartment department, WorkField field) {
        this.name = name;
        this.numProjects = numProjects;
        this.department = department;
        this.field = field;
    }

    /* helper methods */

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }

    public void removeSubordinate(Employee employee) {
        subordinates.remove(employee);
        employee.removeAllSubordinates();
    }

    public void removeAllSubordinates() {
        for (Employee e: subordinates) {
            e.removeAllSubordinates();
            e.subordinates.clear();
        }
        subordinates.clear();
    }

    public void logSalary() {
        System.out.printf("%s%s его зарплата: %f$\n", " ", name, MONEY_PER_PROJECT * numProjects);
    }

    /* java.lang.Object */

    @Override
    public String toString() {
        return String.format(
            "<Employee имя=\"%s\" назв_проекта=\"%d\" отдел=\"%s\" сфера=\"%s\" подчинение=<arrayList of \"%d\" elements>>",
            name, numProjects, department.name(), field.name(), subordinates.size()
        );
    }

    /* codegen */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNumProjects() {
        return numProjects;
    }

    public void setNumProjects(int numProjects) {
        this.numProjects = numProjects;
    }

    public WorkDepartment getDepartment() {
        return department;
    }

    public void setDepartment(WorkDepartment department) {
        this.department = department;
    }

    public WorkField getField() {
        return field;
    }

    public void setField(WorkField field) {
        this.field = field;
    }

    public ArrayList<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public boolean hasNext() {
        return position < subordinates.size();
    }

    @Override
    public Employee next() {
        if (!hasNext()) {
            return null;
        }
        Employee employee = subordinates.get(position);
        position++;
        return employee;
    }

    @Override
    public void reset() {
        position = 0;
    }

    /* Iterable */

}
