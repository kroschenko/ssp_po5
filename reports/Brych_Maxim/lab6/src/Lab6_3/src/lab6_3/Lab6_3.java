package lab6_3;

public class Lab6_3 {
        public static void main(String[] args) {
                Employee ceo = new Employee("Raman Harhun", 5, WorkDepartment.LEAD, WorkField.MANAGEMENT);
                ITCompany company = new ITCompany("Harbros Solutions", ceo);

                Employee manager = new Employee("Tsimafei Harhun", 4, WorkDepartment.LEAD, WorkField.MANAGEMENT);
                ITCompany company2 = new ITCompany("EPAM", manager);

                Employee worker = new Employee("Ilya Kulinkovich", 10, WorkDepartment.PROJECTS, WorkField.DEVELOPMENT);

                Employee worker2 = new Employee("Yana Danilyuk", 8, WorkDepartment.PROJECTS, WorkField.DESIGN);

                ceo.addSubordinate(manager);
                manager.addSubordinate(worker);
                worker.addSubordinate(worker2);
                show(ceo);
                show(manager);
                show(worker2);


                //сдесь вывод суммы
                company.logSalaries();
                System.out.println();
                company2.logSalaries();
        }

        private static void show(Employee obj) {
                System.out.println(obj);
                if (!obj.getSubordinates().isEmpty()) {
                        System.out.println("Его подчиненные:");
                        showSubord(obj);
                }

                System.out.println();
        }

        private static void showSubord(Employee obj) {
                if (!obj.getSubordinates().isEmpty()) {
                        System.out.println(obj.getSubordinates());
                        for (Employee employee : obj.getSubordinates()) {
                                if (!employee.getSubordinates().isEmpty()) {
                                        System.out.println(employee.getSubordinates());
                                        showSubord(employee);
                                }
                        }
                }
        }
}





