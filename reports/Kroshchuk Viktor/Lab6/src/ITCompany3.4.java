package com.company;
import java.util.Iterator;

class ITCompany {

    private String name;
    private Employee ceo;

    public ITCompany(String name, Employee ceo) {
        this.name = name;
        this.ceo = ceo;
    }

    /* helper methods */

    private void logSalaries(Employee employee) {
        Iterator<Employee> iterator = employee.iterator();
        while (iterator.hasNext()) {
            Employee next = iterator.next();
            next.logSalary();
            logSalaries(next);
        }
    }

    public void logSalaries() {
        System.out.println("=============== SALARY LOG BEGIN =============== ");
        ceo.logSalary();
        logSalaries(ceo);
        System.out.println("=============== SALARY LOG END =============== ");
    }

    /* codegen */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getCeo() {
        return ceo;
    }

    public void setCeo(Employee ceo) {
        this.ceo = ceo;
    }

}
