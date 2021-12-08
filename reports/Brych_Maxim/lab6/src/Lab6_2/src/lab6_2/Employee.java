package lab6_2;
import java.util.ArrayList;
import java.util.Iterator;

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

class Employee implements Iterable<Employee> {

    public static double MONEY_PER_PROJECT = 200;

    private String name;
    private int numProjects;
    private WorkDepartment department;
    private WorkField field;

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

    /* Iterable */

    @Override
    public Iterator<Employee> iterator() {
        return new EmployeeIterator(subordinates);
    }
}
