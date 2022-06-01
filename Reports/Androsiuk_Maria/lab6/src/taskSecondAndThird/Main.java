package taskSecondAndThird;

public class Main {

    public static void main(String[] args) {
        // task 2
        Employee ceo = new Employee("Ivanov Ivan", 2, WorkDepartment.RESEARCH, WorkField.DESIGN);
        ITCompany company = new ITCompany("Harbros Solutions", ceo);
        Employee manager = new Employee("Petrov Petr", 6, WorkDepartment.MARKETING, WorkField.MANAGEMENT);
        ceo.addSubordinate(manager);
        Employee worker = new Employee("Sidorov Stanislav", 9, WorkDepartment.LEAD, WorkField.DEVELOPMENT);
        manager.addSubordinate(worker);
        System.out.println(ceo.getSubordinates().get(0).getSubordinates());
        manager.removeAllSubordinates();
        System.out.println(ceo.getSubordinates());
        System.out.println(ceo);

        // task 3
        manager.addSubordinate(worker);
        ceo.addSubordinate(new Employee("Andreev Vladimir", 8, WorkDepartment.PROJECTS, WorkField.DESIGN));
        company.logSalaries();
    }

}
