package lab3_3;

public class Lab3_3 {
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
        
        System.out.println(ceo);
        System.out.println("Его подчиненные:");
        System.out.println(ceo.getSubordinates().get(0).getSubordinates());
        System.out.println(ceo.getSubordinates());
        System.out.println();
        
        System.out.println(manager);
        System.out.println("Его подчиненные:");
        System.out.println(manager.getSubordinates().get(0).getSubordinates());
        System.out.println(manager.getSubordinates());
        System.out.println();
        
        System.out.println(worker);
        System.out.println("Его подчиненные:");
        System.out.println(worker.getSubordinates().get(0).getSubordinates());
        System.out.println(worker.getSubordinates());
        System.out.println();
        
        System.out.println(worker2);
        System.out.println();
        
        //сдесь вывод суммы
        company.logSalaries();
        System.out.println();
        company2.logSalaries();
        
        
    }  
}





